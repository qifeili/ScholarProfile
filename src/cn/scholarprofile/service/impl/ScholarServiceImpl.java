/**
 * 
 */
package cn.scholarprofile.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Focus;
import cn.scholarprofile.bean.Scholar;
import cn.scholarprofile.dao.FocusDao;
import cn.scholarprofile.dao.ScholarDao;
import cn.scholarprofile.dto.ScholarInfo;
import cn.scholarprofile.dto.ScholarSort;
import cn.scholarprofile.service.ScholarService;
import cn.scholarprofile.util.BaiduTranslate;
import cn.scholarprofile.util.FieldQueryCacheManager;
import cn.scholarprofile.util.PageUtil;
import cn.scholarprofile.util.SolrService;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月24日 上午10:34:56
 * @Description :
 * @version 1.0
 */
@Service("scholarService")
@Transactional
public class ScholarServiceImpl implements ScholarService {

	private ScholarDao scholarDao;
	private FocusDao focusDao;
//	private FieldQueryCacheManager fieldQueryCacheManager;
//
//	public FieldQueryCacheManager getFieldQueryCacheManager() {
//		return fieldQueryCacheManager;
//	}
//	
//	@Resource
//	public void setFieldQueryCacheManager(FieldQueryCacheManager fieldQueryCacheManager) {
//		this.fieldQueryCacheManager = fieldQueryCacheManager;
//	}

	public ScholarDao getScholarDao() {
		return scholarDao;
	}

	@Resource
	public void setScholarDao(ScholarDao scholarDao) {
		this.scholarDao = scholarDao;
	}

	public FocusDao getFocusDao() {
		return focusDao;
	}

	@Resource
	public void setFocusDao(FocusDao focusDao) {
		this.focusDao = focusDao;
	}

	/**
	 * @Description:根据姓名进行模糊查询
	 * @exception:
	 */

	@Override
	public List<Scholar> findByName(String name) {
		return scholarDao.findByName(name);
	}

	/**
	 * @Description:根据姓名进行模糊查询，用户未登录，有分页
	 * @exception:
	 */
	@Override
	public List<ScholarInfo> findByName(String name, PageUtil page) {
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条

			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		List<Scholar> scholars = scholarDao.findByName(name, page);
		ScholarInfo scholarInfo = null;
		List<ScholarInfo> scholarInfos = new ArrayList<ScholarInfo>();
		for (Scholar scholar : scholars) {
			scholarInfo = new ScholarInfo();
			scholarInfo.setId(scholar.getId());
			scholarInfo.setEducation(scholar.getEducation());
			scholarInfo.setFollow(scholar.getFollow());
			scholarInfo.setFollowByCurrentUser(false);
			scholarInfo.setInstitution(scholar.getInstitution());
			scholarInfo.setName(scholar.getName());
			scholarInfo.setOutcome(scholar.getOutcome());
			scholarInfo.setPosition(scholar.getPosition());
			scholarInfo.setReference(scholar.getReference());
			
			scholarInfos.add(scholarInfo);
		}
		scholarInfo = null;
		return scholarInfos;
	}

	
	/** @Description:根据姓名进行模糊查询，用户已登录，有分页
	 * @exception:
	 */
	@Override
	public List<ScholarInfo> findByName(Integer userInfoId, String name,
			PageUtil page) {
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		List<Scholar> scholars = scholarDao.findByName(name, page);
		List<Focus> focus = focusDao.findByUserInfoId(userInfoId);
		ScholarInfo scholarInfo = null;		
		List<ScholarInfo> scholarInfos = new ArrayList<ScholarInfo>();
		if(focus == null || focus.size() == 0) {		
			for (Scholar scholar : scholars) {
				scholarInfo = new ScholarInfo();//放在外面add都是同一个对象
				scholarInfo.setId(scholar.getId());
				scholarInfo.setEducation(scholar.getEducation());
				scholarInfo.setFollow(scholar.getFollow());
				scholarInfo.setFollowByCurrentUser(false);
				scholarInfo.setInstitution(scholar.getInstitution());
				scholarInfo.setName(scholar.getName());
				scholarInfo.setOutcome(scholar.getOutcome());
				scholarInfo.setPosition(scholar.getPosition());
				scholarInfo.setReference(scholar.getReference());
				
				scholarInfos.add(scholarInfo);
				scholarInfo = null;
			}
			return scholarInfos;
		} else {
			for (Scholar scholar : scholars) {
				scholarInfo = new ScholarInfo();
				scholarInfo.setId(scholar.getId());
				scholarInfo.setEducation(scholar.getEducation());
				scholarInfo.setFollow(scholar.getFollow());
				//遍历查看学者是否被关注
				boolean flag = false;//标记位，记录是否在focus列表中找到了该学者
				for (Focus focusInfo : focus) {
					if(scholar.getId() == focusInfo.getScholarId()) {
						flag = true;
						break;
					}
				}
				if(flag) {
					scholarInfo.setFollowByCurrentUser(true);
				}else {
					scholarInfo.setFollowByCurrentUser(false);
				}				
				scholarInfo.setInstitution(scholar.getInstitution());
				scholarInfo.setName(scholar.getName());
				scholarInfo.setOutcome(scholar.getOutcome());
				scholarInfo.setPosition(scholar.getPosition());
				scholarInfo.setReference(scholar.getReference());
				
				scholarInfos.add(scholarInfo);
				flag = false; //标记为复位
				scholarInfo = null;
			}
			return scholarInfos;
			
		}
	}

