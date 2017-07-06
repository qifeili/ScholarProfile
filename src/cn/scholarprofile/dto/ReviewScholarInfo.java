/**
 * 
 */
package cn.scholarprofile.dto;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年3月13日 下午11:11:50
 * @Description :userIndexReviews.jsp页的scholar部分的页面装载bean
 * @version 1.0
 */
public class ReviewScholarInfo {

	private int id;
	private String name;
	private String fieldName;
	private String focusTime;
	private boolean isFollowByCurrentUser = false;// 是否被当前用户关注
	private String institution;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFocusTime() {
		return focusTime;
	}

	public void setFocusTime(String focusTime) {
		this.focusTime = focusTime;
	}

	public boolean getFollowByCurrentUser() {
		return isFollowByCurrentUser;
	}
	
	public boolean isFollowByCurrentUser() {
		return isFollowByCurrentUser;
	}

	public void setFollowByCurrentUser(boolean isFollowByCurrentUser) {
		this.isFollowByCurrentUser = isFollowByCurrentUser;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	
}
