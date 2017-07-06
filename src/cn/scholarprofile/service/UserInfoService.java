package cn.scholarprofile.service;

import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.dto.UserIndexAccount;
import cn.scholarprofile.dto.UserInfoRegistStep01;
import cn.scholarprofile.dto.UserInfoRegistStep02;

public interface UserInfoService {

	/**
	 * @Description:用邮箱或者手机号码注册
	 * @exception:
	 */
	public abstract int register(String emailOrNumber, String password) throws Exception;
	/**
	 * @Description:用邮箱注册
	 * @exception:
	 */
	public abstract int registerWithEmail(String email, String password) throws Exception;
	
	/**
	 * @Description:用手机号码注册
	 * @exception:
	 */
	public abstract int registerWithNumber(String number, String password) throws Exception;	
	
	/**
	 * @Description:删除一个用户
	 * @exception:
	 */
	public abstract void delete(UserInfo u) throws Exception;
	
	/**
	 * @Description:根据id删除一个用户
	 * @exception:
	 */
	public abstract void deleteById(int id) throws Exception;
	
	
	/**
	 * @Description:根据用户名判断用户是否存在
	 * @exception:
	 */
	public boolean isExist(String username);
	
	/**
	 * @Description:根据第三方用户名判断用户是否存在
	 * @exception:
	 */
	public boolean isExist(String openID, int type);
	
	/**
	 * @Description:根据id获取用户名
	 * @exception:
	 */
	public abstract String getUsernameById(int userInfoId) throws Exception;
	
	/**
	 * @Description:根据id获取第三方用户名
	 * @exception:
	 */
	public abstract String getThirdPartyUsernameById(int userInfoId) throws Exception;
	
	/**
	 * @Description:注册后用户完善个人信息的第一步
	 * @exception:
	 */	
	public abstract String completeInfoStep01(int userInfoId, UserInfoRegistStep01 info) throws Exception;
	
	/**
	 * @Description:注册后用户完善个人信息的第二步
	 * @exception:
	 */
	public abstract String completeInfoStep02(int userInfoId, UserInfoRegistStep02 info) throws Exception;
	
	/**
	 * @Description:通过第三方注册，1代表QQ，2代表微信，3代表新浪微博
	 * @exception:
	 */
	public abstract int registerInThirdParty(String openID, int registerType) throws Exception;
	
	/**
	 * @Description:手机号或者邮箱登录
	 * @exception:
	 */
	public abstract int login(String emailOrNumber, String password) throws Exception;
	
	/**
	 * @Description:用邮箱登录
	 * @exception:
	 */
	public abstract int loginWithEmail(String email, String password) throws Exception;
	
	/**
	 * @Description:用手机号码登录
	 * @exception:
	 */
	public abstract int loginWithNumber(String number, String password) throws Exception;
	
	/**
	 * @Description:给邮箱发送验证码
	 * @exception:
	 */
	public abstract Boolean getMailboxVerificationCode(String targetMailbox) throws Exception;
	
	/**
	 * @Description:校验验证码
	 * @exception:
	 */
	public abstract Boolean compareMailboxVerificationCode(String mailbox, String verificationCode, String newPassword) throws Exception;

	/**
	 * @Description:用户帐号信息处理
	 * @exception:
	 */
	public abstract UserIndexAccount userIndexAccount(int userInfoId) throws Exception;
	
	/**
	 * @Description:修改密码
	 * @exception:
	 */
	public abstract Boolean changePassword(Integer userInfoId, String oldPassword, String newPassword) throws Exception;
}
