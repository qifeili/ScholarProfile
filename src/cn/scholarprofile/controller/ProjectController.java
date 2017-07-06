package cn.scholarprofile.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.scholarprofile.dto.ProjectInfoStep02;
import cn.scholarprofile.dto.ProjectInfoDetails;
import cn.scholarprofile.service.FieldService;
import cn.scholarprofile.service.FileService;
import cn.scholarprofile.service.ProjectService;
import cn.scholarprofile.bean.Field;

/**
 * springmvc的控制类
 * 
 * @author 庞超
 *
 */
@Controller
public class ProjectController {

	// private UserInfoService userInfoService;
	private ProjectService projectService;
	private FileService fileService;
	private FieldService fieldService;

	/*
	 * public UserInfoService getUserInfoService() { return userInfoService; }
	 * 
	 * @Resource public void setUserInfoService(UserInfoService userInfoService)
	 * { this.userInfoService = userInfoService; }
	 */

	public ProjectService getProjectService() {
		return projectService;
	}

	@Resource
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public FileService getFileService() {
		return fileService;
	}

	@Resource
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
	
	public FieldService getFieldService() {
		return fieldService;
	}

	@Resource
	public void setFieldService(FieldService fieldService) {
		this.fieldService = fieldService;
	}

	@RequestMapping("/publishingProjectStep01.do")
	public String publishingProjectStep01(HttpServletResponse response,
			HttpServletRequest request, String projectType) throws Exception {
		// 测试时暂时用userInfoId = 1
		//Integer userInfoId = 1;
		Integer userInfoId = (Integer)request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {//用户未登录时返回登录页面
			return "publishingProjectStep01";
		}
		
		System.out.println(userInfoId);
		
		Integer projectId = projectService.publishingProjectStep01(userInfoId,
				projectType);
		/*if(projectId == null) {//如果项目不存在返回发布项目首页
			return "publishingProjectStep01";
		}*/
		
		request.getSession().setAttribute("projectId", projectId);
		request.setAttribute("projectType", projectType);

		return "publishingProjectStep02";
	}

	@RequestMapping("/publishingProjectUpdateProjectType.do")
	public String publishingProjectUpdateProjectType(
			HttpServletResponse response, HttpServletRequest request,
			String projectType) throws Exception {

		// 测试时暂时用userInfoId = 1
		//Integer userInfoId = 1;
		Integer userInfoId = (Integer)request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {//用户未登录时返回登录页面
			return "publishingProjectStep01";
		}
		
		Integer projectId = (Integer) request.getSession().getAttribute("projectId");
		if(projectId == null) {//如果项目不存在返回发布项目首页
			return "publishingProjectStep01";
		}
		projectService.publishingProjectUpdateProjectType(projectId,
				projectType);

		request.getSession().setAttribute("projectId", projectId);
		request.setAttribute("projectType", projectType);

		return "publishingProjectStep02";
	}

