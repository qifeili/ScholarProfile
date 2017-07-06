package cn.scholarprofile.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.Scholar;

public class ScholarDaoTest {

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
	public void testfindById() {
		ScholarDao sd = (ScholarDao) ctx.getBean("scholarDao");
		
		Scholar s = sd.findById(1); 
		System.out.println(s.getName());
	}
	
	@Test
	public void testfindByName() {
		ScholarDao sd = (ScholarDao) ctx.getBean("scholarDao");
		
		List<Scholar> list = sd.findByName("李"); 
		for (Scholar scholar : list) {
			System.out.println(scholar.getName());
		}
		//System.out.println(s.getName());
	}
	
	@Test
	public void testfindByFieldName() {
		ScholarDao sd = (ScholarDao) ctx.getBean("scholarDao");
		
		List<Scholar> list = sd.findByFieldName("社交网络"); 
		for (Scholar scholar : list) {
			System.out.println(scholar.getName());
		}
		//System.out.println(s.getName());
	}
	
	@Test
	public void testfindByInstitutionName() {
		ScholarDao sd = (ScholarDao) ctx.getBean("scholarDao");
		
		List<Scholar> list = sd.findByInstitutionName("华南师范大学"); 
		for (Scholar scholar : list) {
			System.out.println(scholar.getName());
		}
		//System.out.println(s.getName());
	}
	
	@Test
	public void testFindTopScholarsByFieldName() {
		ScholarDao sd = (ScholarDao) ctx.getBean("scholarDao");
		
		List<Scholar> list = sd.findTopScholarsByFieldName("控制"); 
		for (Scholar scholar : list) {
			System.out.println(scholar.getName());
		}
		//System.out.println(s.getName());
	}
	
	
}
