/**
 * 
 */
package cn.scholarprofile.bean;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/** @author  作者名 E-mail: 作者邮箱
 * @date : 2016年3月10日 下午7:26:48
 * @Description :关注工程表，和userInfo表是多对一关系
 * @version 1.0
 */

@Entity
@Table(name = "t_focusproject")
public class FocusProject {

	/** focus表自身的id **/
	private int id; 
	/** userInfo表的外键 **/
	private int userInfoId;
	/** 对应关注的scholar的id，但不设关联 **/
	private int projectId;
	/** 是否取消关注，当为true时代表已经取消关注 **/
	/** 1.查无此人   ----> 未关注过，现在首次关注
	 *  2.查有此人，isFollow = true ----> 曾经关注过，并且现在在关注中
	 *  3.查有此人，isFollow = false ----> 曾经关注过，并且现在已取消关注
	 * **/
	private boolean isFollow = false;
	
	/** 关注的时间 **/
	private Date focusTime = new Date(new java.util.Date().getTime());

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(int userInfoId) {
		this.userInfoId = userInfoId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public boolean isFollow() {
		return isFollow;
	}

	public void setFollow(boolean isFollow) {
		this.isFollow = isFollow;
	}

	public Date getFocusTime() {
		return focusTime;
	}

	public void setFocusTime(Date focusTime) {
		this.focusTime = focusTime;
	}
}
