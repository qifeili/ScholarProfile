package cn.scholarprofile.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.scholarprofile.bean.UploadInfo;
import cn.scholarprofile.dao.FileDao;


@Component("fileDao")
public class FileDaoImpl extends BaseDaoImpl<UploadInfo> implements FileDao {

	/** @Description:根据工程id查找所遇该工程的附件
	 * @exception:
	 */
	@Override
	public List<UploadInfo> findByProjectId(Integer projectId) {
		
		if(null == projectId || projectId <= 0) {
			return null;
		}
		
		return this.find("From UploadInfo u where u.projectId =" + projectId);
	}

	/** @Description:根据工程id查找所遇该工程的附件
	 * @exception:
	 */
	@Override
	public List<UploadInfo> findEnclosuresByProjectId(Integer projectId) {

		if(null == projectId || projectId <= 0) {
			return null;
		}
		return this.find("From UploadInfo u where u.projectId =" + projectId + " and u.fileType = 1");
	}

	/** @Description:根据工程id查找所遇该工程的数据集
	 * @exception:
	 */
	@Override
	public List<UploadInfo> findDataSetByProjectId(Integer projectId) {

		if(null == projectId || projectId <= 0) {
			return new ArrayList<UploadInfo>();
		}
		return this.find("From UploadInfo u where u.projectId =" + projectId + " and u.fileType = 2");
	}

	/** @Description:根据项目Id删除之前上传的所有文件
	 * @exception:
	 */
	@Override
	public void removeFilesByProjectId(Integer projectId) {
		if(null != projectId && projectId > 0) {
			List<UploadInfo> list = this.findByProjectId(projectId);
			for (UploadInfo uploadInfo : list) {
				
				this.delete(uploadInfo);
			}
		}
		
	}

	/** @Description:根据文件id查找文件的上传路径
	 * @exception:
	 */
	@Override
	public String getUploadPathById(Integer id) {
		if(null == id || id <= 0) {
			return null;
		}
		UploadInfo uploadInfo = this.get("From UploadInfo u where u.id =" + id);
		if(uploadInfo == null) {
			return null;
		}
		String uploadPath = uploadInfo.getUploadPath();
		return uploadPath;
	}

	
	
}
