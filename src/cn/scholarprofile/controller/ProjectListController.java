package cn.scholarprofile.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.scholarprofile.dto.ProjectInfo;
import cn.scholarprofile.dto.UserIndexProject;
import cn.scholarprofile.service.HeatService;
import cn.scholarprofile.service.ProjectService;
import cn.scholarprofile.util.PageUtil;

/**
 * springmvc的控制类
 * 
 * @author 庞超
 *
 */
@Controller
public class ProjectListController {

	private ProjectService projectService;
	private HeatService heatService;

	public ProjectService getProjectService() {
		return projectService;
	}

	@Resource
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public HeatService getHeatService() {
		return heatService;
	}

	@Resource
	public void setHeatService(HeatService heatService) {
		this.heatService = heatService;
	}

	/**
	 * @Description:查询某页的信息，用户已登录情况, 有分页
	 * @exception:
	 */
	@RequestMapping("/searchprojectlist.do")
	public String searchProjectList(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap,
			Integer curPage, String srcText, String projectTypeRadio, String fieldName, String searchType) throws Exception {
		
		//判断用户是否已经登录
		//测试时使用
		//Integer userInfoId = 1;
		Integer userInfoId = (Integer)request.getSession().getAttribute("userInfoId");
		
		// 定义分页变量
		PageUtil page = new PageUtil();
		
		if (curPage != null)
			page.setCurPage(curPage);
		
		List<ProjectInfo> projects = null;
		long projectNum = 0; // 统计数据个数
		
		if ((projectTypeRadio == null || projectTypeRadio == "") && (fieldName == null || fieldName == "")) {// 普通搜索
			if(userInfoId == null) {
				projects = projectService.findByName(srcText, page);
			}else {
				projects = projectService.findByName(userInfoId, srcText, page);
			}
			projectNum = projectService.countByName(srcText);
			
		} else {// 高级搜索
			if(userInfoId == null) {
				projects = projectService.highFind(srcText, projectTypeRadio, fieldName, page);
			}else {
				projects = projectService.highFind(userInfoId, srcText, projectTypeRadio, fieldName, page);
			}
			projectNum = projectService.highCount(srcText, projectTypeRadio, fieldName);
			
			request.setAttribute("projectTypeRadio", projectTypeRadio);
			request.setAttribute("fieldName", fieldName);
			
		}
		
		request.setAttribute("projectNum", projectNum);
		
		// 装载前台page变量
		page.setMaxRowCount(projectNum);
		
		if (page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
			page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
		} else {
			page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
		}
		request.setAttribute("maxPage", page.getMaxPage());
		request.setAttribute("rowsPerPage", page.getRowsPerPage());
		
		if (page.getMaxPage() > 0) {
			request.setAttribute("curPage", page.getCurPage());
		} else {
			request.setAttribute("curPage", 0);
		}
		
		request.setAttribute("projects", projects);
		request.setAttribute("srcText", srcText);
		//记录搜索类型
		request.setAttribute("searchType", searchType);
		return "projectList";
	}

	/**
	 * @Description:查询某页的信息，有分页
	 * @exception:
	 */
	@RequestMapping("/userIndexProject.do")
	public String userIndexProject(HttpServletResponse response, HttpServletRequest request, Integer curPage) throws Exception {

		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		if (userInfoId == null) {
			return "userIndexProject";
		}
		// 定义分页变量
		PageUtil page = new PageUtil();

		if (curPage != null)
			page.setCurPage(curPage);
		List<UserIndexProject> myProjects = projectService.listMyProjects(userInfoId, page);
		long myProjectsNum = 0;
		myProjectsNum = projectService.countByUser(userInfoId);
		// 装载前台page变量
		page.setMaxRowCount(myProjectsNum);

		if (page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
			page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
		} else {
			page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
		}
		request.setAttribute("maxPage", page.getMaxPage());
		request.setAttribute("rowsPerPage", page.getRowsPerPage());

		if (page.getMaxPage() > 0) {
			request.setAttribute("curPage", page.getCurPage());
		} else {
			request.setAttribute("curPage", 0);
		}

		request.setAttribute("myProjects", myProjects);
		return "userIndexProject";

	}
	
	/**
	 * @Description:项目列表页的转向页
	 * @exception:
	 */
	@RequestMapping("/projectlist.do")
	public String projectList(HttpServletResponse response, HttpServletRequest request) {
		
		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		//用户未登录，返回全局热门领域
		if(userInfoId == null) {
			//暂时预留---->此处添加全局热门领域的数据
			List<String> hotFieldNames = heatService.findGlobalHotFieldNamesByUserInfoId();
			request.getSession().setAttribute("hotFieldNames", hotFieldNames);
		}else {//用户已登录，查找对应的热门领域，若未找到对应的热门领域，则返回全局热门领域
			List<String> hotFieldNames = heatService.findHotFieldNamesByUserInfoId(userInfoId);
			if(null == hotFieldNames || hotFieldNames.size() == 0) {
				//暂时预留---->此处添加全局热门领域的数据
				hotFieldNames = heatService.findGlobalHotFieldNamesByUserInfoId();
				request.getSession().setAttribute("hotFieldNames", hotFieldNames);
			}else {
				//包装数据，发送到jsp
				request.getSession().setAttribute("hotFieldNames", hotFieldNames);
			}
		}
		
		return "projectList";
	} 
}
