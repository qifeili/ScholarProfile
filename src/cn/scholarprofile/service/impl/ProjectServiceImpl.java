package cn.scholarprofile.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Field;
import cn.scholarprofile.bean.FocusProject;
import cn.scholarprofile.bean.Project;
import cn.scholarprofile.bean.UploadInfo;
import cn.scholarprofile.bean.UserInfo;
import cn.scholarprofile.dao.FieldDao;
import cn.scholarprofile.dao.FileDao;
import cn.scholarprofile.dao.FocusProjectDao;
import cn.scholarprofile.dao.ProjectDao;
import cn.scholarprofile.dao.UserInfoDao;
import cn.scholarprofile.dto.ProjectInfo;
import cn.scholarprofile.dto.ProjectInfoDetails;
import cn.scholarprofile.dto.ProjectInfoStep02;
import cn.scholarprofile.dto.UserIndexProject;
import cn.scholarprofile.service.ProjectService;
import cn.scholarprofile.util.DateUtil;
import cn.scholarprofile.util.PageUtil;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {

	private ProjectDao projectDao;
	private UserInfoDao userInfoDao;
	private FieldDao fieldDao;
	private FileDao fileDao;
	private FocusProjectDao focusProjectDao;

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	@Resource
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	public UserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	@Resource
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	public FieldDao getFieldDao() {
		return fieldDao;
	}

	@Resource
	public void setFieldDao(FieldDao fieldDao) {
		this.fieldDao = fieldDao;
	}

	public FileDao getFileDao() {
		return fileDao;
	}

	@Resource
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}
	
	public FocusProjectDao getFocusProjectDao() {
		return focusProjectDao;
	}

	@Resource
	public void setFocusProjectDao(FocusProjectDao focusProjectDao) {
		this.focusProjectDao = focusProjectDao;
	}

	/** @Description:发布一个项目共4步，这是第一步，添加用户与项目的关系和项目的类型
	 * @exception:
	 */
	@Override
	public int publishingProjectStep01(int userInfoId, String projectType)
			throws Exception {
		
		UserInfo userInfo = userInfoDao.get(UserInfo.class, userInfoId);
		
		Project project = new Project();
		project.setProjectType(projectType);
		project.setStep(1);
		
		//设置关联
		project.setUserInfo(userInfo);
		userInfo.getProjects().add(project);
		
		//持久化
		userInfoDao.save(userInfo);
		projectDao.save(project);
		
		return project.getId();
	}

	/** @Description:发布一个项目共4步，这是第二步，添加项目与领域的关系，项目的一些基本信息
	 * @exception:
	 */
	@Override
	public void publishingProjectStep02(int projectId, ProjectInfoStep02 info)
			throws Exception {

		//UserInfo userInfo = userInfoDao.get(UserInfo.class, userInfoId);//可能会级联，暂时先不手动写
		Field field = fieldDao.getFieldByName(info.getFieldName());
		Project project = projectDao.get(Project.class, projectId);
		
		project.setTitle(info.getTitle());
		project.setDevelopmentCycle(info.getDevelopmentCycle());
		//装载用户自定义的项目子标签和内容
		project.setTagsName(info.getTagsName());
		project.setTagsinfo(info.getTagsinfo());
		project.setStep(2);
		
		//设置关联
		project.setField(field);
		/*if(! userInfo.getProjects().contains(project)){
			userInfo.getProjects().add(project);
		}*/
		if(field != null)
			field.getProjects().add(project);
		
		//持久化
		fieldDao.update(field);
		projectDao.update(project);
		//userInfoDao.update(userInfo);
	}
	
	

	/** @Description:根据项目Id删除所有的文件
	 * @exception:
	 */
	@Override
	public void removeFilesByProjectId(int projectId) throws Exception {
		
		fileDao.removeFilesByProjectId(projectId);
	}

	/** @Description:发布一个项目共4步，这是第三步，指定合同金额
	 * @exception:
	 */
	@Override
	public void publishingProjectStep03(int projectId, Double budget)
			throws Exception {

		Project project = projectDao.get(Project.class, projectId);
		
		if(budget != null)
			project.setBudget(budget);
		project.setStep(3);
		
		project.setReleaseDate(new Date());
		
		projectDao.update(project);
	}

	/** @Description:获取所有项目详情
	 * @exception:
	 */
	@Override
	public ProjectInfoDetails getProjectDetails(int projectId) throws Exception {
		
		ProjectInfoDetails details = new ProjectInfoDetails();
		
		Project project = projectDao.get(Project.class, projectId);
		//配置项目细节的简单属性
		if(project.getReleaseDate() != null && (! "".equals(project.getReleaseDate()))) {
			details.setReleaseDate(DateUtil.DateToString(project.getReleaseDate()));
		}
		
		details.setId(project.getId());
		details.setTitle(project.getTitle());
		details.setDevelopmentCycle(project.getDevelopmentCycle());
		details.setAuctionNumber(project.getAuctionNumber());
		details.setStage(project.getStage());
		details.setBudget(project.getBudget());
		details.setProjectType(project.getProjectType());
		details.setStatus(project.getStatus());
		
		//解析project的附件信息，并装配
		List<UploadInfo> enclosuresList = fileDao.findEnclosuresByProjectId(projectId);
		for (UploadInfo uploadInfo : enclosuresList) {		
			//文件的名字作为key，方便显示，文件的id作为value，方便下载文件
			details.getProjectEnclosures().put(uploadInfo.getFilename(), uploadInfo.getId());
		}
		
		//解析project的数据集及其描述信息
		List<UploadInfo> dataSetList = fileDao.findDataSetByProjectId(projectId);
		for (UploadInfo uploadInfo : dataSetList) {
			details.getProjectDataSetFilenames().add(uploadInfo.getFilename());
			details.getProjectDataSetFileIds().add(uploadInfo.getId());
			details.getUpLoadDataSetFileDis().add(uploadInfo.getUpLoadDataSetFileDis());
			details.getUpLoadDataSetFieldDis().add(uploadInfo.getUpLoadDataSetFieldDis());
		}
		
		//解析用户输入的子标题和子标题内容
		if(project.getTagsName() != null) {
			String[] subTitles = project.getTagsName().split("@#￥%\\*&", -1);
			String[] subTitleContents = project.getTagsinfo().split("@#￥%\\*&", -1);
			
			for (int i = 0; i < subTitles.length; i++) {
				
				details.getTagsNames().add(subTitles[i]);
				details.getTagsinfos().add(subTitleContents[i]);
				
			}
		}
		
		
		return details;
	}
	
	/** @Description:发布一个项目共4步，这是第四步，改变项目状态为已发布
	 * @exception:
	 */
	@Override
	public void publishingProjectStep04(int projectId) throws Exception {

		Project project = projectDao.get(Project.class, projectId);
		
		project.setStatus(1);
		project.setStep(4);
		
		projectDao.update(project);
	}

	/** @Description:修改正在发布的项目的类型
	 * @exception:
	 */
	@Override
	public void publishingProjectUpdateProjectType(int projectId,
			String projectType) throws Exception {

		Project project = projectDao.get(Project.class, projectId);
		
		project.setProjectType(projectType);
		project.setStep(1);
		
		projectDao.update(project);
	}

	/** @Description:根据领域名查出相关项目
	 * @exception:
	 */
	@Override
	public List<Project> findByFieldName(String fieldName, PageUtil page)
			throws Exception {
		
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条

			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		return projectDao.findByFieldName(fieldName, page);
	}

	/** @Description:统计根据领域名查出的项目的总个数
	 * @exception:
	 */
	@Override
	public Long countByFieldName(String fieldName) throws Exception {
		
		return projectDao.countByFieldName(fieldName);
	}

	/** @Description:根据项目名查出相关项目, 用户未登录
	 * @exception:
	 */
	@Override
	public List<ProjectInfo> findByName(String name, PageUtil page)
			throws Exception {
		
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条

			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		List<Project> projects = projectDao.findByName(name, page);
		List<ProjectInfo> projectInfos = new ArrayList<>();
		ProjectInfo projectInfo = null;
		for (Project project : projects) {
			projectInfo = new ProjectInfo();
			projectInfo.setId(project.getId());
			projectInfo.setBudget(project.getBudget());
			projectInfo.setFollowByCurrentUser(false);
			projectInfo.setProjectType(project.getProjectType());
			projectInfo.setTitle(project.getTitle());
			//这里添加项目简介的摘要
			projectInfo.setSummary("现已有logo设计，想做一个前台背后区域的logo...");
			projectInfos.add(projectInfo);
		}
		projectInfo = null;
		return projectInfos;
	}
	
	/** @Description:根据项目名查出相关项目, 用户已登录
	 * @exception:
	 */
	@Override
	public List<ProjectInfo> findByName(Integer userInfoId, String name, PageUtil page) throws Exception {

		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		List<Project> projects = projectDao.findByName(name, page);
		List<FocusProject> focus = focusProjectDao.findByUserInfoId(userInfoId);
		List<ProjectInfo> projectInfos = new ArrayList<>();
		ProjectInfo projectInfo = null;
		if(focus == null || focus.size() == 0) {
			for (Project project : projects) {
				projectInfo = new ProjectInfo();
				projectInfo.setId(project.getId());
				projectInfo.setBudget(project.getBudget());
				projectInfo.setFollowByCurrentUser(false);
				projectInfo.setProjectType(project.getProjectType());
				projectInfo.setTitle(project.getTitle());
				//这里添加项目简介的摘要
				projectInfo.setSummary("现已有logo设计，想做一个前台背后区域的logo...");
				projectInfos.add(projectInfo);
			}
			projectInfo = null;
			return projectInfos;
		}else {
			for (Project project : projects) {
				projectInfo = new ProjectInfo();
				projectInfo.setId(project.getId());
				projectInfo.setBudget(project.getBudget());
				//遍历查看学者是否被关注
				boolean flag = false;//标记位，记录是否在focus列表中找到了该学者
				for (FocusProject focusInfo : focus) {
					if(project.getId() == focusInfo.getProjectId()) {
						flag = true;
						break;
					}
				}
				if(flag) {
					projectInfo.setFollowByCurrentUser(true);
				}else {
					projectInfo.setFollowByCurrentUser(false);
				}	
				projectInfo.setProjectType(project.getProjectType());
				projectInfo.setTitle(project.getTitle());
				//这里添加项目简介的摘要
				projectInfo.setSummary("现已有logo设计，想做一个前台背后区域的logo...");
				projectInfos.add(projectInfo);
			}
			projectInfo = null;
			return projectInfos;
		}
		
	}

	/** @Description:统计根据项目名查出的项目的总个数
	 * @exception:
	 */
	@Override
	public Long countByName(String name) throws Exception {
		
		return projectDao.countByName(name);
	}

	/** @Description:根据项目名称，所属领域名称进行高级查找, 用户未登录
	 * @exception:
	 */
	@Override
	public List<ProjectInfo> highFind(String name, String projectTypeRadio, String fieldName, PageUtil page)
			throws Exception {

		List<Project> projectList = null;
		//对projectTypeRadio的数据进行解析
		if(projectTypeRadio != null){//1.项目类型不为空，分三种情况，分别是项目类型被选（1个），（2个），（0个或者3个）
			
			//开始将projectTypeRadio解析
			String[] projectTypes = projectTypeRadio.split(",", -1);
			
			if(fieldName != null && (! "".equals(fieldName))) {//3.项目类型不为空，且领域名不为空
				
				if(projectTypes.length == 1) {//项目类型被选（1个）
					projectList = projectDao.highFind(name, projectTypes[0], fieldName, page);
				}else if(projectTypes.length == 2){//项目类型被选（2个）
					projectList = projectDao.highFind(name, projectTypes[0], projectTypes[1], fieldName, page);
				}else {//项目类型被选（0个或者3个）
					projectList = projectDao.highFind(name, fieldName, page);
				}
			}else {//4.项目类型不为空，且领域名为空
				
				if(projectTypes.length == 1) {//项目类型被选（1个）
					projectList = projectDao.highFindWithoutFieldName(name, projectTypes[0], page);
				}else if(projectTypes.length == 2){//项目类型被选（2个）
					projectList = projectDao.highFindWithoutFieldName(name, projectTypes[0], projectTypes[1], page);
				}else {//项目类型被选（0个或者3个）
					projectList = projectDao.findByName(name, page);
				}
			}
		}else if(projectTypeRadio == null){//2.项目类型为空
			
			if(fieldName != null && (! "".equals(fieldName))) {//3.项目类型为空，且领域名不为空
				projectList = projectDao.highFind(name, fieldName, page);
			}else {//4.项目类型为空，且领域名为空
				projectList = projectDao.findByName(name, page);
			}
		}
		
		List<ProjectInfo> projectInfos = new ArrayList<>();
		ProjectInfo projectInfo = null;
		for (Project project : projectList) {
			projectInfo = new ProjectInfo();
			projectInfo.setId(project.getId());
			projectInfo.setBudget(project.getBudget());
			projectInfo.setFollowByCurrentUser(false);
			projectInfo.setProjectType(project.getProjectType());
			projectInfo.setTitle(project.getTitle());
			//这里添加项目简介的摘要
			projectInfo.setSummary("现已有logo设计，想做一个前台背后区域的logo...");
			projectInfos.add(projectInfo);
		}
		projectInfo = null;
		return projectInfos;
	}
	
	/**
	 * @Description:根据项目名称，所属领域名称进行高级查找, 用户已登录
	 * @exception:
	 */
	@Override
	public List<ProjectInfo> highFind(Integer userInfoId, String name, String projectTypeRadio, String fieldName,
			PageUtil page) throws Exception {
		List<Project> projectList = null;
		//对projectTypeRadio的数据进行解析
		if(projectTypeRadio != null){//1.项目类型不为空，分三种情况，分别是项目类型被选（1个），（2个），（0个或者3个）
			
			//开始将projectTypeRadio解析
			String[] projectTypes = projectTypeRadio.split(",", -1);
			
			if(fieldName != null && (! "".equals(fieldName))) {//3.项目类型不为空，且领域名不为空
				
				if(projectTypes.length == 1) {//项目类型被选（1个）
					projectList = projectDao.highFind(name, projectTypes[0], fieldName, page);
				}else if(projectTypes.length == 2){//项目类型被选（2个）
					projectList = projectDao.highFind(name, projectTypes[0], projectTypes[1], fieldName, page);
				}else {//项目类型被选（0个或者3个）
					projectList = projectDao.highFind(name, fieldName, page);
				}
			}else {//4.项目类型不为空，且领域名为空
				
				if(projectTypes.length == 1) {//项目类型被选（1个）
					projectList = projectDao.highFindWithoutFieldName(name, projectTypes[0], page);
				}else if(projectTypes.length == 2){//项目类型被选（2个）
					projectList = projectDao.highFindWithoutFieldName(name, projectTypes[0], projectTypes[1], page);
				}else {//项目类型被选（0个或者3个）
					projectList = projectDao.findByName(name, page);
				}
			}
		}else if(projectTypeRadio == null){//2.项目类型为空
			
			if(fieldName != null && (! "".equals(fieldName))) {//3.项目类型为空，且领域名不为空
				projectList = projectDao.highFind(name, fieldName, page);
			}else {//4.项目类型为空，且领域名为空
				projectList = projectDao.findByName(name, page);
			}
		}
		
		// 根据指定的页码和条数查询结果
		List<ProjectInfo> projectInfos = new ArrayList<>();
		List<FocusProject> focus = focusProjectDao.findByUserInfoId(userInfoId);
		ProjectInfo projectInfo = null;
		if(focus == null || focus.size() == 0) {
			for (Project project : projectList) {
				projectInfo = new ProjectInfo();
				projectInfo.setId(project.getId());
				projectInfo.setBudget(project.getBudget());
				projectInfo.setFollowByCurrentUser(false);
				projectInfo.setProjectType(project.getProjectType());
				projectInfo.setTitle(project.getTitle());
				//这里添加项目简介的摘要
				projectInfo.setSummary("现已有logo设计，想做一个前台背后区域的logo...");
				projectInfos.add(projectInfo);
			}
			projectInfo = null;
			return projectInfos;
		}else {
			for (Project project : projectList) {
				projectInfo = new ProjectInfo();
				projectInfo.setId(project.getId());
				projectInfo.setBudget(project.getBudget());
				//遍历查看学者是否被关注
				boolean flag = false;//标记位，记录是否在focus列表中找到了该学者
				for (FocusProject focusInfo : focus) {
					if(project.getId() == focusInfo.getProjectId()) {
						flag = true;
						break;
					}
				}
				if(flag) {
					projectInfo.setFollowByCurrentUser(true);
				}else {
					projectInfo.setFollowByCurrentUser(false);
				}
				projectInfo.setProjectType(project.getProjectType());
				projectInfo.setTitle(project.getTitle());
				//这里添加项目简介的摘要
				projectInfo.setSummary("现已有logo设计，想做一个前台背后区域的logo...");
				projectInfos.add(projectInfo);
			}
			projectInfo = null;
			return projectInfos;
		}
		
	}

	/** @Description:统计根据项目名称，所属领域名称进行高级查找得到的结果
	 * @exception:
	 */
	@Override
	public Long highCount(String name, String projectTypeRadio, String fieldName) throws Exception {
		
		Long projectNum = null;
		//对projectTypeRadio的数据进行解析
		if(projectTypeRadio != null){//1.项目类型不为空，分三种情况，分别是项目类型被选（1个），（2个），（0个或者3个）
			
			//开始将projectTypeRadio解析
			String[] projectTypes = projectTypeRadio.split(",", -1);
			
			if(fieldName != null && (! "".equals(fieldName))) {//3.项目类型不为空，且领域名不为空
				
				if(projectTypes.length == 1) {//项目类型被选（1个）
					projectNum = projectDao.highCount(name, projectTypes[0], fieldName);
				}else if(projectTypes.length == 2){//项目类型被选（2个）
					projectNum = projectDao.highCount(name, projectTypes[0], projectTypes[1], fieldName);
				}else {//项目类型被选（0个或者3个）
					projectNum = projectDao.highCount(name, fieldName);
				}
			}else {//4.项目类型不为空，且领域名为空
				
				if(projectTypes.length == 1) {//项目类型被选（1个）
					projectNum = projectDao.highCountWithoutFieldName(name, projectTypes[0]);
				}else if(projectTypes.length == 2){//项目类型被选（2个）
					projectNum = projectDao.highCountWithoutFieldName(name, projectTypes[0], projectTypes[1]);
				}else {//项目类型被选（0个或者3个）
					projectNum = projectDao.countByName(name);
				}
			}
		}else if(projectTypeRadio == null){//2.项目类型为空
			
			if(fieldName != null && (! "".equals(fieldName))) {//3.项目类型为空，且领域名不为空
				projectNum = projectDao.highCount(name, fieldName);
			}else {//4.项目类型为空，且领域名为空
				projectNum = projectDao.countByName(name);
			}
		}
		
		return projectNum;
	}

	/**
	 * @Description:列出所有属于该用户的项目
	 * @exception:
	 */
	@Override
	public List<UserIndexProject> listMyProjects(Integer userInfoId, PageUtil page) throws Exception {
		
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		List<Project> projects = projectDao.findByUserInfoId(userInfoId, page);
		List<UserIndexProject> userIndexProjects = new ArrayList<>();
		UserIndexProject userIndexProject = null;
		for (Project project : projects) {
			userIndexProject = new UserIndexProject();
			userIndexProject.setId(project.getId());
			userIndexProject.setTitle(project.getTitle());
			userIndexProject.setStage(project.getStage());
			userIndexProject.setStatus(project.getStatus());
			
			userIndexProjects.add(userIndexProject);
		}
		return userIndexProjects;
	}

	/**
	 * @Description:根据用户计算该用户拥有的项目数量
	 * @exception:
	 */
	@Override
	public long countByUser(Integer userInfoId) throws Exception {
		return projectDao.countByUserInfoId(userInfoId);
	}

	/**
	 * @Description:根据项目id获取项目发布到第几步的信息
	 * @exception:
	 */
	@Override
	public int getProjectStep(Integer projectId) throws Exception {
		
		Project project = projectDao.get(Project.class, projectId);
		return project.getStep();
	}

	
	
	
	
}
