package cn.scholarprofile.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.UserInfo;

public class RegisterServiceTest {

	ClassPathXmlApplicationContext ctx;
	RegisterService rs;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
		rs = (RegisterService) ctx.getBean("registerService");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	@Test
	public void testIsExist() {

		try {
			System.out.println(rs.isExist("张三"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCompleteInfo() {
		
		UserInfo u = new UserInfo();
		//u.setId("CLeca3baaa-8a0e-4988-9ef6-8abfa025816c");
		//u.setBirthYear("1992");
		
		try {
			int result = rs.completeInfo(u);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
