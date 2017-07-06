/**
 * 
 */
package cn.scholarprofile.dao;

import java.util.List;

import cn.scholarprofile.bean.Scholar;
import cn.scholarprofile.util.PageUtil;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月20日 下午3:45:33
 * @Description : Field对象的Dao操作类
 * @version 1.0
 */
public interface ScholarDao extends BaseDao<Scholar> {

	// 判断是否存在
	public abstract Scholar checkIsExist(String name, String education,
			String institution, String position);

	// 根据简单的两个字段进行判断对象是否存在
	public abstract Scholar checkIsExist(String name, String institution);

	// 清一下缓存
	public abstract void cleanMemory();

	// 根据名字进行模糊查找
	public abstract List<Scholar> findByName(String name);

	// 根据名字进行模糊查找,有分页
	public abstract List<Scholar> findByName(String name, PageUtil page);

	// 根据id进行精准查找
	public abstract Scholar findById(int id);
	
	// 根据id进行精准查找
	public abstract List<Scholar> findById(List<Integer> idlist);

	// 根据所在领域名字进行模糊查找
	public abstract List<Scholar> findByFieldName(String fieldName);

	// 根据所在领域名字进行模糊查找,有分页
	public abstract List<Scholar> findByFieldName(String fieldName,
			PageUtil page);
	
	//根据所在领域名字进行模糊查找出前几个学者
	public abstract List<Scholar> findTopScholarsByFieldName(String fieldName);

	// 根据组织机构名字进行模糊查找
	public abstract List<Scholar> findByInstitutionName(String institutionName);

	// 根据组织机构名字进行模糊查找,有分页
	public abstract List<Scholar> findByInstitutionName(String institutionName,
			PageUtil page);

	// 根据领域名进行统计数量
	public abstract Long countByFieldName(String fieldName);

	// 根据名字进行统计数量
	public abstract Long countByName(String name);

	// 根据组织机构名进行统计数量
	public abstract Long countByInstitutionName(String institutionName);
	
	// 列出所有的学者列表
	public abstract List<Scholar> findAll();

	public abstract Scholar findinfo(String name, String institution);
	
	
}
