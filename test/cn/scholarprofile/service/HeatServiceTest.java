package cn.scholarprofile.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HeatServiceTest {

	ClassPathXmlApplicationContext ctx;
	HeatService heatService;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
		heatService = (HeatService) ctx.getBean("heatService");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	@Test
	public void testFindHotFieldNamesByUserInfoId() {
		
		try {
			
			List<String> hotFieldNames = heatService.findHotFieldNamesByUserInfoId(61);
			if(null != hotFieldNames) {
				System.out.println(hotFieldNames.size());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
