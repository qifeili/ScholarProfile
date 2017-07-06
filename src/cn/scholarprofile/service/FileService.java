package cn.scholarprofile.service;

import cn.scholarprofile.bean.UploadInfo;
import cn.scholarprofile.dto.ProjectInfoStep02;



public interface FileService {

	//添加文件上传记录
	public abstract void add(UploadInfo info) throws Exception;
	//上传数据集
	public abstract void uploadDataSet(String path, String filename, String username, int projectId, ProjectInfoStep02 info, int fileType, int level) throws Exception;//2表示上传的文件类型是数据集
	//上传文件附件
	public abstract void uploadEnclosure(String path, String filename, String username, int projectId, int fileType);//1表示上传的文件类型是文件附件
	//根据文件id获取文件在服务器上的路径
	public abstract String getUploadPathById(String id) throws Exception;
}
