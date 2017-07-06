package cn.scholarprofile.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.scholarprofile.dto.ReviewProjectInfo;
import cn.scholarprofile.dto.ReviewScholarInfo;
import cn.scholarprofile.service.FocusProjectService;
import cn.scholarprofile.service.FocusService;
import cn.scholarprofile.util.PageUtil;

/**
 * springmvc的控制类
 * 
 * @author 庞超
 *
 */
@Controller
public class FocusController {

	private FocusService focusService;
	private FocusProjectService focusProjectService;

	public FocusService getFocusService() {
		return focusService;
	}

	@Resource
	public void setFocusService(FocusService focusService) {
		this.focusService = focusService;
	}

	public FocusProjectService getFocusProjectService() {
		return focusProjectService;
	}

	@Resource
	public void setFocusProjectService(FocusProjectService focusProjectService) {
		this.focusProjectService = focusProjectService;
	}

	// 专为改变关注学者而制定的方法
	@ResponseBody
	@RequestMapping(value = "/changeFocusAjax.do")
	public String changeFocus(HttpServletResponse response, HttpServletRequest request, Integer scholarId)
			throws Exception {

		// 如果用户未登录，返回"false",前端跳转到登录页面, 如果用户登录，改变关注状态后返回"true"，前端修改样式
		// 测试时暂时用userInfoId = 1
		// Integer userInfoId = 1;
		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		if (userInfoId == null || scholarId == null) {// 用户未登录时返回登录页面
			return "false";
		}

		Boolean result = focusService.changeFocusStatus(userInfoId, scholarId);
		return result.toString();
	}

	// 专为改变关注项目而制定的方法
	@ResponseBody
	@RequestMapping(value = "/changeFocusProjectAjax.do")
	public String changeFocusProject(HttpServletResponse response, HttpServletRequest request, Integer projectId)
			throws Exception {

		// 如果用户未登录，返回"false",前端跳转到登录页面, 如果用户登录，改变关注状态后返回"true"，前端修改样式
		// 测试时暂时用userInfoId = 1
		// Integer userInfoId = 1;
		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		if (userInfoId == null || projectId == null) {// 用户未登录时返回登录页面
			return "false";
		}

		Boolean result = focusProjectService.changeFocusProjectStatus(userInfoId, projectId);
		return result.toString();
	}

	@RequestMapping(value = "/userIndexReviews.do")
	public String userIndexReviews(HttpServletResponse response, HttpServletRequest request,
			/* project部分的分页 */Integer curPage, /*scholar部分的分页*/ Integer curPage2) throws Exception {
		
		Integer userInfoId = (Integer) request.getSession().getAttribute("userInfoId");
		//用户未登录情况下，直接返回
		if(userInfoId == null) {
			return "userIndexReviews";
		}
		// 定义分页变量1
		PageUtil page = new PageUtil();
		if (curPage != null)
			page.setCurPage(curPage);
		List<ReviewProjectInfo> reviewProjectInfos = focusProjectService.findFocusProjectInfo(userInfoId, page);
		// 统计数据个数
		long ProjectInfoNum = focusProjectService.countByUserInfoId(userInfoId);
		
		page.setMaxRowCount(ProjectInfoNum);
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
		request.setAttribute("reviewProjectInfos", reviewProjectInfos);
		
		// 定义分页变量2
		PageUtil page2 = new PageUtil();
		if (curPage2 != null)
			page2.setCurPage(curPage2);
		List<ReviewScholarInfo> reviewScholarInfos = focusService.findFocusInfo(userInfoId, page2);
		// 统计数据个数
		long ScholarInfoNum = focusService.countByUserInfoId(userInfoId);
		
		page2.setMaxRowCount(ScholarInfoNum);
		if (page2.getMaxRowCount() % page2.getRowsPerPage() == 0) {//
			page2.setMaxPage(page2.getMaxRowCount() / page2.getRowsPerPage());
		} else {
			page2.setMaxPage(page2.getMaxRowCount() / page2.getRowsPerPage() + 1);
		}
		request.setAttribute("maxPage2", page2.getMaxPage());
		request.setAttribute("rowsPerPage2", page2.getRowsPerPage());
		
		if (page2.getMaxPage() > 0) {
			request.setAttribute("curPage2", page2.getCurPage());
		} else {
			request.setAttribute("curPage2", 0);
		}
		request.setAttribute("reviewScholarInfos", reviewScholarInfos);
		return "userIndexReviews";
	}
}
