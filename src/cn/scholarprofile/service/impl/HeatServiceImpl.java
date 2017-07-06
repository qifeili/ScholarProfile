/**
 * 
 */
package cn.scholarprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Field;
import cn.scholarprofile.bean.Heat;
import cn.scholarprofile.dao.FieldDao;
import cn.scholarprofile.dao.HeatDao;
import cn.scholarprofile.service.HeatService;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月24日 上午10:34:56
 * @Description :
 * @version 1.0
 */
@Service("heatService")
@Transactional
public class HeatServiceImpl implements HeatService {

	private HeatDao heatDao;
	private FieldDao fieldDao;

	public HeatDao getHeatDao() {
		return heatDao;
	}

	@Resource
	public void setHeatDao(HeatDao heatDao) {
		this.heatDao = heatDao;
	}

	public FieldDao getFieldDao() {
		return fieldDao;
	}

	@Resource
	public void setFieldDao(FieldDao fieldDao) {
		this.fieldDao = fieldDao;
	}

	//根据用户id查找出该用户对应的热门领域
	@Override
	public List<String> findHotFieldNamesByUserInfoId(Integer userInfoId) {
		if(null == userInfoId || userInfoId <= 0) {
			return null;
		}
		//1.查找到该用户对应的热门领域id
		List<Heat> heats = heatDao.findHeatsByUserInfoId(userInfoId);
		if(null == heats || heats.size() == 0) {
			return null;
		}
		//2.根据查找到的热门领域id查找到所有热门领域
		Integer fieldId = null;
		Field field = null;
		List<String> fieldNames = new ArrayList<String>();
		for (Heat heat : heats) {
			fieldId = heat.getFieldId();
			if(null != fieldId && fieldId > 0) {
				field = fieldDao.get(Field.class, fieldId);
			}
			//3.根据查找到的热门领域提取出领域的名字字段
			if(null != field) {
				fieldNames.add(field.getName());
			}
			
		}
		//4.将数据封装起来，返回
		return fieldNames;
	}

	//查找出全局热门领域
	@Override
	public List<String> findGlobalHotFieldNamesByUserInfoId() {
		return null;
	}
	
	

}
