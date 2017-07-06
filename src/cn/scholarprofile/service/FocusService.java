package cn.scholarprofile.service;

import java.util.List;

import cn.scholarprofile.dto.ReviewScholarInfo;
import cn.scholarprofile.util.PageUtil;

public interface FocusService {

	//改变关注学者信息的状态
	public abstract Boolean changeFocusStatus(int userInfoId, int scholarId) throws Exception;
	
	//根据用户id查出数据装载页面
	public abstract List<ReviewScholarInfo> findFocusInfo(int userInfoId, PageUtil page) throws Exception;
	
	//根据用户id统计数量
	public abstract long countByUserInfoId(int userInfoId) throws Exception;
}
