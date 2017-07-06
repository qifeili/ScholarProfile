package cn.scholarprofile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.scholarprofile.bean.Focus;
import cn.scholarprofile.dao.FocusDao;
import cn.scholarprofile.util.PageUtil;

@Component("focusDao")
public class FocusDaoImpl extends BaseDaoImpl<Focus> implements FocusDao {

	/**
	 * @Description:根据用户id和学者id查找关注记录
	 * @exception:
	 */
	@Override
	public Focus getFocusByUserInfoIdAndScholarId(Integer userInfoId, Integer scholarId) {

		if((null == userInfoId || userInfoId <= 0) && (null == scholarId || scholarId <= 0)) {
			return null;
		}
		return this.get("From Focus where userInfoId = '" + userInfoId + "' and scholarId = '" + scholarId + "'");
	}

	/**
	 * @Description:根据用户id查找所有已关注的信息
	 * @exception:
	 */
	@Override
	public List<Focus> findByUserInfoId(Integer userInfoId) {
		if(null == userInfoId || userInfoId <= 0) {
			return new ArrayList<Focus>();
		}
		return this.find("From Focus where userInfoId = '" + userInfoId + "' and follow = true");
	}

	/**
	 * @Description:根据用户id查出数据装载页面
	 * @exception:
	 */
	@Override
	public List<Object[]> findFocusInfo(Integer userInfoId, PageUtil page) {
		
		if(null == userInfoId || userInfoId <= 0) {
			return new ArrayList<Object[]>();
		}
		return this.findBySql(
				"select focus.scholarId, focus.focusTime, focus.follow, scholar.name, scholar.institution from t_focus as focus join t_scholar as scholar on scholar.id = focus.scholarId where focus.follow = true and focus.userInfoId = "
						+ userInfoId,
				page.getCurPage(), page.getRowsPerPage());
	}

	/**
	 * @Description:根据用户id统计数量
	 * @exception:
	 */
	@Override
	public long countByUserInfoId(Integer userInfoId) {
		if(null == userInfoId || userInfoId <= 0) {
			return 0;
		}
		return this.count("select count(f) from  Focus f where f.follow = true and f.userInfoId = " + userInfoId);
	}

	
}
