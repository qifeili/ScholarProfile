package cn.scholarprofile.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.scholarprofile.bean.FocusProject;
import cn.scholarprofile.dao.FocusProjectDao;
import cn.scholarprofile.util.PageUtil;

@Component("focusProjectDao")
public class FocusProjectDaoImpl extends BaseDaoImpl<FocusProject> implements FocusProjectDao {

	/**
	 * @Description:根据用户id和学者id查找关注记录
	 * @exception:
	 */
	@Override
	public FocusProject getFocusProjectByUserInfoIdAndProjectId(Integer userInfoId, Integer projectId) {

		if((null == userInfoId || userInfoId <= 0) && (null == projectId || projectId <= 0)) {
			return null;
		}
		return this
				.get("From FocusProject where userInfoId = '" + userInfoId + "' and projectId = '" + projectId + "'");
	}

	/**
	 * @Description:根据用户id查找所有已关注的信息
	 * @exception:
	 */
	@Override
	public List<FocusProject> findByUserInfoId(Integer userInfoId) {
		if(null == userInfoId || userInfoId <= 0) {
			return null;
		}
		return this.find("From FocusProject where userInfoId = '" + userInfoId + "' and follow = true");
	}

	/**
	 * @Description://根据用户id从focusproject表和userinfo表获取数据
	 * @exception:
	 */
	@Override
	public List<Object[]> findFocusProjectInfo(Integer userInfoId, PageUtil page) {
		if(null == userInfoId || userInfoId <= 0) {
			return new ArrayList<Object[]>();
		}
		List<Object[]> objList = this.findBySql(
				"select p.id, p.title, f.focusTime, f.follow from t_project as p join t_focusproject as f on p.id = f.projectId where f.follow = true and f.userInfoId = "
						+ userInfoId,
				page.getCurPage(), page.getRowsPerPage());
		return objList;
	}

	/**
	 * @Description:根据用户id统计数据数量
	 * @exception:
	 */
	@Override
	public long countByUserInfoId(Integer userInfoId) {
		if(null == userInfoId || userInfoId <= 0) {
			return 0;
		}
		return this.count("select count(f) from  FocusProject f where f.follow = true and f.userInfoId = " + userInfoId);
	}

}
