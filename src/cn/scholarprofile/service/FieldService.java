package cn.scholarprofile.service;

import java.util.List;

import cn.scholarprofile.bean.Field;;

public interface FieldService {

	/**
	 * 
	 * @Description:列出所有的Field对象
	 * @param null
	 * @throws Exception
	 * void
	 * @exception:
	 */
	
	public abstract List<Field> listAll() throws Exception;
	
}
