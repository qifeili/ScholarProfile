package cn.scholarprofile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Project;
import cn.scholarprofile.dao.ProjectDao;
import cn.scholarprofile.util.PageUtil;

@Component("projectDao")
@Transactional
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {

	/**
	 * @Description:根据领域名字进行模糊查找
	 * @exception:
	 */
	@Override
	public List<Project> findByFieldName(String fieldName) {

		if(null == fieldName || "".equals(fieldName)) {
			return new ArrayList<Project>();
		}
		return this.find("From Project p where p.field.name like '%"
				+ fieldName + "%'");
		// return
		// this.find("select p from Project p join p.field as field where field.name like '%"+
		// fieldName + "%'");
	}

	/**
	 * @Description:根据领域名字进行模糊查找,有分页
	 * @exception:
	 */
	@Override
	public List<Project> findByFieldName(String fieldName, PageUtil page) {

		if(null == fieldName || "".equals(fieldName)) {
			return new ArrayList<Project>();
		}
		return this.find("From Project p where p.field.name like '%"
				+ fieldName + "%'", page.getCurPage(), page.getRowsPerPage());
	}

	/**
	 * @Description:根据领域名进行同统计相关项目的数量
	 * @exception:
	 */
	@Override
	public Long countByFieldName(String fieldName) {

		/*
		 * Long projectNum = this .count(
		 * "select count(p) from  Project p join p.field as field where field.name like '%"
		 * + fieldName + "%'");
		 */
		if(null == fieldName || "".equals(fieldName)) {
			return Long.valueOf(0);
		}
		Long projectNum = this
				.count("select count(p) from  Project p where p.field.name like '%"
						+ fieldName + "%'");
		return projectNum;
	}

	/**
	 * @Description:根据名字进行模糊查找
	 * @exception:
	 */
	@Override
	public List<Project> findByName(String name) {

		if(null == name || "".equals(name)) {
			return new ArrayList<Project>();
		}
		return this.find("From Project p where p.title like '%" + name + "%'");
	}

	/**
	 * @Description:根据名字进行模糊查找,有分页
	 * @exception:
	 */
	@Override
	public List<Project> findByName(String name, PageUtil page) {

		if(null == name || "".equals(name)) {
			return new ArrayList<Project>();
		}
		return this.find("From Project p where p.title like '%" + name + "%'",
				page.getCurPage(), page.getRowsPerPage());
	}

	/**
	 * @Description:根据名字进行同统计相关项目的数量
	 * @exception:
	 */
	@Override
	public Long countByName(String name) {
		
		Long projectNum = this
				.count("select count(p) from  Project p where p.title like '%"
						+ name + "%'");
		return projectNum;
	}

	/**
	 * @Description:根据项目名称，所属领域名称进行高级查找
	 * @exception:
	 */
	@Override
	public List<Project> highFind(String name, String fieldName, PageUtil page) {

		return this.find("From Project p where p.title like '%" + name
				+ "%' and p.field.name ='" + fieldName + "'",
				page.getCurPage(), page.getRowsPerPage());
	}

	/**
	 * @Description:根据项目名称，所属领域名称， 项目类型进行高级查找
	 * @exception:
	 */
	@Override
	public List<Project> highFind(String name, String projectType,
			String fieldName, PageUtil page) {

		return this.find("From Project p where p.title like '%" + name
				+ "%' and p.field.name ='" + fieldName
				+ "' and p.projectType = '" + projectType + "'",
				page.getCurPage(), page.getRowsPerPage());
	}

	/**
	 * @Description:根据项目名称，所属领域名称， 项目类型进行高级查找
	 * @exception:
	 */
	@Override
	public List<Project> highFind(String name, String projectType1,
			String projectType2, String fieldName, PageUtil page) {

		return this.find("From Project p where p.title like '%" + name
				+ "%' and p.field.name ='" + fieldName
				+ "' and (p.projectType = '" + projectType1
				+ "' or p.projectType = '" + projectType2 + "')",
				page.getCurPage(), page.getRowsPerPage());
	}

	/**
	 * @Description:根据项目名称，项目类型进行高级查找
	 * @exception:
	 */
	@Override
	public List<Project> highFindWithoutFieldName(String name,
			String projectType, PageUtil page) {

		return this.find("From Project p where p.title like '%" + name
				+ "%' and p.projectType = '" + projectType + "'",
				page.getCurPage(), page.getRowsPerPage());
	}

	/**
	 * @Description:根据项目名称，项目类型进行高级查找
	 * @exception:
	 */
	@Override
	public List<Project> highFindWithoutFieldName(String name,
			String projectType1, String projectType2, PageUtil page) {

		return this.find("From Project p where p.title like '%" + name
				+ "%' and (p.projectType = '" + projectType1
				+ "' or p.projectType = '" + projectType2 + "')",
				page.getCurPage(), page.getRowsPerPage());
	}
	
	/**
	 * @Description:根据用户id,查找所有属于该用户的项目
	 * @exception:
	 */
	@Override
	public List<Project> findByUserInfoId(Integer userInfoId, PageUtil page) {
		return this.find("From Project p where p.userInfo.id = " + userInfoId ,
				page.getCurPage(), page.getRowsPerPage());
	}

	/**
	 * @Description:统计根据项目名称，所属领域名称进行高级查找得到的结果
	 * @exception:
	 */
	@Override
	public Long highCount(String name, String fieldName) {

		Long projectNum = this
				.count("select count(p) from  Project p where p.title like '%"
						+ name + "%' and p.field.name = '" + fieldName + "'");
		return projectNum;
	}

	/**
	 * @Description:统计根据项目名称，所属领域名称, 项目类型进行高级查找得到的结果
	 * @exception:
	 */
	@Override
	public Long highCount(String name, String projectType, String fieldName) {

		Long projectNum = this
				.count("select count(p) from  Project p where p.title like '%"
						+ name + "%' and p.field.name = '" + fieldName
						+ "' and p.projectType = '" + projectType + "'");
		return projectNum;
	}

	/**
	 * @Description:统计根据项目名称，所属领域名称， 项目类型进行高级查找得到的结果
	 * @exception:
	 */
	@Override
	public Long highCount(String name, String projectType1,
			String projectType2, String fieldName) {

		Long projectNum = this
				.count("select count(p) from  Project p where p.title like '%"
						+ name + "%' and p.field.name = '" + fieldName
						+ "' and (p.projectType = '" + projectType1
						+ "' or p.projectType = '" + projectType2 + "')");
		return projectNum;
	}

	/**
	 * @Description:统计根据项目名称，项目类型进行高级查找得到的结果
	 * @exception:
	 */
	@Override
	public Long highCountWithoutFieldName(String name, String projectType) {

		Long projectNum = this
				.count("select count(p) from  Project p where p.title like '%"
						+ name + "%' and p.projectType = '" + projectType + "'");
		return projectNum;
	}

	/**
	 * @Description:统计根据项目名称，项目类型进行高级查找得到的结果
	 * @exception:
	 */
	@Override
	public Long highCountWithoutFieldName(String name, String projectType1,
			String projectType2) {

		Long projectNum = this
				.count("select count(p) from  Project p where p.title like '%"
						+ name + "%' and (p.projectType = '" + projectType1
						+ "' or p.projectType = '" + projectType2 + "')");
		return projectNum;
	}

	/**
	 * @Description:根据用户id, 统计该属于该用户的项目数量
	 * @exception:
	 */
	@Override
	public long countByUserInfoId(Integer userInfoId) {
		return this.count("select count(p) from  Project p where p.userInfo.id = "
						+ userInfoId);
		//虽然在Project表中的userinfo的外键是userinfoId, 但是在hql中不能如下那样使用
		/*return this.count("select count(p) from  Project p where p.userinfoId = "
				+ userInfoId + "");*/
	}

	/**
	 * @Description:查出最新的几个项目
	 * @exception:
	 */
	@Override
	public List<Project> findLatestProjects() {
		return this.find("From Project p order by p.releaseDate DESC", 1, 5);
	}
	
	

}
