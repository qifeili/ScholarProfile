/**
 * 
 */
package cn.scholarprofile.dto;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年2月27日 下午3:08:44
 * @Description : 搜索出项目的页面数据封装类
 * @version 1.0
 */
public class ProjectInfo {

	private int id;
	private String projectType; //工程类型
	private String title; //一句话表述需求，即标题
	private Double budget;//项目资金预算
	private String summary;//项目信息的摘要
	private boolean isFollowByCurrentUser = false;// 是否被当前用户关注
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	//网页端需要get方法
	public boolean getIsFollowByCurrentUser() {
		return isFollowByCurrentUser;
	}
	
	public boolean isFollowByCurrentUser() {
		return isFollowByCurrentUser;
	}

	public void setFollowByCurrentUser(boolean isFollowByCurrentUser) {
		this.isFollowByCurrentUser = isFollowByCurrentUser;
	}
	

}
