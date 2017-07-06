package cn.scholarprofile.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.dao.UserInfoDao;

@Component("userInfoDao")
@Transactional
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao {

	/**
	 * @Description:根据用户名检测用户信息是否存在
	 * @exception:
	 */
	@Override
	public boolean isExist(String username) {
		List<UserInfo> users = this.find("From UserInfo where username = '" + username + "'");
		
		if (users.size() > 0) 
			return true;
		else
			return false;
	}
	
	/**
	 * @Description:根据第三方用户名检测用户信息是否存在
	 * @exception:
	 */
	@Override
	public boolean isExist(String openID, int type) {
		List<UserInfo> users = this.find("From UserInfo where thirdPartyUsername = '" + openID + "' and registerType = '" + type + "'");
		
		if (users.size() > 0) 
			return true;
		else
			return false;
	}

	/** @Description:根据邮箱登录
	 * @exception:
	 */
	@Override
	public int checkLoginWithEmail(String email, String MD5Password) {
		
		List<UserInfo> users = this.find("From UserInfo where email = '" + email + "' and password = '" + MD5Password + "'");
		
		if (users.size() > 0) 
			return users.get(0).getId();
		else
			return -1;
	}

	/** @Description:根据手机号登录
	 * @exception:
	 */
	@Override
	public int checkLoginWithNumber(String registerNumber,
			String MD5Password) {
		
		List<UserInfo> users = this.find("From UserInfo where registerNumber = '" + registerNumber + "' and password = '" + MD5Password + "'");
		
		if (users.size() > 0) 
			return users.get(0).getId();
		else
			return -1;
	}

	/** @Description:检测目标邮箱是否注册过
	 * @exception:
	 */
	@Override
	public boolean checkTargetMailboxIsRegisterd(String targetMailbox) {
		
		List<UserInfo> users = this.find("From UserInfo where email = '" + targetMailbox + "'");
		
		if (users.size() > 0) 
			return true;
		else
			return false;
	}

	/** @Description:根据邮箱获取记录
	 * @exception:
	 */
	@Override
	public UserInfo getByEmail(String email) {
		return this.get("From UserInfo where email = '" + email + "'");
	}
	
	

}
