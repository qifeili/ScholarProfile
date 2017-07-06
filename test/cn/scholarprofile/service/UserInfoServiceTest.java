package cn.scholarprofile.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserInfoServiceTest {

	ClassPathXmlApplicationContext ctx;
	UserInfoService us;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
		us = (UserInfoService) ctx.getBean("userInfoService");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	@Test
	public void testIsExist() {

		try {
			System.out.println(us.isExist("张三"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testGetMailboxVerificationCode() {
		
		try {
			System.out.println(us.getMailboxVerificationCode("773897474@qq.com"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testChangePassword() {
		
		try {
			System.out.println(us.changePassword(56, "111111", "chao11"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//测试多线程不能用单元测试，出不来效果，必须单个线程debug才可以出效果
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/config/beans.xml");;
		UserInfoService us = (UserInfoService) ctx.getBean("userInfoService");
		try {
			System.out.println(us.getMailboxVerificationCode("773897474@qq.com"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
