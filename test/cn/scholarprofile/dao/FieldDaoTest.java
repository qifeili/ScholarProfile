package cn.scholarprofile.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class FieldDaoTest {

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
	public void testIsExist() {
		//FieldDao fieldDao = (FieldDao) ctx.getBean("fieldDao");
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testListHotFieldNames() {
		FieldDao fieldDao = (FieldDao) ctx.getBean("fieldDao");
		List<String> result = fieldDao.listHotFieldNames();
		System.out.println(result.size());
		System.out.println(result.isEmpty());
		System.out.println(result.get(0));
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
