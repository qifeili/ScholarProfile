/**
 * 
 */
package cn.scholarprofile.service;

import java.util.List;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月24日 上午10:19:34
 * @Description :
 * @version 1.0
 */

public interface HeatService {

	//根据用户id查找其对应的热门领域
	public List<String> findHotFieldNamesByUserInfoId(Integer userInfoId);
	
	//查找出全局热门领域
	public List<String> findGlobalHotFieldNamesByUserInfoId();

}
