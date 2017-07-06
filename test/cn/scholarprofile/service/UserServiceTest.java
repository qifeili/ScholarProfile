package cn.scholarprofile.service;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.User;
import cn.scholarprofile.service.UserService;

public class UserServiceTest {

	@Test
	public void testAdd() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/config/beans.xml");

		UserService service = (UserService) ctx.getBean("userService");
		System.out.println(service.getClass());
		
		User u = new User();
		u.setUsername("b");
		u.setPassword("b");
		
		try {
			service.add(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		ctx.destroy();
	}
	

}