	/**
	 * @Description:根据领域名进行模糊查询
	 * @exception:
	 */
	@Override
	public List<Scholar> findByFieldName(String fieldName) {
		return scholarDao.findByFieldName(fieldName);
	}

	/**
	 * @Description:根据领域名进行模糊查询, 用户未登录，有分页
	 * @exception:
	 */
	@Override
	public List<ScholarInfo> findByFieldName(String fieldName, PageUtil page) {
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		List<Scholar> scholars = scholarDao.findByFieldName(fieldName, page);
		ScholarInfo scholarInfo = null;
		List<ScholarInfo> scholarInfos = new ArrayList<ScholarInfo>();
		for (Scholar scholar : scholars) {
			scholarInfo = new ScholarInfo();
			scholarInfo.setId(scholar.getId());
			scholarInfo.setEducation(scholar.getEducation());
			scholarInfo.setFollow(scholar.getFollow());
			scholarInfo.setFollowByCurrentUser(false);
			scholarInfo.setInstitution(scholar.getInstitution());
			scholarInfo.setName(scholar.getName());
			scholarInfo.setOutcome(scholar.getOutcome());
			scholarInfo.setPosition(scholar.getPosition());
			scholarInfo.setReference(scholar.getReference());
			
			scholarInfos.add(scholarInfo);
		}
		scholarInfo = null;
		return scholarInfos;
	}
	
	/**
	 * @author yongliu
	 * @Description:根据领域名进行模糊查询, 用户未登录，有分页
	 * @exception:
	 * @update:在上一个函数[findByFieldName(String fieldName, PageUtil page)]的基础上进行修改,添加了solr全文索引
	 */
	@Override
	public List<ScholarInfo> findByFieldNameAndSolr(String fieldName, PageUtil page) { 
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}

