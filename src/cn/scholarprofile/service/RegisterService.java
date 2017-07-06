package cn.scholarprofile.service;

import cn.scholarprofile.bean.UserInfo;


public interface RegisterService {

	/**
	 * 
	 * @Description:注册用户信息
	 * @param username
	 * @param password
	 * @param phone
	 * @param email
	 * @return
	 * int
	 * @exception:
	 */
	public int register(String username, String password, String phone, String email);
	
	/**
	 * 
	 * @Description:根据用户名检测用户是否存在
	 * @param name
	 * @return
	 * boolean
	 * @exception:
	 */
	public boolean isExist(String username);
	
	/**
	 * 
	 * @Description:完善用户信息
	 * @param u
	 * @return
	 * int
	 * @exception:
	 */
	public int completeInfo(UserInfo u);
	
}
