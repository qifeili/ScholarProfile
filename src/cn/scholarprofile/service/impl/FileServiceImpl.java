package cn.scholarprofile.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.UploadInfo;
import cn.scholarprofile.dao.FileDao;
import cn.scholarprofile.dto.ProjectInfoStep02;
import cn.scholarprofile.service.FileService;



@Service("fileService")
@Transactional
public class FileServiceImpl implements FileService {

	
	private FileDao fileDao;
	
	public FileDao getFileDao() {
		return fileDao;
	}

	@Resource
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	@Override
	public void add(UploadInfo info) throws Exception {

		fileDao.save(info);
	}

	/** @Description:上传数据集
	 * @exception:
	 */
	@Override
	public void uploadDataSet(String path, String filename, String username, int projectId,  
			ProjectInfoStep02 info, int fileType, int level) throws Exception {
		
		String[] fileDescriptions = info.getUpLoadDataSetFileDis().split("@#￥%\\*&", -1);
		String[] fieldDescriptions = info.getUpLoadDataSetFieldDis().split("@#￥%\\*&", -1);
		
		UploadInfo ui = new UploadInfo(path, filename, username, projectId, fileType, fileDescriptions[level], fieldDescriptions[level]);
		
		fileDao.save(ui);
		
	}

	/** @Description:上传附件
	 * @exception:
	 */
	@Override
	public void uploadEnclosure(String path, String filename, String username, int projectId, 
			int fileType) {
		
		UploadInfo ui = new UploadInfo(path, filename, username, projectId, fileType);
		
		fileDao.save(ui);
	}

	/** @Description://根据文件id获取文件在服务器上的路径
	 * @exception:
	 */
	@Override
	public String getUploadPathById(String id) throws Exception {

		int fileId = Integer.valueOf(id);
		if(fileId <= 0) {
			return null;
		}
		String uploadPath = fileDao.getUploadPathById(fileId);
		
		return uploadPath;
	}
	
	
	
}
