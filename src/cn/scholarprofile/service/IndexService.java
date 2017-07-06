package cn.scholarprofile.service;

import cn.scholarprofile.dto.IndexInfo;

public interface IndexService {

	//获取首页的数据信息
	public abstract IndexInfo getIndexInfo() throws Exception;
}
