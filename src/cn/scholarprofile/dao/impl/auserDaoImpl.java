package cn.scholarprofile.dao.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;  
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Administrators;
import cn.scholarprofile.bean.Baiduscholar;
import cn.scholarprofile.bean.Focus;
import cn.scholarprofile.bean.Project;
import cn.scholarprofile.bean.Scholar;
import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.dao.UserInfoDao;
import cn.scholarprofile.dao.auserDao;
import cn.scholarprofile.util.DateUtil;
/**
 * @author 李齐飞 
 * @date : 2016年07月24日 
 * @Email:  716716fei@sina.com
 */
@Repository
@Transactional
@Service
public class auserDaoImpl implements auserDao  {

	@Resource
	   private SessionFactory sessionFactory;  
	@Resource
	private HttpServletRequest request;
    @Override  
    public void addUser(UserInfo user) {  
        sessionFactory.getCurrentSession().save(user);  
    }

   
@Override 
	public List<UserInfo> getAlluser(){
	//	String hql="from UserInfo";
		Query query=sessionFactory.getCurrentSession().createQuery("from UserInfo");	
		return query.list();
		}

	@Override
	public UserInfo getUser(String id) {
		Query query = sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.id=?");  
		query.setString(0,id);
	     return (UserInfo)query.uniqueResult(); 
	}

	@Override
	public boolean del(String id) {
		Query query1 = sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.id=?");  
		query1.setString(0,id);
		UserInfo pro=(UserInfo) query1.uniqueResult();
		Set<Project> i=pro.getProjects();
		System.out.println(i.size());
    if(i.isEmpty()){
		Query query2=sessionFactory.getCurrentSession().createQuery("delete UserInfo u where u.id=?");
	  query2.setString(0, id);
	  // query.setLong(0, Integer.valueOf(id));
      return (query2.executeUpdate()>0);
    }else      
    	return false ; 
    }
/*	Query query=sessionFactory.getCurrentSession().createQuery("from Administrators where username='"+keeper+"'and password='"+password+"'");
	List<Administrators> adm=query.list();
	
	if(adm.size()!=0){
	return true; */
	
	@Override
	public boolean update(UserInfo user) {
		String hql="update UserInfo user set user.username =?,user.password=?, user.email=?,  user.realName=?,  user.birthday=?,  user.sex=?, user.maxDegree=? ,user.worklife=?, user.workPlace=?, user.industryAndFunctional=?,  user.companyName=?,  user.curPosition=?, user.phone=?, user.interestField=?,"
	+ "user.registerNumber=?, user.registerType=?,  user.thirdPartyUsername=? where user.id=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		query.setString(2, user.getEmail());
		query.setString(3, user.getRealName());
		query.setDate(4,user.getBirthday());
		query.setString(5, user.getSex());
		query.setString(6, user.getMaxDegree());
		query.setString(7, user.getWorklife());
		query.setString(8, user.getWorkPlace());
		query.setString(9, user.getIndustryAndFunctional());
		query.setString(10, user.getCompanyName());
		query.setString(11, user.getCurPosition());
		query.setString(12, user.getPhone());
		query.setString(13, user.getInterestField());
		query.setString(14, user.getRegisterNumber());
		query.setLong(15, user.getRegisterType());
		query.setString(16, user.getThirdPartyUsername());
		query.setLong(17,user.getId());
		return (query.executeUpdate()>0);
	}

	@Override
	public Boolean login(String keeper, String password) {
		Query query=sessionFactory.getCurrentSession().createQuery("from Administrators where username='"+keeper+"'and password='"+password+"'");
		List<Administrators> adm=query.list();
		
		if(adm.size()!=0){
		return true; 
		}
	  else{
			request.setAttribute("error", "用户名或密码错误!");
			return false;
	  }
	}
	
	@Override//(1)取出旧密码去service层比较。
	public String oldmima(String keeper){
		Query query=sessionFactory.getCurrentSession().createQuery("from Administrators where username='"+keeper+"'");
		Administrators adn=(Administrators) query.uniqueResult();
		String m=adn.getPassword();
		return m;
	}	@Override//(2)将修改后的新密码更新到数据库中
	public void newmima(String newpassword,String keeper) {
		// TODO 自动生成的方法存根
		Query query=sessionFactory.getCurrentSession().createQuery("update Administrators a set a.password='"+newpassword+"' where a.username='"+keeper+"'");
               query.executeUpdate();
               request.getSession().setAttribute("update", "管理员密码已更新成功");
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//把official中的paperlist导入到scholar表中的paperlist中。
	@Override      
    	public  String paperlist(){
		int id=0;
		
		for(id=1;id<=1097;id++){
			//第一步：取出scholar的name值。
			Query query=sessionFactory.getCurrentSession().createQuery("from Scholar where id='"+id+"'");
		   Scholar s=(Scholar) query.uniqueResult();
		   String sname=s.getName();
		   System.out.println(id+sname);		   
		   //2.根据name值找到对应的paperlist（并分析其唯一性）。
	Query query2=sessionFactory.getCurrentSession().createQuery("from Baiduscholar where name='"+sname+"'");
	   List<Baiduscholar> baidus=query2.list();
	   System.out.println("名字相同数："+baidus.size());
	   if(baidus.size()==1){                                      //查询记录匹配。
	Baiduscholar b=(Baiduscholar) query2.uniqueResult();
		//将 查询到的paperlist信息 存入scholar中。		
		 Query query4=sessionFactory.getCurrentSession().createQuery("update Scholar s set s.paperlist='"+b.getPaperlist()+"'where s.id='"+id+"'");
	     if(query4.executeUpdate()>0){
		 System.out.println("成功@！");}
	   }
	   if(baidus.size()==0){                                        //未找到这个学者的信息。
		   System.out.println("这条信息未找到！"); 
	break;
	     }
	   else{                                                                        //找到多条该学者信息，加入university重新查询。
		   Query query3=sessionFactory.getCurrentSession().createQuery("from Baiduscholar where name='"+sname+"'and university='"+s.getInstitution()+"'");
		   List<Baiduscholar> baidus2=query3.list();
		   System.out.println("名字和学校相同数量："+baidus2.size());
		   Baiduscholar b=baidus2.get(0);
			//将 查询到的paperlist信息 存入scholar中。		
		   Query query4=sessionFactory.getCurrentSession().createQuery("update Scholar s set s.paperlist='"+b.getPaperlist()+"' where s.id='"+id+"'");
		   if(query4.executeUpdate()>0){
				 System.out.println("成功@！");
				 }
			   }
	   }
		request.setAttribute("paperlist", "paperlist导入成功！");
		return null;
		}
		
}
