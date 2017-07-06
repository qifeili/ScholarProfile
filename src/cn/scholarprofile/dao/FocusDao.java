package cn.scholarprofile.dao;

import java.util.List;

import cn.scholarprofile.bean.Focus;
import cn.scholarprofile.util.PageUtil;

public interface FocusDao extends BaseDao<Focus>{
	
	//根据用户id和学者id查找关注记录
	public abstract Focus getFocusByUserInfoIdAndScholarId(Integer userInfoId, Integer scholarId);
	
	//根据用户id查找所有已关注的信息
	public abstract List<Focus> findByUserInfoId(Integer userInfoId);
	
	//根据用户id查出数据装载页面
	public abstract List<Object[]> findFocusInfo(Integer userInfoId, PageUtil page);
	
	//根据用户id统计数量
	public abstract long countByUserInfoId(Integer userInfoId);
	
}