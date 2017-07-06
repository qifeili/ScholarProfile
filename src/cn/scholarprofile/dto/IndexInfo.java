/**
 * 
 */
package cn.scholarprofile.dto;

import java.util.ArrayList;
import java.util.List;

import cn.scholarprofile.bean.Project;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年3月17日 下午2:34:15
 * @Description : 首页的数据装载类
 * @version 1.0
 */
public class IndexInfo {


	private List<HotFieldCell> hotFields = new ArrayList<>();
	private List<Project> latestProjects = new ArrayList<>();
	
	public List<HotFieldCell> getHotFields() {
		return hotFields;
	}

	public void setHotFields(List<HotFieldCell> hotFields) {
		this.hotFields = hotFields;
	}

	public List<Project> getLatestProjects() {
		return latestProjects;
	}

	public void setLatestProjects(List<Project> latestProjects) {
		this.latestProjects = latestProjects;
	}

	

}
