/**
 * 
 */
package cn.scholarprofile.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2015年12月20日 下午3:35:55
 * @Description : 对应field表
 * @version 1.0
 */
@Entity
@Table(name="t_project")
public class Project {

	private int id;
	private String projectType; //工程类型
	private String title; //一句话表述需求，即标题
	private String developmentCycle;//开发周期
	private String tagsName;//用户添加的子标题，数据是一个约定分割符分割的字符串，例如"项目背景@#￥%*&张三"
	private String tagsinfo;//用户添加的子标题的内容，数据也是一个约定分割符分割的字符串。例如"王五@#￥%*&李四"
	
	//附件的表述暂时放在UploadInfo表里
	/*private String upLoadDataSetFileDis;//数据文件描述，数据是一个约定分割符分割的字符串，例如"项目背景@#￥%*&张三"
	private String upLoadDataSetFieldDis;//数据字段描述，数据也是一个约定分割符分割的字符串。例如"王五@#￥%*&李四
	*/	private String stage = "暂无状态信息";//项目所处阶段，一共5个阶段,0->暂无状态信息,1->配服务商;2->选择服务商，签约;3->服务商工作;4->验收工作，满意后付款
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date releaseDate;//项目发布时间
	private int auctionNumber = 0;//竞标人数
	private Double budget = 0.0;//项目资金预算
	private int status = 0;//项目所处状态，0表示未发布，1表示已发布
	private int step = 0; //表示项目发布到第几步, 每发布完一步此值加一
	
	private Field field;//项目所属的领域
	private UserInfo userInfo;//项目所属的用户
	
	@Id
	@GeneratedValue
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

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	@Type(type="date")
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDevelopmentCycle() {
		return developmentCycle;
	}

	public void setDevelopmentCycle(String developmentCycle) {
		this.developmentCycle = developmentCycle;
	}

	public int getAuctionNumber() {
		return auctionNumber;
	}

	public void setAuctionNumber(int auctionNumber) {
		this.auctionNumber = auctionNumber;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	@ManyToOne(targetEntity=Field.class)
	@JoinColumn(name="fieldId", referencedColumnName="id")
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	@ManyToOne(targetEntity=UserInfo.class)
	@JoinColumn(name="userinfoId", referencedColumnName="id")
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getTagsName() {
		return tagsName;
	}

	public void setTagsName(String tagsName) {
		this.tagsName = tagsName;
	}

	@Type(type="text")
	public String getTagsinfo() {
		return tagsinfo;
	}

	public void setTagsinfo(String tagsinfo) {
		this.tagsinfo = tagsinfo;
	}
	
}
