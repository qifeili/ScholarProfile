package cn.scholarprofile.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.Focus;

public class FocusDaoTest {

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
	public void testFindByUserInfoId() {
		FocusDao focusDao = (FocusDao) ctx.getBean("focusDao");
		
		try {
			List<Focus> fs = focusDao.findByUserInfoId(63);
			System.out.println(fs.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
