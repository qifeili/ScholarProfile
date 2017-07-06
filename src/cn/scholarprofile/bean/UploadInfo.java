package cn.scholarprofile.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author  pangchao E-mail: pangchao620@163.com
 * @date : 2016年1月16日 下午8:11:18 
 * @Description : 文件上传
 * @version 1.0
 */

/**
 * 备注：为了减少关联的复杂性，上传文件和工程之间不做关联配置，手动控制关联，由projectId字段控制
 */
@Entity
@Table(name="t_uploadinfo")
public class UploadInfo {

	private int id;
	private String uploadPath;
	private String filename;
	private String username;//所属用户的用户名
	private int projectId;//所属项目的id
	private int fileType;//1表示上传的是附件，2表示上传的是数据集
	private String upLoadDataSetFileDis;//数据文件描述
	private String upLoadDataSetFieldDis;//数据字段描述

	/**
	 * @Description:默认构造器
	 */
	public UploadInfo() {
		super();
	}

	/**
	 * @Description:上传文件附件的构造器
	 */
	public UploadInfo(String uploadPath, String filename, String username, int projectId,
			int fileType) {
		super();
		this.uploadPath = uploadPath;
		this.filename = filename;
		this.username = username;
		this.projectId = projectId;
		this.fileType = fileType;
	}
	
	/**
	 * @Description:上传文件数据集的构造器
	 */
	public UploadInfo(String uploadPath, String filename, String username, int projectId,
			int fileType, String upLoadDataSetFileDis,
			String upLoadDataSetFieldDis) {
		super();
		this.uploadPath = uploadPath;
		this.filename = filename;
		this.username = username;
		this.projectId = projectId;
		this.fileType = fileType;
		this.upLoadDataSetFileDis = upLoadDataSetFileDis;
		this.upLoadDataSetFieldDis = upLoadDataSetFieldDis;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	public String getUpLoadDataSetFileDis() {
		return upLoadDataSetFileDis;
	}

	public void setUpLoadDataSetFileDis(String upLoadDataSetFileDis) {
		this.upLoadDataSetFileDis = upLoadDataSetFileDis;
	}

	public String getUpLoadDataSetFieldDis() {
		return upLoadDataSetFieldDis;
	}

	public void setUpLoadDataSetFieldDis(String upLoadDataSetFieldDis) {
		this.upLoadDataSetFieldDis = upLoadDataSetFieldDis;
	}

}
