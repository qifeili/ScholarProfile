package cn.scholarprofile.dao;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.VerificationCode;
import cn.scholarprofile.util.NumberUtil;

public class VerificationCodeDaoTest {

	ClassPathXmlApplicationContext ctx;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	@Test
	public void testAdd() {
		VerificationCodeDao verificationCodeDao = (VerificationCodeDao) ctx.getBean("verificationCodeDaoImpl");
		
		String verificationCode = NumberUtil.getNumbersAndAlphabet();
		
		VerificationCode vc = new VerificationCode();
		vc.setEmail("773897474@qq.com");
		vc.setSendTime(new Timestamp(new java.util.Date().getTime()));
		vc.setVerificationCode(verificationCode);
		
		try {
			verificationCodeDao.save(vc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