	@RequestMapping("/publishingProjectStep02.do")
	public String publishingProjectStep02(HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(value="upLoadEnclosureInput", required=false) CommonsMultipartFile[] upLoadEnclosureInput,
			@RequestParam(value="upLoadDataSetInput", required=false) CommonsMultipartFile[] upLoadDataSetInput,
			ProjectInfoStep02 info) throws Exception {

		// 测试时暂时用userInfoId = 1
		//Integer userInfoId = 1;
		Integer userInfoId = (Integer)request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {//用户未登录时返回登录页面
			return "publishingProjectStep02";
		}
		Integer projectId = (Integer) request.getSession().getAttribute("projectId");
		if(projectId == null) {//如果项目不存在返回发布项目首页
			return "publishingProjectStep02";
		}
		//上传文件，并将上传的路径交给service层处理
		//获取存储文件的文件夹的绝对路径,为防盗链放在WEB-INF/upload
		String seprator = System.getProperty("file.separator");//系统的路径分隔符
		String uploadfilepath = request.getSession().getServletContext().getRealPath("");
		uploadfilepath = uploadfilepath.substring(0, uploadfilepath.lastIndexOf(seprator)) + seprator + "scholarupload" + seprator;
		if (upLoadEnclosureInput != null) {
			for (int i = 0; i < upLoadEnclosureInput.length; i++) {
				String filename = upLoadEnclosureInput[i].getOriginalFilename();
				/*String path = request.getSession().getServletContext()
						.getRealPath("/upload/" + userInfoId + "/" + projectId + "/enclosure" + "/" + filename);// 存放位置*/				
//				String path = FileBasePathUtil.getFileBasePath() + userInfoId + "/" + projectId + "/enclosure" + "/" + filename;// 存放位置
				String path = uploadfilepath + userInfoId + seprator + projectId + seprator + "enclosure" + seprator + filename;// 存放位置
				File destFile = new File(path);
				try {
					// 如果文件不存在，则创建目录和所需的所有上级目录
					if (!destFile.exists()) {
						destFile.mkdirs();
					}else {//如果文件存在，给文件加上时间戳
						filename = System.currentTimeMillis() + "_" + filename;
//						path = FileBasePathUtil.getFileBasePath() + userInfoId + "/" + projectId + "/enclosure" + "/" + filename;// 存放位置
						path = uploadfilepath + userInfoId + seprator + projectId + seprator + "enclosure" + seprator + filename;// 存放位置
						destFile = new File(path);
						if(!destFile.exists()){
							destFile.mkdirs();
						}
					}
					upLoadEnclosureInput[i].transferTo(destFile);
					fileService.uploadEnclosure(path, filename, userInfoId.toString(), projectId, 1);//1表示上传的文件类型是文件附件
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (upLoadDataSetInput != null) {
			for (int i = 0; i < upLoadDataSetInput.length; i++) {
				String filename = upLoadDataSetInput[i].getOriginalFilename();
				/*String path = request.getSession().getServletContext()
						.getRealPath("/upload/" + userInfoId + "/" + projectId + "/dataset" + "/" + filename);// 存放位置
				 */				
//				String path = FileBasePathUtil.getFileBasePath() + userInfoId + "/" + projectId + "/dataset" + "/" + filename;// 存放位置
				String path = uploadfilepath + userInfoId + seprator + projectId + seprator +"dataset" + seprator + filename;// 存放位置
				File destFile = new File(path);
				try {
					// 如果文件不存在，则创建目录和所需的所有上级目录
					if (!destFile.exists()) {
						destFile.mkdirs();
					}else {//如果文件存在，给文件加上时间戳
						filename = System.currentTimeMillis() + "_" + filename;
//						path = FileBasePathUtil.getFileBasePath() + userInfoId + "/" + projectId + "/dataset" + "/" + filename;// 存放位置
						path = uploadfilepath + userInfoId + seprator + projectId + seprator + "dataset" + seprator + filename;// 存放位置
						destFile = new File(path);
						if(!destFile.exists()){
							destFile.mkdirs();
						}
					}
					upLoadDataSetInput[i].transferTo(destFile);
					fileService.uploadDataSet(path, filename, userInfoId.toString(), projectId, info, 2, i);//2表示上传的文件类型是数据集,i表示迭代层数
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//上传文件结束
		
		//更新项目的其他标准信息
		projectService.publishingProjectStep02(projectId, info);
		
		return "publishingProjectStep03";
	}
	
	@RequestMapping("/publishingProjectUpdateStep02.do")
	public String publishingProjectUpdateStep02(HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(value="upLoadEnclosureInput", required=false) CommonsMultipartFile[] upLoadEnclosureInput,
			@RequestParam(value="upLoadDataSetInput", required=false) CommonsMultipartFile[] upLoadDataSetInput,
			ProjectInfoStep02 info) throws Exception{
		
		// 测试时暂时用userInfoId = 1
		//Integer userInfoId = 1;
		Integer userInfoId = (Integer)request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {//用户未登录时返回登录页面
			return "publishingProjectStep02";
		}
		
		Integer projectId = (Integer) request.getSession().getAttribute("projectId");
		if(projectId == null) {//如果项目不存在返回发布项目首页
			return "publishingProjectStep02";
		}
		//根据项目Id将之前上传的文件全部删除
		projectService.removeFilesByProjectId(projectId);
		
		String seprator = System.getProperty("file.separator");//系统的路径分隔符
		String uploadfilepath = request.getSession().getServletContext().getRealPath("");
		uploadfilepath = uploadfilepath.substring(0, uploadfilepath.lastIndexOf(seprator)) + seprator +"scholarupload" + seprator;
		
		//上传文件，并将上传的路径交给service层处理
		if (upLoadEnclosureInput != null) {
			for (int i = 0; i < upLoadEnclosureInput.length; i++) {
				String filename = upLoadEnclosureInput[i].getOriginalFilename();
				String path = uploadfilepath + userInfoId + seprator + projectId + seprator + "enclosure" + seprator + filename;// 存放位置
				File destFile = new File(path);
				try {
					// 如果文件不存在，则创建目录和所需的所有上级目录
					if (!destFile.exists()) {
						destFile.mkdirs();
					}else {//如果文件存在，给文件加上时间戳
						filename = System.currentTimeMillis() + "_" + filename;
						path = uploadfilepath + userInfoId + seprator + projectId + seprator + "enclosure" + seprator + filename;// 存放位置
						destFile = new File(path);
						if(!destFile.exists()){
							destFile.mkdirs();
						}
					}
					upLoadEnclosureInput[i].transferTo(destFile);
					fileService.uploadEnclosure(path, filename, userInfoId.toString(), projectId, 1);//1表示上传的文件类型是文件附件
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (upLoadDataSetInput != null) {
			for (int i = 0; i < upLoadDataSetInput.length; i++) {
				String filename = upLoadDataSetInput[i].getOriginalFilename();
				String path = uploadfilepath + userInfoId + seprator + projectId + seprator + "dataset" + seprator + filename;// 存放位置
				File destFile = new File(path);
				try {
					// 如果文件不存在，则创建目录和所需的所有上级目录
					if (!destFile.exists()) {
						destFile.mkdirs();
					}else {//如果文件存在，给文件加上时间戳
						filename = System.currentTimeMillis() + "_" + filename;
						path = uploadfilepath + userInfoId + seprator + projectId + seprator + "dataset" + seprator + filename;// 存放位置
						destFile = new File(path);
						if(!destFile.exists()){
							destFile.mkdirs();
						}
					}
					upLoadDataSetInput[i].transferTo(destFile);
					fileService.uploadDataSet(path, filename, userInfoId.toString(), projectId, info, 2, i);//2表示上传的文件类型是数据集,i表示迭代层数
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//上传文件结束
		
		//更新项目的其他标准信息
		projectService.publishingProjectStep02(projectId, info);
		
		return "publishingProjectStep03";
	}

	@RequestMapping("/publishingProjectStep03.do")
	public String publishingProjectStep03(HttpServletResponse response,
			HttpServletRequest request, @RequestParam(value="priceInput", required=false) Double budget) throws Exception {

		// 测试时暂时用userInfoId = 1
		//Integer userInfoId = 1;
		Integer userInfoId = (Integer)request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {//用户未登录时返回登录页面
			return "publishingProjectStep03";
		}
		
		Integer projectId = (Integer) request.getSession().getAttribute("projectId");
		if(projectId == null) {//如果项目不存在返回发布项目首页
			return "publishingProjectStep03";
		}
		projectService.publishingProjectStep03(projectId, budget);
		// 此处需要添加publishingProjectStep04.jsp页面所需要的数据
		ProjectInfoDetails details = projectService.getProjectDetails(projectId);
		request.setAttribute("details", details);
		
		return "publishingProjectStep04";
	}

	@RequestMapping("/publishingProjectStep04.do")
	public String publishingProjectStep04(HttpServletResponse response,
			HttpServletRequest request) throws Exception {

		// 测试时暂时用userInfoId = 1
		//Integer userInfoId = 1;
		Integer userInfoId = (Integer)request.getSession().getAttribute("userInfoId");
		if(userInfoId == null) {//用户未登录时返回登录页面
			return "publishingProjectStep04";
		}
				
		Integer projectId = (Integer) request.getSession().getAttribute("projectId");
		if(projectId == null) {//如果项目不存在返回发布项目首页
			return "publishingProjectStep04";
		}
		projectService.publishingProjectStep04(projectId);

		// 项目发布完成后，清除session中的projectId，以免出现别的bug
		request.getSession().setAttribute("projectId", null);

		return "redirect:/projectInfoDetail.do?projectId=" + projectId;
	}
	
	@RequestMapping("/projectInfoDetail.do")
	public String projectInfoDetail(HttpServletResponse response,
			HttpServletRequest request, @RequestParam(value="projectId", required=true) Integer projectId) throws Exception {
		
		ProjectInfoDetails details = projectService.getProjectDetails(projectId);
		request.setAttribute("details", details);
		return "projectInfo";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/getAllFieldNameAjax.do")
	// added by liuyong
	// 发布项目第二步中，“选择领域”下拉框通过该接口读取所有的领域名称
	public List<String> getAllFieldNameAjax(HttpServletRequest request)
			throws Exception {
		List<Field> fieldList = fieldService.listAll();
		List<String> fieldNameList = new ArrayList<>();
		for (Field field : fieldList) {
			fieldNameList.add(field.getName());
		}
		return fieldNameList;
	}
	
	@ResponseBody
	@RequestMapping("/continuePublishProject.do")
	public String continuePublishProject(HttpServletResponse response,
			HttpServletRequest request, Integer projectId) throws Exception {
		
		if(projectId == null) {
			return "index";
		}
		int step = projectService.getProjectStep(projectId);
		switch(step) {
			case 0:
				request.getSession().setAttribute("projectId", projectId);
				return "publishingProjectStep01.jsp";
			case 1:
				request.getSession().setAttribute("projectId", projectId);
				return "publishingProjectStep02.jsp";
			case 2:
				request.getSession().setAttribute("projectId", projectId);
				return "publishingProjectStep03.jsp";
			case 3:
				request.getSession().setAttribute("projectId", projectId);
				return "publishingProjectStep04.jsp";
			case 4:
			default:
				return "userIndexProject.jsp";
		}
	}
}
