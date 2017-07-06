package cn.scholarprofile.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.scholarprofile.bean.Scholar;
import cn.scholarprofile.dto.ScholarInfo;
import cn.scholarprofile.service.ScholarService;
import cn.scholarprofile.util.PageUtil;

/**
 * springmvc的控制类
 * 
 * @author 庞超
 *
 */
@Controller
public class CompanyListController {

	
	private ScholarService scholarService;
	
	public ScholarService getScholarService() {
		return scholarService;
	}

	@Resource
	public void setScholarService(ScholarService scholarService) {
		this.scholarService = scholarService;
	}


	/**
	 * @Description:列出所有查询的信息，无分页
	 * @exception:
	 */
	@RequestMapping("/searchallexpertlist.do")
	public String searchAllCompanyList(HttpServletResponse response, ModelMap modelMap,
			String srcType, String srcText) throws Exception {
		List<Scholar> scholars = null;
		int scholarNum = 0; //统计数据个数
		// 根据srcType值的不同调用不同的service
		if ("领域".equals(srcType)) {
			
			scholars = scholarService.findByFieldName(srcText);
			modelMap.put("scholars", scholars);
			
		} else if ("研究者".equals(srcType)) {

			scholars = scholarService.findByName(srcText);
			modelMap.put("scholars", scholars);
		} else if ("组织机构".equals(srcType)) {

			scholars = scholarService.findByInstitutionName(srcText);
			modelMap.put("scholars", scholars);
		}
		
		if (scholars != null) {
			scholarNum = scholars.size();
		}
		modelMap.put("scholarNum", scholarNum);

		return "companyList";
	}
	
	@RequestMapping("/toadd1.do")
	public String searchAllCompanyList1(HttpServletResponse response, ModelMap modelMap,
			String srcType, String srcText) throws Exception {

		System.out.println("srcType-->" + srcType + "--srcText--->" + srcText);
		List<Scholar> scholars = null;
		int scholarNum = 0; //统计数据个数
		// 根据srcType值的不同调用不同的service
		if ("领域".equals(srcType)) {
			
			scholars = scholarService.findByFieldName(srcText);
			modelMap.put("scholars", scholars);
			
		} else if ("研究者".equals(srcType)) {

			scholars = scholarService.findByName(srcText);
			modelMap.put("scholars", scholars);
		} else if ("组织机构".equals(srcType)) {

			scholars = scholarService.findByInstitutionName(srcText);
			modelMap.put("scholars", scholars);
		}
		
		if (scholars != null) {
			scholarNum = scholars.size();
		}
		modelMap.put("scholarNum", scholarNum);

		return "companyList";
	}
	
	
	
	/**
	 * @Description:查询某页的信息，用户未登录情况，有分页
	 * @exception:
	 *//*
	@RequestMapping("/searchexpertlist.do")
	public String searchCompanyList(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap,Integer curPage,
		String srcType, String srcText) throws Exception {
		
		//定义分页变量
		PageUtil page = new PageUtil();
		
		if(curPage != null) 
			page.setCurPage(curPage);
		
		List<Scholar> scholars = null;
		long scholarNum = 0; //统计数据个数
		// 根据srcType值的不同调用不同的service
		if (srcType.equals("领域")) {
			
			scholars = scholarService.findByFieldName(srcText,page);
			scholarNum = scholarService.countByFieldName(srcText);
			request.setAttribute("scholarNum", scholarNum);
			
			//装载前台page变量
			page.setMaxRowCount(scholarNum);
			if(page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
			}else {
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
			}	
			request.setAttribute("maxPage", page.getMaxPage());
			request.setAttribute("rowsPerPage", page.getRowsPerPage());
			
			if(page.getMaxPage() > 0){
				request.setAttribute("curPage", page.getCurPage());			
			}else {
				request.setAttribute("curPage", 0);	
			}
				
			request.setAttribute("scholars", scholars);
			
			
		} else if (srcType.equals("研究者")) {
			
			//scholars = scholarService.findByName(srcText);
			scholars = scholarService.findByName(srcText,page);
			scholarNum = scholarService.countByName(srcText);
			request.setAttribute("scholarNum", scholarNum);
			
			//装载前台page变量
			page.setMaxRowCount(scholarNum);
			if(page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
			}else {
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
			}	
			request.setAttribute("maxPage", page.getMaxPage());
			request.setAttribute("rowsPerPage", page.getRowsPerPage());
			
			if(page.getMaxPage() > 0){
				request.setAttribute("curPage", page.getCurPage());			
			}else {
				request.setAttribute("curPage", 0);	
			}
			
			request.setAttribute("scholars", scholars);
		} else if (srcType.equals("组织机构")) {
			
			//scholars = scholarService.findByInstitutionName(srcText);
			scholars = scholarService.findByInstitutionName(srcText,page);
			scholarNum = scholarService.countByInstitutionName(srcText);
			request.setAttribute("scholarNum", scholarNum);
			
			//装载前台page变量
			page.setMaxRowCount(scholarNum);
			if(page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
			}else {
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
			}	
			request.setAttribute("maxPage", page.getMaxPage());
			request.setAttribute("rowsPerPage", page.getRowsPerPage());

			if(page.getMaxPage() > 0){
				request.setAttribute("curPage", page.getCurPage());			
			}else {
				request.setAttribute("curPage", 0);	
			}
			
			request.setAttribute("scholars", scholars);
		}
		
		request.setAttribute("srcType", srcType);
		request.setAttribute("srcText", srcText);
		return "companyList";
	}*/
	
