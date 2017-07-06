package cn.scholarprofile.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FocusServiceTest {

	ClassPathXmlApplicationContext ctx;
	FocusService fs;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
		fs = (FocusService) ctx.getBean("focusService");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	@Test
	public void testChangeFocusStatus() {
		
		try {
			Boolean result = fs.changeFocusStatus(1, 1);
			Assert.assertTrue(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
