/**
 * 
 */
package cn.scholarprofile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Heat;
import cn.scholarprofile.dao.HeatDao;


/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年04月21日 下午3:51:27
 * @Description : heatDao的实现类
 * @version 1.0
 */
@Component("heatDao")
@Transactional
public class HeatDaoImpl extends BaseDaoImpl<Heat> implements HeatDao {

	@Override
	public List<Heat> findHeatsByUserInfoId(Integer userInfoId) {
		
		if(null == userInfoId || userInfoId <= 0) {
			return new ArrayList<Heat>();
		}
		return this.find("From Heat where userInfoId = " + userInfoId);
		
	}

	
}
