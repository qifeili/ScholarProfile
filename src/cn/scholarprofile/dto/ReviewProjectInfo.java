/**
 * 
 */
package cn.scholarprofile.dto;

/**
 * @author  pangchao  E-mail: pangchao620@163.com
 * @date : 2016年3月13日 下午11:11:50
 * @Description :userIndexReviews.jsp页的project部分的页面装载bean
 * @version 1.0
 */
public class ReviewProjectInfo {

	private int id;
	private String title;
	private String focusTime;
	private boolean isFollowByCurrentUser = false;// 是否被当前用户关注

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	
}
