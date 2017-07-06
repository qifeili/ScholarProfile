package cn.scholarprofile.controller;


import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class UserInfoControllerTest {

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

	/*@Test
	public void testfindById() {
		ScholarDao sd = (ScholarDao) ctx.getBean("scholarDao");
		
		Scholar s = sd.findById(1); 
		//System.out.println(s.getName());
	}*/
	
}
