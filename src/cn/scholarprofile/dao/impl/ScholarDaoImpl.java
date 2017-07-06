
package cn.scholarprofile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Scholar;
import cn.scholarprofile.dao.ScholarDao;
import cn.scholarprofile.util.PageUtil;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月20日 下午3:51:27
 * @Description : FieldDao的实现类
 * @version 1.0
 */
@Component("scholarDao")
@Transactional
public class ScholarDaoImpl extends BaseDaoImpl<Scholar> implements ScholarDao {

	/**
	 * @Description:判断scholar对象是否存在，暂时根据name，education，institution，position四个字段区别对象
	 * @exception:
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Scholar checkIsExist(String name, String education,
			String institution, String position) {
		List<Scholar> list = (List<Scholar>) this
				.getCurrentSession()
				.createQuery(
						"from Scholar s where s.name = :name and s.education = :education and s.institution = :institution and s.position = :position")
				.setString("name", name).setString("education", education)
				.setString("institution", institution)
				.setString("position", position).list();

		if (list.size() > 0) // 数据存在，则不插入
			return list.get(0);
		else
			return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Scholar checkIsExist(String name, String institution) {
		List<Scholar> list = (List<Scholar>) this.getCurrentSession()
				.createQuery("from Scholar s where s.name = :name")
				.setString("name", name)
				// .setString("institution", institution)
				.list();

		if (list.size() > 0) // 数据存在，则不插入，并将其拿出来供后期使用
			return list.get(0);
		else
			return null;
	}

	/**
	 * @Description:清一下session缓存
	 * @exception:
	 */
	@Override
	public void cleanMemory() {

		this.getCurrentSession().clear();
	}

	/**
	 * @Description:根据姓名进行模糊查找
	 * @exception:
	 */
	@Override
	public List<Scholar> findByName(String name) {

		if(null == name || "".equals(name)) {
			return new ArrayList<Scholar>();
		}
		return this.find("From Scholar s where s.name like '%" + name + "%'");

		// 第二种实现方式
		/*
		 * Map<String, Object> params = new HashMap<String, Object>();
		 * params.put("name", "%" + name + "%"); List<Scholar> scholars =
		 * this.find("From Scholar s where s.name like :name ",params); return
		 * scholars;
		 */
	}

	/**
	 * @Description:根据姓名进行模糊查找,有分页
	 * @exception:
	 */
	@Override
	public List<Scholar> findByName(String name, PageUtil page) {
		
		if(null == name || "".equals(name)) {
			return new ArrayList<Scholar>();
		}
		return this.find("From Scholar s where s.name like '%" + name + "%'", page.getCurPage(),
				page.getRowsPerPage());
	}

	/**
	 * @Description:根据id进行精准查找
	 * @exception:
	 */
	@Override
	public Scholar findById(int id) {
		return this.get(Scholar.class, id);
	}

	/**
	 * @Description:根据所在领域名字进行模糊查找
	 * @exception:
	 */
	@Override
	public List<Scholar> findByFieldName(String fieldName) {
		if(null == fieldName || "".equals(fieldName)) {
			return new ArrayList<Scholar>();
		}
		List<Scholar> list = this
				.find("select s from Scholar s join s.fields as fields where fields.name = '"
						+ fieldName + "'");
		return list;
	}

	/**
	 * @Description:根据所在领域名字进行模糊查找，有分页
	 * @exception:
	 */
	@Override
	public List<Scholar> findByFieldName(String fieldName, PageUtil page) {

		if(null == fieldName || "".equals(fieldName)) {
			return new ArrayList<Scholar>();
		}
		List<Scholar> list = this
				.find("select s from Scholar s join s.fields as fields where fields.name = '"
						+ fieldName + "'", page.getCurPage(),
						page.getRowsPerPage());

		return list;
	}

	/**
	 * @Description:根据所在领域名字进行模糊查找出前几个学者
	 * @exception:
	 */
	@Override
	public List<Scholar> findTopScholarsByFieldName(String fieldName) {
		if(null == fieldName || "".equals(fieldName)) {
			return new ArrayList<Scholar>();
		}
		return this
				.find("select s from Scholar s join s.fields as fields where fields.name = '"
						+ fieldName + "'", 1, 3);
	}

	/**
	 * @Description:根据组织机构名字进行模糊查找
	 * @exception:
	 */
	@Override
	public List<Scholar> findByInstitutionName(String institutionName) {
		if(null == institutionName || "".equals(institutionName)) {
			return new ArrayList<Scholar>();
		}
		return this.find("From Scholar s where s.institution like '%"
				+ institutionName + "%'");
	}

	/**
	 * @Description:根据组织机构名字进行模糊查找，有分页
	 * @exception:
	 */
	@Override
	public List<Scholar> findByInstitutionName(String institutionName,
			PageUtil page) {
		if(null == institutionName || "".equals(institutionName)) {
			return new ArrayList<Scholar>();
		}
		return this.find("From Scholar s where s.institution like '%"
				+ institutionName + "%'", page.getCurPage(),
				page.getRowsPerPage());
	}

	/**
	 * @Description:根据领域名进行统计个数
	 * @exception:
	 */
	@Override
	public Long countByFieldName(String fieldName) {
		if(null == fieldName || "".equals(fieldName)) {
			return Long.valueOf(0);
		}
		Long scholarNum = this
				.count("select count(s) from  Scholar s join s.fields as fields where fields.name = '"
						+ fieldName + "'");
		return scholarNum;
	}

	/** @Description:根据名字进行统计个数
	 * @exception:
	 */
	@Override
	public Long countByName(String name) {
		if(null == name || "".equals(name)) {
			return Long.valueOf(0);
		}
		Long scholarNum = this.count("select count(s) from Scholar s where s.name like '%" + name + "%'");
		return scholarNum;
	}

	/** @Description:根据组织机构名进行统计个数
	 * @exception:
	 */
	@Override
	public Long countByInstitutionName(String institutionName) {
		if(null == institutionName || "".equals(institutionName)) {
			return Long.valueOf(0);
		}
		Long scholarNum = this.count("select count(s) from Scholar s where s.institution like '%"
				+ institutionName + "%'");
		return scholarNum;
	}
	
	/** @Description:列出所有的学者列表
	 * @exception:
	 */
	@Override
	public List<Scholar> findAll() {
		// TODO Auto-generated method stub
		return this.find("From Scholar");
	}

	/**
	 * @Description:根据id list进行精准查找
	 * @exception:
	 */
	@Override
	public List<Scholar> findById(List<Integer> idlist) {
		// TODO Auto-generated method stub
		List<Scholar> scholarlist = new ArrayList<>();
		for (Integer id : idlist) {
			Scholar scholar = this.findById(id);
			scholarlist.add(scholar);
		}
		return scholarlist;
	}
	@Override
	public Scholar findinfo(String name, String institution) {
		// TODO 自动生成的方法存根
		Scholar scholar=this.find("from Scholar s where name='"+name+"' and institution='"+institution+"'").get(0);
		return scholar;
	}
}
