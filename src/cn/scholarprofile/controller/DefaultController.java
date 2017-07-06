package cn.scholarprofile.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.scholarprofile.dto.IndexInfo;
import cn.scholarprofile.service.IndexService;

/**springmvc的控制类,处理所有默认情况下的跳转
 * 
 * @author 庞超
 *
 */
@Controller
public class DefaultController {
	
	private IndexService indexService;
	
	public IndexService getIndexService() {
		return indexService;
	}

	@Resource
	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	/**
	 * @Description:重定向默认情况下去欢迎页
	 * @exception:
	 */
	@RequestMapping("/index")
	public String index(HttpServletResponse response, HttpServletRequest request) throws Exception{
		
		IndexInfo indexInfo = indexService.getIndexInfo();
		request.setAttribute("indexInfo", indexInfo);
		return "index";
	}
}
