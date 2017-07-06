/**
 * 
 */
package cn.scholarprofile.dto;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年2月27日 下午3:08:44
 * @Description : 搜索出学者的页面数据封装类
 * @version 1.0
 */
public class ScholarInfo {

	private int id;
	private String name;
	private String institution;// 单位
	private String education;// 教育水平
	private String position;// 职称
	private int follow = 0;// 关注数
	private int outcome = 0;// 成果数
	private int reference = 0;// 被引频次
	private boolean isFollowByCurrentUser = false;// 是否被当前用户关注
	
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getFollow() {
		return follow;
	}

	public void setFollow(int follow) {
		this.follow = follow;
	}

	public int getOutcome() {
		return outcome;
	}

	public void setOutcome(int outcome) {
		this.outcome = outcome;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
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
