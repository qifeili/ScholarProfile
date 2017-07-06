package cn.scholarprofile.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.UserInfo;

public class UserInfoDaoTest {

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
		UserInfoDao userInfoDao = (UserInfoDao) ctx.getBean("userInfoDao");
		
		UserInfo u = new UserInfo();
		u.setUsername("d");
		u.setPassword("d");
		//u.setId(IdCreator.createClientId());
		
		try {
			userInfoDao.save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsExist() {
		UserInfoDao userInfoDao = (UserInfoDao) ctx.getBean("userInfoDao");

		try {
			System.out.println(userInfoDao.isExist("张三"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
