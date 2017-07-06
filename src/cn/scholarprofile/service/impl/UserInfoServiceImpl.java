package cn.scholarprofile.service.impl;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.bean.VerificationCode;
import cn.scholarprofile.dao.UserInfoDao;
import cn.scholarprofile.dao.VerificationCodeDao;
import cn.scholarprofile.dto.UserIndexAccount;
import cn.scholarprofile.dto.UserInfoRegistStep01;
import cn.scholarprofile.dto.UserInfoRegistStep02;
import cn.scholarprofile.service.UserInfoService;
import cn.scholarprofile.util.EmailUtil;
import cn.scholarprofile.util.MD5andKL;
import cn.scholarprofile.util.NumberUtil;

@Service("userInfoService")
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

	private UserInfoDao userInfoDao;
	private VerificationCodeDao verificationCodeDao;

	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	@Resource
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public VerificationCodeDao getVerificationCodeDao() {
		return verificationCodeDao;
	}

	@Resource
	public void setVerificationCodeDao(VerificationCodeDao verificationCodeDao) {
		this.verificationCodeDao = verificationCodeDao;
	}

	/**
	 * @Description:用邮箱或者手机号码注册
	 * @exception:
	 */
	@Override
	public int register(String emailOrNumber, String password) throws Exception {
		
		//用正则表达式分析用户使用邮箱注册还是手机号码注册
		String regexEmail = "^[\\w-]+(\\.[\\w-]+)*\\@([\\.\\w-]+)+$"; //验证邮箱
		String regexNumber = "^[1][3578][0-9]{9}$"; //验证手机号码
		
		if (Pattern.matches(regexEmail, emailOrNumber)) {// 匹配邮箱注册
			
			return registerWithEmail(emailOrNumber, password);
		} else if (Pattern.matches(regexNumber, emailOrNumber)) {// 匹配手机号码注册

			return registerWithNumber(emailOrNumber, password);
		} else {// 既不是邮箱也不是手机注册
			
			System.out.println("既不是手机注册也不是邮箱注册");
			return -1;
		}
		
	}
	
	/** @Description:通过第三方注册，1代表QQ，2代表微信，3代表新浪微博
	 * @exception:
	 */
	@Override
	public int registerInThirdParty(String openID, int registerType)
			throws Exception {
		
		if(! isExist(openID, registerType)){
			
			UserInfo u = new UserInfo();
			u.setThirdPartyUsername(openID);
			u.setRegisterType(registerType);
			
			userInfoDao.save(u);
			
			return u.getId();
		} else{
			// 如果用户名已被注册过，则注册失败，返回-1
			return -1;
		}
	}

	/**
	 * @Description:用邮箱注册
	 * @exception:
	 */
	@Override
	public int registerWithEmail(String email, String password)
			throws Exception {
		// 用邮箱的名字做用户名
		String username = email.substring(0, email.indexOf("@"));
		System.out.println("password---->" + password);
		if (!isExist(username)) {// 如果用户名未被注册过，允许注册并且返回注册后的id
			UserInfo u = new UserInfo();
			u.setUsername(username);
			u.setPassword(MD5andKL.MD5KL(password));
			u.setEmail(email);

			userInfoDao.save(u);

			return u.getId();
		} else
			// 如果用户名已被注册过，则注册失败，返回-1
			return -1;
	}

	/**
	 * @Description:用手机号码注册
	 * @exception:
	 */
	@Override
	public int registerWithNumber(String number, String password)
			throws Exception {
		// 用手机号的名字做用户名
		String username = number;

		if (!isExist(username)) {// 如果用户名未被注册过，允许注册并且返回注册后的id
			UserInfo u = new UserInfo();
			u.setUsername(username);
			u.setPassword(MD5andKL.MD5KL(password));
			u.setRegisterNumber(number);

			userInfoDao.save(u);

			return u.getId();
		} else
			// 如果用户名已被注册过，则注册失败，返回-1
			return -1;
	}

	/**
	 * @Description:删除一个用户
	 * @exception:
	 */
	@Override
	public void delete(UserInfo u) throws Exception {

	}

	/**
	 * @Description:根据id删除一个用户
	 * @exception:
	 */
	@Override
	public void deleteById(int id) throws Exception {

	}

	/**
	 * @Description:根据用户名判断用户是否存在
	 * @exception:
	 */
	@Override
	public boolean isExist(String username) {
		return userInfoDao.isExist(username);
	}

	/** @Description:根据第三方用户名判断用户是否存在
	 * @exception:
	 */
	@Override
	public boolean isExist(String openID, int type) {
		return userInfoDao.isExist(openID, type);
	}

	/** @Description:根据id获取用户名
	 * @exception:
	 */
	@Override
	public String getUsernameById(int userInfoId) throws Exception {
		
		UserInfo u = userInfoDao.get(UserInfo.class, userInfoId);
		return u.getUsername();
	}

	/** @Description:根据id获取第三方用户名
	 * @exception:
	 */
	@Override
	public String getThirdPartyUsernameById(int userInfoId) throws Exception {

		UserInfo u = userInfoDao.get(UserInfo.class, userInfoId);
		return u.getThirdPartyUsername();
	}

	/** @Description:注册后用户完善个人信息的第一步
	 * @exception:
	 */
	@Override
	public String completeInfoStep01(int userInfoId, UserInfoRegistStep01 info) throws Exception {
		
		if(info == null) {
			return null;
		}	
		UserInfo u = userInfoDao.get(UserInfo.class, userInfoId);
		
		u.setRealName(info.getRealName());
		if(info.getBirthday() != null && (! "".equals(info.getBirthday()))) {
			u.setBirthday( java.sql.Date.valueOf(info.getBirthday()));
		}		
		u.setSex(info.getSex());
		u.setMaxDegree(info.getMaxDegree());
		u.setWorklife(info.getWorklife());
		u.setWorkPlace(info.getWorkPlace());
		
		userInfoDao.update(u);
		
		return u.getUsername();
		
	}

	/** @Description:注册后用户完善个人信息的第二步
	 * @exception:
	 */
	@Override
	public String completeInfoStep02(int userInfoId, UserInfoRegistStep02 info) throws Exception {
		
		if(info == null) {
			return null;
		}
		
		UserInfo u = userInfoDao.get(UserInfo.class, userInfoId);
		
		u.setIndustryAndFunctional(info.getIndustryAndFunctional());
		u.setCompanyName(info.getCompanyName());
		u.setCurPosition(info.getCurPosition());
		u.setPhone(info.getPhone());
		u.setInterestField(info.getInterestField());
		
		userInfoDao.update(u);
		
		return u.getUsername();
		
	}

	/** @Description:手机号或者邮箱登录
	 * @exception:
	 */
	@Override
	public int login(String emailOrNumber, String password) throws Exception{
		
		//用正则表达式分析用户使用邮箱注册还是手机号码注册
		String regexEmail = "^[\\w-]+(\\.[\\w-]+)*\\@([\\.\\w-]+)+$"; //验证邮箱
		String regexNumber = "^[1][3578][0-9]{9}$"; //验证手机号码
		
		if (Pattern.matches(regexEmail, emailOrNumber)) {// 匹配邮箱注册
			
			return loginWithEmail(emailOrNumber, password);
		} else if (Pattern.matches(regexNumber, emailOrNumber)) {// 匹配手机号码注册

			return loginWithNumber(emailOrNumber, password);
		} else {// 既不是邮箱也不是手机注册
			
			System.out.println("既不是手机注册也不是邮箱注册");
			return -1;
		}
		
	}

	/** @Description:用邮箱登录
	 * @exception:
	 */
	@Override
	public int loginWithEmail(String email, String password) throws Exception {
		
		String MD5Password = MD5andKL.MD5KL(password);
		
		return userInfoDao.checkLoginWithEmail(email, MD5Password);
	
	}

	/** @Description:用手机号登录
	 * @exception:
	 */
	@Override
	public int loginWithNumber(String number, String password) throws Exception {
		
		String MD5Password = MD5andKL.MD5KL(password);
		
		return userInfoDao.checkLoginWithNumber(number, MD5Password);
	}

	/** @Description:给邮箱发送验证码
	 * @exception:
	 */
	@Override
	public Boolean getMailboxVerificationCode(String targetMailbox)
			throws Exception {
		
		//1.查询目标邮箱是否已经注册，未注册返回false，已注册走第2步
		boolean targetMailboxIsRegisterd  = userInfoDao.checkTargetMailboxIsRegisterd(targetMailbox);
		if(! targetMailboxIsRegisterd) {
			return false;
		}
		
		//2.生成验证码，并发给目标邮箱
		String verificationCode = NumberUtil.getNumbersAndAlphabet();
		EmailThread emailThread = new EmailThread(targetMailbox, verificationCode, verificationCodeDao);
		emailThread.start();
		/*if(! EmailUtil.sendMailboxVerificationCode(targetMailbox, verificationCode)) {
			return false;
		}
		
		//3.验证码并做持久化,存储成功返回true，否则返回false
		VerificationCode vc = new VerificationCode();
		vc.setEmail(targetMailbox);
		vc.setSendTime(new Date());
		vc.setVerificationCode(verificationCode);
		verificationCodeDao.save(vc);*/
		
		return true;
	}

	/** @Description:校验验证码
	 * @exception:
	 */
	@Override
	public Boolean compareMailboxVerificationCode(String mailbox,
			String verificationCode, String newPassword) throws Exception {
		//1.查询邮箱是否存在，如果不存在返回false，如果存在则取出最后一条验证码
		String codeString = verificationCodeDao.getLastestVerficationCodeByMailbox(mailbox);
		if(codeString == null || "".equals(codeString)) {
			return false;
		}
		//2.不区分大小写进行验证码匹配
		if(! codeString.toLowerCase().equals(verificationCode.toLowerCase())) {
			return false;
		}
		//3.将新密码更新到数据库 
		UserInfo userInfo = userInfoDao.getByEmail(mailbox);
		if(userInfo == null) {
			return false;
		}
		userInfo.setPassword(MD5andKL.MD5KL(newPassword));
		userInfoDao.update(userInfo);
		return true;
	}

	/**
	 * @Description:用户帐号信息处理
	 * @exception:
	 */
	@Override
	public UserIndexAccount userIndexAccount(int userInfoId) throws Exception {

		//根据userInfoId获取用户注册的信息
		UserInfo userInfo = userInfoDao.get(UserInfo.class, userInfoId);
		UserIndexAccount userIndexAccount = new UserIndexAccount();
		if(userInfo == null) {
			return null;
		}
		
		switch (userInfo.getRegisterType()) {
		case 0://内部注册类型, 分手机注册和邮箱注册
			if(userInfo.getRegisterNumber() != null) {//手机注册情况
				userIndexAccount.setUserAccount(userInfo.getRegisterNumber());
			}else {
				userIndexAccount.setUserAccount(userInfo.getEmail());
			}
			break;
		case 1://第三方QQ注册
		case 2://第三方微信注册
		case 3://第三方新浪微博注册
			userIndexAccount.setUserAccount(userInfo.getThirdPartyUsername());
			break;
		default:
			break;
		}
		/*****************************************************************************
		//根据userInfoId获取第三方帐号的绑定情况
		//这里后期补充获取第三方帐号的绑定情况
		 * 
		 *****************************************************************************/
		return userIndexAccount;
	}

	/**
	 * @Description:修改密码
	 * @exception:
	 */
	@Override
	public Boolean changePassword(Integer userInfoId, String oldPassword, String newPassword) throws Exception {

		UserInfo userInfo = userInfoDao.get(UserInfo.class, userInfoId);
		if(userInfo == null) {
			return false;
		}
		//比较新旧密码
		if(! MD5andKL.MD5KL(oldPassword).equals(userInfo.getPassword())) {
			return false;
		}
		userInfo.setPassword(MD5andKL.MD5KL(newPassword));
		userInfoDao.update(userInfo);
		return true;
	}
	
	
	
}




/** @Description:发送邮件的线程
 */
class EmailThread extends Thread {

	//目标邮箱
	private String targetMailbox;
	//验证码
	private String verificationCode;
	//
	private VerificationCodeDao verificationCodeDao;
	
	public EmailThread() {
		
	}
	
	public EmailThread(String targetMailbox, String verificationCode, VerificationCodeDao verificationCodeDao) {
		super();
		this.targetMailbox = targetMailbox;
		this.verificationCode = verificationCode;
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public void run() {
		boolean result = EmailUtil.sendMailboxVerificationCode(targetMailbox, verificationCode);
		System.out.println("发送邮件结果------> " + result);
		//3.验证码并做持久化,存储成功返回true，否则返回false
		VerificationCode vc = new VerificationCode();
		vc.setEmail(targetMailbox);
//		vc.setSendTime(new Timestamp(new java.util.Date().getTime()));
		vc.setSendTime(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date().getTime())));
		vc.setVerificationCode(verificationCode);
		verificationCodeDao.save(vc);
	}
}
