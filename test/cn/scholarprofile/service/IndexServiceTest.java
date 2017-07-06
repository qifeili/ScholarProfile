package cn.scholarprofile.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.dto.IndexInfo;


public class IndexServiceTest {

	ClassPathXmlApplicationContext ctx;
	IndexService is;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
		is = (IndexService) ctx.getBean("indexService");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	@Test
	public void testChangeFocusStatus() {
		
		try {
			IndexInfo indexInfo = is.getIndexInfo();
			System.out.println(indexInfo.getHotFields().size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
