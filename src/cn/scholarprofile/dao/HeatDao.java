/**
 * 
 */
package cn.scholarprofile.dao;

import java.util.List;

import cn.scholarprofile.bean.Heat;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月20日 下午3:45:33
 * @Description : Field对象的Dao操作类
 * @version 1.0
 */
public interface HeatDao extends BaseDao<Heat> {

	// 列出所有的学者列表
	public abstract List<Heat> findHeatsByUserInfoId(Integer userInfoId);
	
}
