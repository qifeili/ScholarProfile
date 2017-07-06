package cn.scholarprofile.dao;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.scholarprofile.bean.UploadInfo;

public class FileDaoTest {

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
	public void testFindByProjectId() {
		FileDao fileDao = (FileDao) ctx.getBean("fileDao");
		
		try {
			List<UploadInfo> ps = fileDao.findByProjectId(25);
			System.out.println(ps.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFindEnclosuresByProjectId() {
		FileDao fileDao = (FileDao) ctx.getBean("fileDao");
		
		try {
			List<UploadInfo> ps = fileDao.findEnclosuresByProjectId(25);
			System.out.println(ps.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
