package cn.scholarprofile.dao;

import cn.scholarprofile.bean.UserInfo;


public interface UserInfoDao extends BaseDao<UserInfo>{
	
	/**
	 * @Description:根据用户名检测用户信息是否存在
	 * @exception:
	 */
	public boolean isExist(String username);
	
	/**
	 * @Description:根据第三方用户名检测用户信息是否存在
	 * @exception:
	 */
	public boolean isExist(String openID, int type);
	
	/**
	 * @Description:根据邮箱注册
	 * @exception:
	 */
	public int checkLoginWithEmail(String email, String MD5Password);
	
	/**
	 * @Description:根据手机号注册
	 * @exception:
	 */
	public int checkLoginWithNumber(String registerNumber, String MD5Password);
	
	/**
	 * @Description:检测目标邮箱是否注册过
	 * @exception:
	 */
	public boolean checkTargetMailboxIsRegisterd(String targetMailbox);
	
	/**
	 * @Description:根据邮箱获取记录
	 * @exception:
	 */
	public UserInfo getByEmail(String email);
}