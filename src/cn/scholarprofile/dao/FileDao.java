package cn.scholarprofile.dao;

import java.util.List;

import cn.scholarprofile.bean.UploadInfo;


public interface FileDao extends BaseDao<UploadInfo> {

	/**
	 * @Description:根据工程id查找所遇该工程的文件，包括数据集和附件
	 * @exception:
	 */
	public abstract List<UploadInfo> findByProjectId(Integer projectId);
	
	/**
	 * @Description:根据工程id查找所遇该工程的附件
	 * @exception:
	 */
	public abstract List<UploadInfo> findEnclosuresByProjectId(Integer projectId);
	
	/**
	 * @Description:根据工程id查找所遇该工程的数据集
	 * @exception:
	 */
	public abstract List<UploadInfo> findDataSetByProjectId(Integer projectId);
	
	/**
	 * @Description:根据项目Id删除之前上传的所有文件
	 * @exception:
	 */
	public abstract void removeFilesByProjectId(Integer projectId);
	
	/**
	 * @Description:根据文件id查找文件的上传路径
	 * @exception:
	 */
	public abstract String getUploadPathById(Integer id);
}
