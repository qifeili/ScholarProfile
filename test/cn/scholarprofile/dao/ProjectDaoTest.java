package cn.scholarprofile.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.Project;
import cn.scholarprofile.util.PageUtil;

public class ProjectDaoTest {

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
		//ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");

		try {
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testfindByFieldName() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			List<Project> ps = projectDao.findByFieldName("大数");
			System.out.println(ps.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testfindByName() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			List<Project> ps = projectDao.findByName("大数");
			System.out.println(ps.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHighFind() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			
			PageUtil page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
			
			List<Project> ps = projectDao.highFind("", "", page);
			System.out.println(ps.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindByUserInfoId() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			
			PageUtil page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
			
			List<Project> ps = projectDao.findByUserInfoId(1, page);
			System.out.println(ps.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCountByFieldName() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			Long projectNum = projectDao.countByFieldName("大数");
			System.out.println(projectNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCountByName() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			Long projectNum = projectDao.countByName("设计");
			System.out.println(projectNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHighCount() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			Long projectNum = projectDao.highCount("设计", "大数据");
			System.out.println(projectNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHighCount2() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			Long projectNum = projectDao.highCount("设计", "培训讲座", "算法研究", "大数据");
			System.out.println(projectNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHighCount3() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			//Long projectNum = projectDao.highCount("设计", "培训讲座", "大数据");
			Long projectNum = projectDao.highCount("设计", "算法研究", "大数据");
			System.out.println(projectNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCountByUserInfoId() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			Long projectNum = projectDao.countByUserInfoId(1);
			System.out.println(projectNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindLatestProjects() {
		ProjectDao projectDao = (ProjectDao) ctx.getBean("projectDao");
		
		try {
			List<Project> projects = projectDao.findLatestProjects();
			System.out.println(projects.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
