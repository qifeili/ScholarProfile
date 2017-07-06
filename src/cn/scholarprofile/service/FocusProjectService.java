package cn.scholarprofile.service;

import java.util.List;

import cn.scholarprofile.dto.ReviewProjectInfo;
import cn.scholarprofile.util.PageUtil;

public interface FocusProjectService {

	//改变关注项目信息的状态
	public abstract Boolean changeFocusProjectStatus(int userInfoId, int projectId) throws Exception;
	
	//根据用户id获取数据装载ReviewProjectInfo
	public abstract List<ReviewProjectInfo> findFocusProjectInfo(int userInfoId, PageUtil page) throws Exception;
	
	//根据用户id统计数据数量
	public abstract long countByUserInfoId(int userInfoId) throws Exception;
}
