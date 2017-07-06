package cn.scholarprofile.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.dto.ReviewProjectInfo;
import cn.scholarprofile.util.PageUtil;


public class FocusProjectServiceTest {

	ClassPathXmlApplicationContext ctx;
	FocusProjectService fps;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
		fps = (FocusProjectService) ctx.getBean("focusProjectService");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	@Test
	public void findFocusProjectInfo() {
		
		try {
			PageUtil page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
			
			List<ReviewProjectInfo> projectInfos = fps.findFocusProjectInfo(2, page);
			System.out.println(projectInfos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