	/**
	 * @Description:查询某页的信息，用户已登录情况，有分页
	 * @exception:
	 */
	@RequestMapping("/searchexpertlist.do")
	public String searchCompanyList(HttpServletResponse response, HttpServletRequest request, ModelMap modelMap,Integer curPage,
			String srcType, String srcText) throws Exception {
		//判断用户是否已经登录
		//测试时使用
		//Integer userInfoId = 1;
		Integer userInfoId = (Integer)request.getSession().getAttribute("userInfoId");
		
		//定义分页变量
		PageUtil page = new PageUtil();
		
		if(curPage != null) 
			page.setCurPage(curPage);
		
		List<ScholarInfo> scholars = null;
		long scholarNum = 0; //统计数据个数
		// 根据srcType值的不同调用不同的service
		if (srcType.equals("领域")) { 
			//关键字是""时，在solr里检索会出错，故而转换成"*"，意思提取全部学者信息
			String srcTextforSearch = srcText.trim().equals("") ? "*" : srcText.trim();
			if(userInfoId == null) {//用户未登录
				// 添加了solr索引、缓存机制
//				scholars = scholarService.findByFieldName(srcText, page);
				scholars = scholarService.findByFieldNameAndSolr(srcTextforSearch, page);
			}else {//用户已登录
//				scholars = scholarService.findByFieldName(userInfoId, srcText, page);
				scholars = scholarService.findByFieldNameAndSolr(userInfoId, srcTextforSearch, page);
			}
//			scholarNum = scholarService.countByFieldName(srcText);
			scholarNum = page.getMaxRowCount();
			request.setAttribute("scholarNum", scholarNum);
			
			//装载前台page变量
			page.setMaxRowCount(scholarNum);
			if(page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
			}else {
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
			}	
			request.setAttribute("maxPage", page.getMaxPage());
			request.setAttribute("rowsPerPage", page.getRowsPerPage());
			
			if(page.getMaxPage() > 0){
				request.setAttribute("curPage", page.getCurPage());			
			}else {
				request.setAttribute("curPage", 0);	
			}
			
			request.setAttribute("scholars", scholars);
			
			
		} else if ("研究者".equals(srcType)) {
			
			//scholars = scholarService.findByName(srcText);
			if(userInfoId == null) {//用户未登录
				scholars = scholarService.findByName(srcText, page);				
			}else {//用户已登录
				scholars = scholarService.findByName(userInfoId, srcText, page);
			}
			scholarNum = scholarService.countByName(srcText);
			request.setAttribute("scholarNum", scholarNum);
			
			//装载前台page变量
			page.setMaxRowCount(scholarNum);
			if(page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
			}else {
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
			}	
			request.setAttribute("maxPage", page.getMaxPage());
			request.setAttribute("rowsPerPage", page.getRowsPerPage());
			
			if(page.getMaxPage() > 0){
				request.setAttribute("curPage", page.getCurPage());			
			}else{
				request.setAttribute("curPage", 0);	
			}
			
			request.setAttribute("scholars", scholars);
		} else if ("组织机构".equals(srcType)) {
			
			//scholars = scholarService.findByInstitutionName(srcText);
			if(userInfoId == null) {//用户未登录
				scholars = scholarService.findByInstitutionName(srcText, page);				
			}else {//用户已登录
				scholars = scholarService.findByInstitutionName(userInfoId, srcText, page);	
			}
			scholarNum = scholarService.countByInstitutionName(srcText);
			request.setAttribute("scholarNum", scholarNum);
			
			//装载前台page变量
			page.setMaxRowCount(scholarNum);
			if(page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
			}else {
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
			}	
			request.setAttribute("maxPage", page.getMaxPage());
			request.setAttribute("rowsPerPage", page.getRowsPerPage());
			
			if(page.getMaxPage() > 0){
				request.setAttribute("curPage", page.getCurPage());			
			}else {
				request.setAttribute("curPage", 0);	
			}
			
			request.setAttribute("scholars", scholars);
		}
		
		request.setAttribute("srcType", srcType);
		request.setAttribute("srcText", srcText);
		return "companyList";
	}
	
	
	//这个是用户信息详情页展示 liqifei
	@RequestMapping("/companyInfo.do")
	public String companyInfo(String name,String institution,Integer curPage,HttpServletRequest request) throws UnsupportedEncodingException{               
		PageUtil page=new PageUtil();
		page.setRowsPerPage(6);
	if(curPage!=null){
		page.setCurPage(curPage);}
/*	两种href传值乱码解决方案，只能选择一种：2.	String name=new String(request.getParameter("name1").getBytes("ISO-8859-1"),"utf-8");                //解决href传值过程中出现的乱码问题。
	                                                                   	String institution=new String(request.getParameter("institution1").getBytes("ISO-8859-1"),"utf-8");  //解决href传值过程中出现的乱码问题。*/	
		Scholar scholar= scholarService.findinfo(name,institution);     //核心查询语句
		request.setAttribute("s",scholar);
		// 将string值转化为JSON List类型，并给前台传递paperlist.title的值。
		try {
			JSONArray jsonArray = new JSONArray(scholar.getPaperlist());					
			request.setAttribute("papernum",jsonArray.length());
			//装载前台page变量
			page.setMaxRowCount(jsonArray.length());
			if(page.getMaxRowCount() % page.getRowsPerPage() == 0) {//
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage());
			}else {
				page.setMaxPage(page.getMaxRowCount() / page.getRowsPerPage() + 1);
			}	
			request.setAttribute("maxPage", page.getMaxPage());
			request.setAttribute("rowsPerPage", page.getRowsPerPage());
			
			if(page.getMaxPage() > 0){
				request.setAttribute("curPage", page.getCurPage());			
			}else {
				request.setAttribute("curPage", 0);	
			} 	
		request.setAttribute("m", (page.getCurPage()-1)*page.rowsPerPage);
		request.setAttribute("one", jsonArray.get((page.getCurPage()-1)*page.rowsPerPage+0));
		request.setAttribute("two", jsonArray.get((page.getCurPage()-1)*page.rowsPerPage+1));   
		request.setAttribute("three", jsonArray.get((page.getCurPage()-1)*page.rowsPerPage+2));
		request.setAttribute("four", jsonArray.get((page.getCurPage()-1)*page.rowsPerPage+3));
		request.setAttribute("five", jsonArray.get((page.getCurPage()-1)*page.rowsPerPage+4));
		request.setAttribute("six", jsonArray.get((page.getCurPage()-1)*page.rowsPerPage+5));       
       System.out.println("执行吗？上面出错就不再执行了。");}		
		catch (JSONException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}		
		
		//下面是做给图表传值的。
		float x=scholar.getOutcome(),
        sa= scholar.getPercent_journal(),   sb= scholar.getPercent_conference(), 
        sc=scholar.getPercent_booktitle(),    sd= scholar.getPercent_other();
		int a=(int) (x*sa/100),b=(int) (x*sb/100),c=(int) (x*sc/100),d=(int) (x*sd/100);
		request.setAttribute("a", a);request.setAttribute("b",b);request.setAttribute("c", c);request.setAttribute("d", d);
		
		return "companyInfo";
	}
	
	
	
	
	/**
	 * @Description:专家列表导向页
	 * @exception:
	 */
	@RequestMapping("/expertlist.do")
	public String companyList(HttpServletResponse response, HttpServletRequest request) {
		
		System.out.println("后台已收到数据");
		return "companyList";
	}
}
