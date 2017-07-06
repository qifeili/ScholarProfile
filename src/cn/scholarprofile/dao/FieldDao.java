/**
 * 
 */
package cn.scholarprofile.dao;



import java.util.List;

import cn.scholarprofile.bean.Field;

/** @author  pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月20日 下午3:45:33 
 * @Description : Field对象的Dao操作类
 * @version 1.0 
 */
public interface FieldDao extends BaseDao<Field> {

	//判断是否存在
	public abstract Field checkIsExist(String name);
	
	//清一下缓存
	public abstract void cleanMemory();
	
	//根据领域名找到领域对象
	public abstract Field getFieldByName(String fieldName);
	
	//列出数据库中的所有领域
	public List<Field> listAll();
	
	//列出靠前的几个领域的名字
	public List<String> listHotFieldNames();
	
}
