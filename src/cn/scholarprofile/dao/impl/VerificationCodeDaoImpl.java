package cn.scholarprofile.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.VerificationCode;
import cn.scholarprofile.dao.VerificationCodeDao;

@Component("verificationCodeDaoImpl")
@Transactional
public class VerificationCodeDaoImpl extends BaseDaoImpl<VerificationCode> implements VerificationCodeDao {

	/** @Description:根据邮箱查找最新验证码
	 * @exception:
	 */
	@Override
	public String getLastestVerficationCodeByMailbox(String mailbox) {
		List<Object[]> objList = this.findBySql("select verificationCode, email from t_verificationcode where email = '" + mailbox + "' order by sendTime DESC limit 1");
		if(objList.size() == 0) {
			return null;
		} 
		Object[] objs = objList.get(0);
		String codeString = (String)objs[0];
		return codeString;
	}

	
}
