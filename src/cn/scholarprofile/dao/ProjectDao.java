package cn.scholarprofile.dao;

import java.util.List;

import cn.scholarprofile.bean.Project;
import cn.scholarprofile.util.PageUtil;

public interface ProjectDao extends BaseDao<Project>{
	
	// 根据领域名字进行模糊查找
	public abstract List<Project> findByFieldName(String fieldName);

	// 根据领域名字进行模糊查找,有分页
	public abstract List<Project> findByFieldName(String fieldName, PageUtil page);
	
	//根据领域名进行同统计相关项目的数量
	public abstract Long countByFieldName(String fieldName);
	
	// 根据名字进行模糊查找
	public abstract List<Project> findByName(String name);
	
	// 根据名字进行模糊查找,有分页
	public abstract List<Project> findByName(String name, PageUtil page);
	
	//根据名字进行同统计相关项目的数量
	public abstract Long countByName(String name);
	
	//根据项目名称，所属领域名称进行高级查找
	public abstract List<Project> highFind(String name, String fieldName, PageUtil page);
	
	//根据项目名称，所属领域名称, 项目类型进行高级查找
	public abstract List<Project> highFind(String name, String projectType, String fieldName, PageUtil page);
	
	//根据项目名称，所属领域名称， 项目类型进行高级查找
	public abstract List<Project> highFind(String name, String projectType1, String projectType2, String fieldName, PageUtil page);
	
	//根据项目名称，项目类型进行高级查找
	public abstract List<Project> highFindWithoutFieldName(String name, String projectType, PageUtil page);
	
	//根据项目名称，项目类型进行高级查找
	public abstract List<Project> highFindWithoutFieldName(String name, String projectType1, String projectType2, PageUtil page);
	
	//根据用户id,查找所有属于该用户的项目
	public abstract List<Project> findByUserInfoId(Integer userInfoId, PageUtil page);
		
	//统计根据项目名称，所属领域名称进行高级查找得到的结果
	public abstract Long highCount(String name, String fieldName);
	
	//统计根据项目名称，所属领域名称, 项目类型进行高级查找得到的结果
	public abstract Long highCount(String name, String projectType, String fieldName);
	
	//统计根据项目名称，所属领域名称， 项目类型进行高级查找得到的结果
	public abstract Long highCount(String name, String projectType1, String projectType2, String fieldName);
	
	//统计根据项目名称，项目类型进行高级查找得到的结果
	public abstract Long highCountWithoutFieldName(String name, String projectType);
	
	//统计根据项目名称，项目类型进行高级查找得到的结果
	public abstract Long highCountWithoutFieldName(String name, String projectType1, String projectType2);
	
	//根据用户id, 统计该属于该用户的项目数量
	public abstract long countByUserInfoId(Integer userInfoId);
	
	//查出最新的几个项目
	public abstract List<Project> findLatestProjects();
	
	
}