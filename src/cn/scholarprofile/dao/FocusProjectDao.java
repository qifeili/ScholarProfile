package cn.scholarprofile.dao;

import java.util.List;

import cn.scholarprofile.bean.FocusProject;
import cn.scholarprofile.util.PageUtil;

public interface FocusProjectDao extends BaseDao<FocusProject>{
	
	//根据用户id和项目id查找关注记录
	public abstract FocusProject getFocusProjectByUserInfoIdAndProjectId(Integer userInfoId, Integer projectId);
	
	//根据用户id查找所有已关注的信息
	public abstract List<FocusProject> findByUserInfoId(Integer userInfoId);
	
	//根据用户id从focusproject表和userinfo表获取数据
	public abstract List<Object[]> findFocusProjectInfo(Integer userInfoId, PageUtil page);
	
	//根据用户id统计数据数量
	public abstract long countByUserInfoId(Integer userInfoId);
	
}