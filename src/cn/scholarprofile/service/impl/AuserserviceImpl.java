package cn.scholarprofile.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Service;

import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.dao.UserInfoDao;
import cn.scholarprofile.dao.auserDao;
import cn.scholarprofile.service.Auserservice;
import cn.scholarprofile.util.DateUtil;
/**
 * @author 李齐飞 
 * @date : 2016年07月24日 
 * @Email:  716716fei@sina.com
 */
@Service
public class AuserserviceImpl implements Auserservice{
	
@Resource 
private auserDao  auserDao;  
    
@Resource
private HttpServletRequest request;

	@Override
	public List<UserInfo> getalluser() {
		return auserDao.getAlluser();
	}

	@Override
	public void addUser(UserInfo user) {
		 auserDao.addUser(user);
	}

	@Override
	public UserInfo getuser(String id) {
		return auserDao.getUser(id);
	}

	@Override
	public boolean deluser(String id) {
		return auserDao.del(id);
	}

	@Override
	public boolean update(UserInfo user) {		
		return auserDao.update(user);
	}

     @Override
	public boolean login(String keeper,String password) {
    	 if(keeper==null||password==null||keeper.equals("")||password.trim().equals("")){
    			request.setAttribute("error" ,"用户名或密码不能为空!");		
    			return false;}
    	 else
    	 return auserDao.login(keeper,password);
}

	@Override
	public boolean mima(String keeper, String oldpassword, String newpassword) {
		String oldmima=auserDao.oldmima(keeper);
		if(oldpassword.equals(oldmima)){
			auserDao.newmima(newpassword,keeper);	
			return true;
		}
			return false;
	}

	@Override
	public void pl() {
	auserDao.paperlist();
		
	}
}