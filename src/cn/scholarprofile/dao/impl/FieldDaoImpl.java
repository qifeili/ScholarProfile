/**
 * 
 */
package cn.scholarprofile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Field;
import cn.scholarprofile.dao.FieldDao;

/** @author  pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月20日 下午3:51:27 
 * @Description : FieldDao的实现类
 * @version 1.0 
 */
@Component("fieldDao")
@Transactional
public class FieldDaoImpl extends BaseDaoImpl<Field> implements FieldDao {

	/** @Description:判断数据是否存在
	 * @exception:
	 */
	@SuppressWarnings("unchecked")
	@Override
	
	public Field checkIsExist(String name) {
		
		if("".equals(name) || name == null) {
			return null;
		}
		List<Field> list = (List<Field>) this.getCurrentSession()
				.createQuery("from Field f where f.name = :name")
				.setString("name", name).list();

		if (list.size() > 0) // 数据存在，则不插入
			return list.get(0);
		else 
			return null;
	}

	/** @Description:清一下session缓存
	 * @exception:
	 */
	@Override
	public void cleanMemory() {

		this.getCurrentSession().clear();
	}

	/** @Description://根据领域名找到领域对象
	 * @exception:
	 */
	@Override
	public Field getFieldByName(String fieldName) {
		
		if("".equals(fieldName) || null == fieldName) {
			return null;
		}
		return this.get("From Field f where f.name = '" + fieldName + "'");
	}
	
	/** @Description:列出数据库中的所有领域
	 * @exception:
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Field> listAll() {
		List<Field> list = (List<Field>) this.getCurrentSession()
				.createQuery("from Field").list();
		return list;
	}

	/**
	 * @Description:列出靠前的几个领域的名字
	 * @exception:
	 */
	@Override
	public List<String> listHotFieldNames() {
		List<Object[]> objects = this.findBySql("select name, id from t_field limit 9");
		List<String> fieldNames = new ArrayList<>();
		for (Object[] object : objects) {
			fieldNames.add((String)object[0]);
		}
		return fieldNames;
	}
	
	
}
