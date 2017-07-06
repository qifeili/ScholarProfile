/**
 * 
 */
package cn.scholarprofile.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pangchao E-mail: pangchao620@163.com
 * @date : 2016年1月15日 下午3:13:10
 * @Description :
 * @version 1.0
 */
public class ProjectInfoDetails {

	private int id;
	private String title; //一句话表述需求，即标题
	private String developmentCycle;// 开发周期
	private String stage = "暂无状态信息";// 项目所处阶段，一共5个阶段,0->暂无状态信息,1->配服务商;2->选择服务商，签约;3->服务商工作;4->验收工作，满意后付款
	private String releaseDate;// 项目发布时间
	private int auctionNumber = 0;// 竞标人数
	private Double budget;// 项目资金预算
	private String projectType; // 工程类型
	private int status = 0;//项目所处状态，0表示未发布，1表示已发布

	//private Map<String, String> projectDetail = new HashMap<String, String>();// 项目详情，项目详情由用户填写子标题和内容,子标题为key，内容为value。
	// 文件附件
	private Map<String, Integer> projectEnclosures = new HashMap<String, Integer>();// 附件名为key，文件id为value
	// 数据集
	private List<String> projectDataSetFilenames = new ArrayList<String>();//数据据文件名列表
	private List<Integer> projectDataSetFileIds = new ArrayList<Integer>();//数据集文件id列表，与文件名一一对应，便于实现文件下载

	// 数据集描述
	private List<String> upLoadDataSetFileDis = new ArrayList<String>();////数据文件描述
	private List<String> upLoadDataSetFieldDis = new ArrayList<String>();//数据字段描述
	
	//子标题和子标题内容
	private List<String> tagsNames = new ArrayList<String>();//子标题
	private List<String> tagsinfos = new ArrayList<String>();//子标题内容

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

	public String getDevelopmentCycle() {
		return developmentCycle;
	}

	public void setDevelopmentCycle(String developmentCycle) {
		this.developmentCycle = developmentCycle;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	/*public Map<String, String> getProjectDetail() {
		return projectDetail;
	}

	public void setProjectDetail(Map<String, String> projectDetail) {
		this.projectDetail = projectDetail;
	}*/

	public List<String> getProjectDataSetFilenames() {
		return projectDataSetFilenames;
	}

	public Map<String, Integer> getProjectEnclosures() {
		return projectEnclosures;
	}

	public void setProjectEnclosures(Map<String, Integer> projectEnclosures) {
		this.projectEnclosures = projectEnclosures;
	}

	public void setProjectDataSetFilenames(List<String> projectDataSetFilenames) {
		this.projectDataSetFilenames = projectDataSetFilenames;
	}

	public List<Integer> getProjectDataSetFileIds() {
		return projectDataSetFileIds;
	}

	public void setProjectDataSetFileIds(List<Integer> projectDataSetFileIds) {
		this.projectDataSetFileIds = projectDataSetFileIds;
	}

	public List<String> getUpLoadDataSetFileDis() {
		return upLoadDataSetFileDis;
	}

	public void setUpLoadDataSetFileDis(List<String> upLoadDataSetFileDis) {
		this.upLoadDataSetFileDis = upLoadDataSetFileDis;
	}

	public List<String> getUpLoadDataSetFieldDis() {
		return upLoadDataSetFieldDis;
	}

	public void setUpLoadDataSetFieldDis(List<String> upLoadDataSetFieldDis) {
		this.upLoadDataSetFieldDis = upLoadDataSetFieldDis;
	}

	public List<String> getTagsNames() {
		return tagsNames;
	}

	public void setTagsNames(List<String> tagsNames) {
		this.tagsNames = tagsNames;
	}

	public List<String> getTagsinfos() {
		return tagsinfos;
	}

	public void setTagsinfos(List<String> tagsinfos) {
		this.tagsinfos = tagsinfos;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
