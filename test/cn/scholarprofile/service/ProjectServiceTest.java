package cn.scholarprofile.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.dto.ProjectInfoDetails;
import cn.scholarprofile.dto.ProjectInfoStep02;

public class ProjectServiceTest {

	ClassPathXmlApplicationContext ctx;
	ProjectService ps;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
		ps = (ProjectService) ctx.getBean("projectService");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	@Test
	public void testPublishingProjectStep01() {

		try {
			int id = ps.publishingProjectStep01(1, "培训讲座");
			System.out.println("projectId ---> " + id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testPublishingProjectStep02() {
		
		try {
			
			ProjectInfoStep02 info = new ProjectInfoStep02();
			info.setFieldName("大数据");
			ps.publishingProjectStep02(1, info);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testPublishingProjectStep03() {
		
		try {
			int id = ps.publishingProjectStep01(1, "培训讲座");
			System.out.println("projectId ---> " + id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testPublishingProjectStep04() {
		
		try {
			int id = ps.publishingProjectStep01(1, "培训讲座");
			System.out.println("projectId ---> " + id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testGetProjectDetails() {
		
		try {
			ProjectInfoDetails details = ps.getProjectDetails(41);
			System.out.println(details.getProjectEnclosures().size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
