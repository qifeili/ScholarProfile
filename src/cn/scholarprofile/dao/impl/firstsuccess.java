package cn.scholarprofile.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.dao.impl.auserDaoImpl;

public class firstsuccess extends auserDaoImpl {
	@Resource
	   private static SessionFactory sessionFactory;  
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}





	public static void main(String[] args) {		
		firstsuccess f=new firstsuccess();
		     int id=0;
		for(id=1;id<=1097;id++){
			System.out.println(id);
			Query query=sessionFactory.getCurrentSession().createQuery("from UserInfo u where u.id=?");
		   query.setInteger(0, id);
		   UserInfo u=(UserInfo) query;
		   System.out.println(u.getRealName());
	/*	auserDaoImpl a=new auserDaoImpl();
		
		a.paperlist();
			
			System.out.println("通了吗？");*/
		}

	}
}
	

