package cn.scholarprofile.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.util.PageUtil;

public class FocusProjectDaoTest {

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
	public void testFindFocusProjectInfo() {
		FocusProjectDao focusProjectDao = (FocusProjectDao) ctx.getBean("focusProjectDao");
		
		try {
			PageUtil page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
			
			List<Object[]> objList = focusProjectDao.findFocusProjectInfo(63, page);
			System.out.println(objList.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
