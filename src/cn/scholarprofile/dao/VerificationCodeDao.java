package cn.scholarprofile.dao;

import cn.scholarprofile.bean.VerificationCode;


public interface VerificationCodeDao extends BaseDao<VerificationCode>{
	
	/**
	 * @Description:根据邮箱查找最新验证码
	 * @exception:
	 */
	public String getLastestVerficationCodeByMailbox(String mailbox);
}