package cn.scholarprofile.service;

import java.util.List;

import cn.scholarprofile.bean.Project;
import cn.scholarprofile.dto.ProjectInfo;
import cn.scholarprofile.dto.ProjectInfoDetails;
import cn.scholarprofile.dto.ProjectInfoStep02;
import cn.scholarprofile.dto.UserIndexProject;
import cn.scholarprofile.util.PageUtil;


public interface ProjectService {

	
	/**
	 * @Description:发布一个项目共4步，这是第一步，添加用户与项目的关系和项目的类型
	 * @exception:
	 */
	public abstract int publishingProjectStep01(int userInfoId, String projectType) throws Exception;
	
	/**
	 * @Description:发布一个项目共4步，这是第二步，添加项目与领域的关系，项目的一些基本信息
	 * @exception:
	 */
	public abstract void publishingProjectStep02(int projectId, ProjectInfoStep02 info) throws Exception;
	
	/**
	 * @Description:根据项目Id删除所有的文件
	 * @exception:
	 */
	public abstract void removeFilesByProjectId(int projectId) throws Exception;

	/**
	 * @Description:发布一个项目共4步，这是第三步，指定合同金额
	 * @exception:
	 */
	public abstract void publishingProjectStep03(int projectId, Double budget) throws Exception;
	
	/**
	 * @Description:获取所有项目详情
	 * @exception:
	 */
	public abstract ProjectInfoDetails getProjectDetails(int projectId) throws Exception;
	
	/**
	 * @Description:发布一个项目共4步，这是第四步，改变项目状态为已发布
	 * @exception:
	 */
	public abstract void publishingProjectStep04(int projectId) throws Exception;
	
	/**
	 * @Description:修改正在发布的项目的类型
	 * @exception:
	 */
	public abstract void publishingProjectUpdateProjectType(int projectId, String projectType) throws Exception;
	
	/**
	 * @Description:根据领域名查出相关项目
	 * @exception:
	 */
	public abstract List<Project> findByFieldName(String fieldName, PageUtil page) throws Exception;
	
	/**
	 * @Description:统计根据领域名查出的项目的总个数
	 * @exception:
	 */
	public abstract Long countByFieldName(String fieldName) throws Exception;
	
	/**
	 * @Description:根据项目名查出相关项目, 用户未登录
	 * @exception:
	 */
	
	/*public abstract List<Project> findByName(String name, PageUtil page) throws Exception;*/
	public abstract List<ProjectInfo> findByName(String name, PageUtil page) throws Exception;
	
	/**
	 * @Description:根据项目名查出相关项目, 用户已登录
	 * @exception:
	 */
	public abstract List<ProjectInfo> findByName(Integer userInfoId, String name, PageUtil page) throws Exception;
	
	/**
	 * @Description:统计根据项目名查出的项目的总个数
	 * @exception:
	 */
	public abstract Long countByName(String name) throws Exception;
	
	/**
	 * @Description:根据项目名称，所属领域名称进行高级查找, 用户未登录
	 * @exception:
	 */
	public abstract List<ProjectInfo> highFind(String name, String projectTypeRadio, String fieldName, PageUtil page) throws Exception;
	
	/**
	 * @Description:根据项目名称，所属领域名称进行高级查找, 用户已登录
	 * @exception:
	 */
	public abstract List<ProjectInfo> highFind(Integer userInfoId, String name, String projectTypeRadio, String fieldName, PageUtil page) throws Exception;
	
	/**
	 * @Description:统计根据项目名称，所属领域名称进行高级查找得到的结果
	 * @exception:
	 */
	public abstract Long highCount(String name, String projectTypeRadio, String fieldName) throws Exception;
	
	/**
	 * @Description:列出所有属于该用户的项目
	 * @exception:
	 */
	public abstract List<UserIndexProject> listMyProjects(Integer userInfoId, PageUtil page) throws Exception;
	
	/**
	 * @Description:根据用户计算该用户拥有的项目数量
	 * @exception:
	 */
	public abstract long countByUser(Integer userInfoId) throws Exception;
	
	/**
	 * @Description:根据项目id获取项目发布到第几步的信息
	 * @exception:
	 */
	public abstract int getProjectStep(Integer projectId) throws Exception;
}
