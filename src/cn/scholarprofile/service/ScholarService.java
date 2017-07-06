/**
 * 
 */
package cn.scholarprofile.service;

import java.util.List;

import cn.scholarprofile.bean.Scholar;
import cn.scholarprofile.dto.ScholarInfo;
import cn.scholarprofile.util.PageUtil;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月24日 上午10:19:34
 * @Description :
 * @version 1.0
 */

public interface ScholarService {

	/**
	 * @Description:根据姓名进行模糊查询
	 * @exception:
	 */
	public List<Scholar> findByName(String name);

	/**
	 * @Description:根据姓名进行模糊查询，用户未登录，有分页
	 * @exception:
	 */
	public List<ScholarInfo> findByName(String name, PageUtil page);
	
	/**
	 * @Description:根据姓名进行模糊查询，用户已登录， 有分页
	 * @exception:
	 */
	public List<ScholarInfo> findByName(Integer userInfoId, String name, PageUtil page);

	/**
	 * @Description:根据领域名进行模糊查询
	 * @exception:
	 */
	public List<Scholar> findByFieldName(String fieldName);

	/**
	 * @Description:根据领域名进行模糊查询,用户未登录，有分页
	 * @exception:
	 */
	public List<ScholarInfo> findByFieldName(String fieldName, PageUtil page);
	
	/**
	 * @Description:根据领域名进行模糊查询,用户已登录，有分页
	 * @exception:
	 */
	public List<ScholarInfo> findByFieldName(Integer userInfoId, String fieldName, PageUtil page);
	
	/**
	 * @Description:根据领域名进行模糊查询,用户未登录，有分页,添加了solr索引、缓存机制
	 * @exception:
	 */
	public List<ScholarInfo> findByFieldNameAndSolr(String fieldName, PageUtil page);
	
	/**
	 * @Description:根据领域名进行模糊查询,用户已登录，有分页,添加了solr索引、缓存机制
	 * @exception:
	 */
	public List<ScholarInfo> findByFieldNameAndSolr(Integer userInfoId, String fieldName, PageUtil page);

	/**
	 * @Description:根据组织机构姓名进行模糊查询
	 * @exception:
	 */
	public List<Scholar> findByInstitutionName(String institutionName);

	/**
	 * @Description:根据组织机构姓名进行模糊查询，用户未登录，有分页
	 * @exception:
	 */
	public List<ScholarInfo> findByInstitutionName(String institutionName,
			PageUtil page);
	
	/**
	 * @Description:根据组织机构姓名进行模糊查询，用户已登录，有分页
	 * @exception:
	 */
	public List<ScholarInfo> findByInstitutionName(Integer userInfoId, String institutionName,
			PageUtil page);

	/**
	 * @Description:根据id进行精确查询
	 * @exception:
	 */
	public Scholar findById(int id);

	/**
	 * @Description:根据领域名进行统计数量
	 * @exception:
	 */
	public Long countByFieldName(String fieldName);

	/**
	 * @Description:根据名字进行统计数量
	 * @exception:
	 */
	public Long countByName(String name);

	/**
	 * @Description:根据组织机构名进行统计数量
	 * @exception:
	 */
	public Long countByInstitutionName(String institutionName);
	
	/**
	 * @Description:列出所有的学者列表
	 * @exception:
	 */
	public List<Scholar> findAll();


	public Scholar findinfo(String name, String institution);

}
