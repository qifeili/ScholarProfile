package cn.scholarprofile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Project;
import cn.scholarprofile.bean.Scholar;
import cn.scholarprofile.dao.FieldDao;
import cn.scholarprofile.dao.ProjectDao;
import cn.scholarprofile.dao.ScholarDao;
import cn.scholarprofile.dto.HotFieldCell;
import cn.scholarprofile.dto.IndexInfo;
import cn.scholarprofile.service.IndexService;

@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService {

	private FieldDao fieldDao;
	private ScholarDao scholarDao;
	private ProjectDao projectDao;

	public FieldDao getFieldDao() {
		return fieldDao;
	}

	@Resource
	public void setFieldDao(FieldDao fieldDao) {
		this.fieldDao = fieldDao;
	}

	public ScholarDao getScholarDao() {
		return scholarDao;
	}

	@Resource
	public void setScholarDao(ScholarDao scholarDao) {
		this.scholarDao = scholarDao;
	}

	public ProjectDao getProjectDao() {
		return projectDao;
	}

	@Resource
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	/**
	 * @Description:获取首页的数据信息
	 * @exception:
	 */
	@Override
	public IndexInfo getIndexInfo() throws Exception {
		IndexInfo indexInfo = new IndexInfo();
		List<String> fieldNames = fieldDao.listHotFieldNames();
		for (String fieldName : fieldNames) {
			List<Scholar> scholars = scholarDao.findTopScholarsByFieldName(fieldName);			
			HotFieldCell cell = new HotFieldCell();
			cell.setFieldName(fieldName);
			switch (scholars.size()) {
			case 0:
				cell.setScholar1(null);
				cell.setScholar2(null);
				cell.setScholar3(null);
				break;
			case 1:
				cell.setScholar1(scholars.get(0));
				cell.setScholar2(null);
				cell.setScholar3(null);
				break;
			case 2:
				cell.setScholar1(scholars.get(0));
				cell.setScholar2(scholars.get(1));
				cell.setScholar3(null);
				break;
			case 3:
				cell.setScholar1(scholars.get(0));
				cell.setScholar2(scholars.get(1));
				cell.setScholar3(scholars.get(2));
				break;

			}
			
			
			
			indexInfo.getHotFields().add(cell);
		}
		List<Project> projects = projectDao.findLatestProjects();
		indexInfo.setLatestProjects(projects);
		return indexInfo;
	}

	
	
}