		/*1、通过solr查找结果*/
		//query进行中英文翻译
		BaiduTranslate translate = new BaiduTranslate();
		SolrService solrService = new SolrService();
		String fieldName_zh = null;
		String fieldName_en = null;
		try {
			fieldName_zh = translate.tozh(fieldName);
			fieldName_en = translate.toen(fieldName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Integer> scholaridlist = new ArrayList<>();
//		List<Integer> scholaridlist= FieldQueryCacheManager.getCache(fieldName, page.getCurPage(), page.getRowsPerPage());
		Map<String, Object> queryresult= FieldQueryCacheManager.getCache(fieldName, page.getCurPage(), page.getRowsPerPage());

		// 缓存中没有相关数据,去solr和mysql中查询
		if (queryresult == null) {
			//通过solr查询
			Map<String, String> rawsolrresult = new HashMap<>();
//			rawsolrresult = solrService.query(fieldName);
			rawsolrresult = solrService.query(fieldName, fieldName_en);

			/*2、通过mysql查找结果*/
//			List<Scholar> mysqlscholars = scholarDao.findByFieldName(fieldName);
			
			/*3、对solr、mysql的查询结果进行汇总，得出最终的排序[由大到小]*/
//			List<Integer>sortedScholarIdList = sortScholar(rawsolrresult, mysqlscholars);
			List<Integer>sortedScholarIdList = sortScholar(rawsolrresult);
			page.setMaxRowCount(sortedScholarIdList.size());
			
			/*4、将scholar id list缓存到到缓存中*/
			FieldQueryCacheManager.putCache(fieldName, (ArrayList<Integer>)sortedScholarIdList);
	    	int startindex = (page.getCurPage() - 1) * page.getRowsPerPage();
	    	int endindex = startindex + page.getRowsPerPage();
	    	endindex = endindex > sortedScholarIdList.size() ? sortedScholarIdList.size() : endindex; 
	    	scholaridlist = sortedScholarIdList.subList(startindex, endindex);  
		} else {
			scholaridlist = (List<Integer>) queryresult.get("resultlist");
			int maxresultrows = (int) queryresult.get("maxresultrows");
			page.setMaxRowCount(maxresultrows);
		}

		List<Scholar> scholars = scholarDao.findById(scholaridlist);
		ScholarInfo scholarInfo = null;
		List<ScholarInfo> scholarInfos = new ArrayList<ScholarInfo>();
		for (Scholar scholar : scholars) {
			scholarInfo = new ScholarInfo();
			scholarInfo.setId(scholar.getId());
			scholarInfo.setEducation(scholar.getEducation());
			scholarInfo.setFollow(scholar.getFollow());
			scholarInfo.setFollowByCurrentUser(false);
			scholarInfo.setInstitution(scholar.getInstitution());
			scholarInfo.setName(scholar.getName());
			scholarInfo.setOutcome(scholar.getOutcome());
			scholarInfo.setPosition(scholar.getPosition());
			scholarInfo.setReference(scholar.getReference());
			scholarInfos.add(scholarInfo);
		}
		scholarInfo = null;
		return scholarInfos;
	}

	/** @Description:根据领域名进行模糊查询, 用户已登录，有分页
	 * @exception:
	 */
	@Override
	public List<ScholarInfo> findByFieldName(Integer userInfoId,
			String fieldName, PageUtil page) {
		
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		List<Scholar> scholars = scholarDao.findByFieldName(fieldName, page);
		List<Focus> focus = focusDao.findByUserInfoId(userInfoId);
		ScholarInfo scholarInfo = null;
		List<ScholarInfo> scholarInfos = new ArrayList<ScholarInfo>();
		if(focus == null || focus.size() == 0) {		
			for (Scholar scholar : scholars) {
				scholarInfo = new ScholarInfo();//放在外面add都是同一个对象
				scholarInfo.setId(scholar.getId());
				scholarInfo.setEducation(scholar.getEducation());
				scholarInfo.setFollow(scholar.getFollow());
				scholarInfo.setFollowByCurrentUser(false);
				scholarInfo.setInstitution(scholar.getInstitution());
				scholarInfo.setName(scholar.getName());
				scholarInfo.setOutcome(scholar.getOutcome());
				scholarInfo.setPosition(scholar.getPosition());
				scholarInfo.setReference(scholar.getReference());
				
				scholarInfos.add(scholarInfo);
				scholarInfo = null;
			}
			return scholarInfos;
		} else {
			for (Scholar scholar : scholars) {
				scholarInfo = new ScholarInfo();
				scholarInfo.setId(scholar.getId());
				scholarInfo.setEducation(scholar.getEducation());
				scholarInfo.setFollow(scholar.getFollow());
				//遍历查看学者是否被关注
				boolean flag = false;//标记位，记录是否在focus列表中找到了该学者
				for (Focus focusInfo : focus) {
					if(scholar.getId() == focusInfo.getScholarId()) {
						flag = true;
						break;
					}
				}
				if(flag) {
					scholarInfo.setFollowByCurrentUser(true);
				}else {
					scholarInfo.setFollowByCurrentUser(false);
				}				
				scholarInfo.setInstitution(scholar.getInstitution());
				scholarInfo.setName(scholar.getName());
				scholarInfo.setOutcome(scholar.getOutcome());
				scholarInfo.setPosition(scholar.getPosition());
				scholarInfo.setReference(scholar.getReference());
				
				scholarInfos.add(scholarInfo);
				flag = false; //标记为复位
				scholarInfo = null;
			}
			return scholarInfos;
			
		}
		
	}

	/** 
	 * @author yongliu
	 * @Description:根据领域名进行模糊查询, 用户已登录，有分页
	 * @exception:
	 * @update:在上一个函数[findByFieldName(Integer userInfoId,String fieldName, PageUtil page)]的基础上进行修改,添加了solr全文索引
	 */ 
	@Override
	public List<ScholarInfo> findByFieldNameAndSolr(Integer userInfoId,
			String fieldName, PageUtil page) {
		
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		List<Focus> focus = focusDao.findByUserInfoId(userInfoId);
		// 为了提高下文的查找效率，转换为hashset
		HashSet<Integer> focusidset = new HashSet<>();
		for (Focus focusInfo : focus) {
			focusidset.add(focusInfo.getScholarId());
		}
		
		/*1、通过solr查找结果*/
		//query进行中英文翻译
		BaiduTranslate translate = new BaiduTranslate();
		SolrService solrService = new SolrService();
		String fieldName_zh = null;
		String fieldName_en = null;
		try {
			fieldName_zh = translate.tozh(fieldName);
			fieldName_en = translate.toen(fieldName);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Integer> scholaridlist = new ArrayList<>();
//		List<Integer> scholaridlist= FieldQueryCacheManager.getCache(fieldName, page.getCurPage(), page.getRowsPerPage());  update
		Map<String, Object> queryresult= FieldQueryCacheManager.getCache(fieldName, page.getCurPage(), page.getRowsPerPage());
		// 缓存中没有相关数据,去solr和mysql中查询
		if (queryresult == null) {
			//通过solr查询
			Map<String, String> rawsolrresult = new HashMap<>();
//			rawsolrresult = solrService.query(fieldName);
			rawsolrresult = solrService.query(fieldName, fieldName_en);
			

			/*2、通过mysql查找结果*/
//			List<Scholar> mysqlscholars = scholarDao.findByFieldName(fieldName);
			
			/*3、对solr、mysql的查询结果进行汇总，得出最终的排序[由大到小]*/
//			List<Integer>sortedScholarIdList = sortScholar(rawsolrresult, mysqlscholars);
			List<Integer>sortedScholarIdList = sortScholar(rawsolrresult);
			page.setMaxRowCount(sortedScholarIdList.size());
			
			/*4、将scholar id list缓存到到缓存中*/
			FieldQueryCacheManager.putCache(fieldName, (ArrayList<Integer>)sortedScholarIdList);
	    	int startindex = (page.getCurPage() - 1) * page.getRowsPerPage();
	    	int endindex = startindex + page.getRowsPerPage();
	    	endindex = endindex > sortedScholarIdList.size() ? sortedScholarIdList.size() : endindex; 
	    	scholaridlist = sortedScholarIdList.subList(startindex, endindex);  
		} else {
			scholaridlist = (List<Integer>) queryresult.get("resultlist");
			int maxresultrows = (int) queryresult.get("maxresultrows");
			page.setMaxRowCount(maxresultrows);
		}
		
		List<Scholar> scholars = scholarDao.findById(scholaridlist);
		ScholarInfo scholarInfo = null;
		List<ScholarInfo> scholarInfos = new ArrayList<ScholarInfo>();
		if(focus == null || focus.size() == 0) {		
			for (Scholar scholar : scholars) {
				scholarInfo = new ScholarInfo();//放在外面add都是同一个对象
				scholarInfo.setId(scholar.getId());
				scholarInfo.setEducation(scholar.getEducation());
				scholarInfo.setFollow(scholar.getFollow());
				scholarInfo.setFollowByCurrentUser(false);
				scholarInfo.setInstitution(scholar.getInstitution());
				scholarInfo.setName(scholar.getName());
				scholarInfo.setOutcome(scholar.getOutcome());
				scholarInfo.setPosition(scholar.getPosition());
				scholarInfo.setReference(scholar.getReference());
				
				scholarInfos.add(scholarInfo);
				scholarInfo = null;
			}
			return scholarInfos;
		} else {
			for (Scholar scholar : scholars) {
				scholarInfo = new ScholarInfo();
				scholarInfo.setId(scholar.getId());
				scholarInfo.setEducation(scholar.getEducation());
				scholarInfo.setFollow(scholar.getFollow());
				//遍历查看学者是否被关注
				boolean flag = false;//标记位，记录是否在focus列表中找到了该学者
			/*	for (Focus focusInfo : focus) {
					if(scholar.getId() == focusInfo.getScholarId()) {
						flag = true;
						break;
					}
				}*/
				if (focusidset.contains(scholar.getId())) {
					flag = true;
				}
				
				if(flag) {
					scholarInfo.setFollowByCurrentUser(true);
				}else {
					scholarInfo.setFollowByCurrentUser(false);
				}				
				scholarInfo.setInstitution(scholar.getInstitution());
				scholarInfo.setName(scholar.getName());
				scholarInfo.setOutcome(scholar.getOutcome());
				scholarInfo.setPosition(scholar.getPosition());
				scholarInfo.setReference(scholar.getReference());
				
				scholarInfos.add(scholarInfo);
				flag = false; //标记为复位
				scholarInfo = null;
			}
			return scholarInfos;
		}
	}
	/**
	 * @Description:根据组织机构名进行模糊查询
	 * @exception:
	 */
	@Override
	public List<Scholar> findByInstitutionName(String institutionName) {
		return scholarDao.findByInstitutionName(institutionName);
	}

	/**
	 * @Description:根据组织机构名进行模糊查询,用户未登录，有分页
	 * @exception:
	 */
	@Override
	public List<ScholarInfo> findByInstitutionName(String institutionName,
			PageUtil page) {
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条

			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		List<Scholar> scholars = scholarDao.findByInstitutionName(institutionName, page);
		ScholarInfo scholarInfo = null;
		List<ScholarInfo> scholarInfos = new ArrayList<ScholarInfo>();
		for (Scholar scholar : scholars) {
			scholarInfo = new ScholarInfo();
			scholarInfo.setId(scholar.getId());
			scholarInfo.setEducation(scholar.getEducation());
			scholarInfo.setFollow(scholar.getFollow());
			scholarInfo.setFollowByCurrentUser(false);
			scholarInfo.setInstitution(scholar.getInstitution());
			scholarInfo.setName(scholar.getName());
			scholarInfo.setOutcome(scholar.getOutcome());
			scholarInfo.setPosition(scholar.getPosition());
			scholarInfo.setReference(scholar.getReference());
			
			scholarInfos.add(scholarInfo);
		}
		scholarInfo = null;
		return scholarInfos;
	}

	/** @Description:根据组织机构名进行模糊查询,用户未登录，有分页
	 * @exception:
	 */
	@Override
	public List<ScholarInfo> findByInstitutionName(Integer userInfoId,
			String institutionName, PageUtil page) {
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		// 根据指定的页码和条数查询结果
		List<Scholar> scholars = scholarDao.findByInstitutionName(institutionName, page);
		List<Focus> focus = focusDao.findByUserInfoId(userInfoId);
		ScholarInfo scholarInfo = null;
		List<ScholarInfo> scholarInfos = new ArrayList<ScholarInfo>();
		if(focus == null || focus.size() == 0) {		
			for (Scholar scholar : scholars) {
				scholarInfo = new ScholarInfo();//放在外面add都是同一个对象
				scholarInfo.setId(scholar.getId());
				scholarInfo.setEducation(scholar.getEducation());
				scholarInfo.setFollow(scholar.getFollow());
				scholarInfo.setFollowByCurrentUser(false);
				scholarInfo.setInstitution(scholar.getInstitution());
				scholarInfo.setName(scholar.getName());
				scholarInfo.setOutcome(scholar.getOutcome());
				scholarInfo.setPosition(scholar.getPosition());
				scholarInfo.setReference(scholar.getReference());
				
				scholarInfos.add(scholarInfo);
				scholarInfo = null;
			}
			return scholarInfos;
		} else {
			for (Scholar scholar : scholars) {
				scholarInfo = new ScholarInfo();
				scholarInfo.setId(scholar.getId());
				scholarInfo.setEducation(scholar.getEducation());
				scholarInfo.setFollow(scholar.getFollow());
				//遍历查看学者是否被关注
				boolean flag = false;//标记位，记录是否在focus列表中找到了该学者
				for (Focus focusInfo : focus) {
					if(scholar.getId() == focusInfo.getScholarId()) {
						flag = true;
						break;
					}
				}
				if(flag) {
					scholarInfo.setFollowByCurrentUser(true);
				}else {
					scholarInfo.setFollowByCurrentUser(false);
				}				
				scholarInfo.setInstitution(scholar.getInstitution());
				scholarInfo.setName(scholar.getName());
				scholarInfo.setOutcome(scholar.getOutcome());
				scholarInfo.setPosition(scholar.getPosition());
				scholarInfo.setReference(scholar.getReference());
				
				scholarInfos.add(scholarInfo);
				flag = false; //标记为复位
				scholarInfo = null;
			}
			return scholarInfos;
			
		}
	}

	/**
	 * @Description:根据id进行精确查询
	 * @exception:
	 */
	@Override
	public Scholar findById(int id) {
		return scholarDao.findById(id);
	}

	/**
	 * @Description:根据领域名进行统计数量
	 * @exception:
	 */
	@Override
	public Long countByFieldName(String fieldName) {

		return scholarDao.countByFieldName(fieldName);
	}

	/** @Description:根据名字进行统计数量
	 * @exception:
	 */
	@Override
	public Long countByName(String name) {
		return scholarDao.countByName(name);
	}

	/** @Description:根据组织机构名进行统计数量
	 * @exception:
	 */
	@Override
	public Long countByInstitutionName(String institutionName) {
		return scholarDao.countByInstitutionName(institutionName);
	}

	/** 
	 * @author yongliu
	 * @Description:列出所有的学者列表
	 * @exception:
	 */
	@Override
	public List<Scholar> findAll() {
		// TODO Auto-generated method stub
		return scholarDao.findAll();
	}
	
	/** 
	 * @author yongliu
	 * @Description:根据属性，对学者进行排序的函数
	 * @exception:
	 * @return 学者id列表
	 */
	public List<Integer> sortScholar(Map<String, String> solrscholars, List<Scholar> mysqlscholars) {
		// TODO Auto-generated method stub
		List<Integer> sortedScholarIdList = new ArrayList<>();
		List<ScholarSort> scholarSortList = new ArrayList<>();
		for (Scholar mysqlscholar : mysqlscholars) {
			ScholarSort scholarSort = new ScholarSort();
			int scholarid = mysqlscholar.getId();
			scholarSort.setId(scholarid);
			if (solrscholars.containsKey(String.valueOf(scholarid))) {
				scholarSort.setScore(Float.valueOf(solrscholars.get(String.valueOf(scholarid))));
				solrscholars.remove(String.valueOf(scholarid));
			}
			scholarSort.setFollow(mysqlscholar.getFollow());
			scholarSort.setOutcome(mysqlscholar.getOutcome());
			scholarSort.setReference(mysqlscholar.getReference());
			scholarSort.setHindex(mysqlscholar.getHindex());
			scholarSort.setGindex(mysqlscholar.getGindex());
			scholarSort.setJournal_percent(mysqlscholar.getJournal_percent());
			scholarSort.setConference_percent(mysqlscholar.getConference_percent());
			scholarSort.setBooktitle_percent(mysqlscholar.getBooktitle_percent());
			scholarSort.setOther_percent(mysqlscholar.getOther_percent());
			scholarSort.calculateResultscore();
			scholarSortList.add(scholarSort);
		}
		for (Map.Entry<String, String> entry : solrscholars.entrySet()) {
			ScholarSort scholarSort = new ScholarSort();
			scholarSort.setId(Integer.valueOf(entry.getKey()));
			scholarSort.setScore(Float.valueOf(entry.getValue()));
			scholarSort.calculateResultscore();
			scholarSortList.add(scholarSort);
		}
		//按resultscore排序
		Collections.sort(scholarSortList);
		//按照resultscore从大到小的顺序,提取scholar id
		for (ScholarSort scholarSort : scholarSortList) {
			sortedScholarIdList.add(scholarSort.getId());
		}
		return sortedScholarIdList;
	}
	
	/** 
	 * @author yongliu
	 * @Description:根据属性，对学者进行排序的函数
	 * @exception:
	 * @return 学者id列表
	 */
	public List<Integer> sortScholar(Map<String, String> solrscholars) {
		// TODO Auto-generated method stub
		List<Integer> solrScholarIdList = new ArrayList<>();
		for (Map.Entry<String, String> entry : solrscholars.entrySet()) {
			solrScholarIdList.add(Integer.valueOf(entry.getKey()));
		}
		List<Scholar> solrScholars = scholarDao.findById(solrScholarIdList);
		
		List<ScholarSort> scholarSortList = new ArrayList<>();
		for (Scholar solrScholar : solrScholars) {
			ScholarSort scholarSort = new ScholarSort();
			int scholarid = solrScholar.getId();
			float solrscore = Float.valueOf(solrscholars.get(String.valueOf(scholarid)));
			scholarSort.setId(scholarid);
			scholarSort.setScore(solrscore);
			scholarSort.setFollow(solrScholar.getFollow());
			scholarSort.setOutcome(solrScholar.getOutcome());
			scholarSort.setReference(solrScholar.getReference());
			scholarSort.setHindex(solrScholar.getHindex());
			scholarSort.setGindex(solrScholar.getGindex());
			scholarSort.setJournal_percent(solrScholar.getJournal_percent());
			scholarSort.setConference_percent(solrScholar.getConference_percent());
			scholarSort.setBooktitle_percent(solrScholar.getBooktitle_percent());
			scholarSort.setOther_percent(solrScholar.getOther_percent());
			scholarSort.calculateResultscore();
			scholarSortList.add(scholarSort);
		}
		
		List<Integer> sortedScholarIdList = new ArrayList<>();
		//按resultscore排序
		Collections.sort(scholarSortList);
		//按照resultscore从大到小的顺序,提取scholar id
		for (ScholarSort scholarSort : scholarSortList) {
			sortedScholarIdList.add(scholarSort.getId());
		}
		return sortedScholarIdList;
	}

	@Override
	public Scholar findinfo(String name,String institution) {
		// TODO 自动生成的方法存根
		
		return scholarDao.findinfo(name,institution);
	}

}
