package cn.scholarprofile.service;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.dto.ScholarInfo;
import cn.scholarprofile.util.PageUtil;


public class ScholarServiceTest {

	ClassPathXmlApplicationContext ctx;
	ScholarService ss;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
		System.out.println("----->Junit----> init success");
		ss = (ScholarService) ctx.getBean("scholarService");
	}

	@After
	public void destory() {
		ctx.destroy();
		System.out.println("----->Junit----> destory success");
	}

	/*@Test
	public void testIsExist() {

		try {
			System.out.println(rs.isExist("张三"));
		} catch (Exception e) {
			
		}
	}*/
	@Test 
	public void testFindByFieldName() {
		try {
			PageUtil page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
			
			List<ScholarInfo> scholarInfos = ss.findByFieldName(1, "大数据", page);
			for (ScholarInfo scholarInfo : scholarInfos) {
				System.out.println(scholarInfo.getName() + "---->" + scholarInfo.isFollowByCurrentUser());
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	@Test 
	public void testFindByName() {
		try {
			PageUtil page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
			
			List<ScholarInfo> scholarInfos = ss.findByName(1, "刘", page);
			for (ScholarInfo scholarInfo : scholarInfos) {
				System.out.println(scholarInfo.getName() + "---->" + scholarInfo.isFollowByCurrentUser());
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}
	
	@Test 
	public void testFindByInstitutionName() {
		try {
			PageUtil page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
			
			List<ScholarInfo> scholarInfos = ss.findByInstitutionName(1, "华南", page);
			for (ScholarInfo scholarInfo : scholarInfos) {
				System.out.println(scholarInfo.getName() + "---->" + scholarInfo.isFollowByCurrentUser());
			}
		} catch (Exception e) {
			e.printStackTrace();		
		}
	}

}
