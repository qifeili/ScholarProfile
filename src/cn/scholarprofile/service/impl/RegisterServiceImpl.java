package cn.scholarprofile.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.dao.UserInfoDao;
import cn.scholarprofile.service.RegisterService;
import cn.scholarprofile.util.MD5andKL;

@Service("registerService")
@Transactional
public class RegisterServiceImpl implements RegisterService {

	private UserInfoDao userInfoDao;

	/**
	 * @return the userInfoDao
	 */
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	/**
	 * @param userInfoDao
	 *            the userInfoDao to set
	 */
	@Resource
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}


	/**
	 * @Description:注册信息
	 * @exception:
	 */
	@Override
	public int register(String username, String password, String phone,
			String email) {
		if (!isExist(username)) {//如果用户名未被注册过，允许注册并且返回注册后的id
			UserInfo u = new UserInfo();
			u.setUsername(username);
			u.setPassword(MD5andKL.MD5KL(password));
			u.setPhone(phone);
			u.setEmail(email);
			
			userInfoDao.save(u);
			
			return u.getId();
		} else //如果用户名已被注册过，则注册失败，返回-1
			return -1;
	}

	
	@Override
	public boolean isExist(String username) {
		return userInfoDao.isExist(username);
	}

	
	@Override
	public int completeInfo(UserInfo u) {
		
		userInfoDao.update(u);
		return u.getId();
	}

	
}
