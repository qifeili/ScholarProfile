package cn.scholarprofile.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.FocusProject;
import cn.scholarprofile.dao.FocusProjectDao;
import cn.scholarprofile.dto.ReviewProjectInfo;
import cn.scholarprofile.service.FocusProjectService;
import cn.scholarprofile.util.DateUtil;
import cn.scholarprofile.util.PageUtil;

@Service("focusProjectService")
@Transactional
public class FocusProjectServiceImpl implements FocusProjectService {

	private FocusProjectDao focusProjectDao;

	public FocusProjectDao getFocusProjectDao() {
		return focusProjectDao;
	}

	@Resource
	public void setFocusProjectDao(FocusProjectDao focusProjectDao) {
		this.focusProjectDao = focusProjectDao;
	}

	/**
	 * @Description:改变关注学者信息的状态
	 * @exception:
	 */
	@Override
	public Boolean changeFocusProjectStatus(int userInfoId, int projectId)
			throws Exception {
		/*根据userId和scholarId获取出关注信息
		 * 1.查无此人   ----> 未关注过，现在首次关注
		 * 2.查有此人，isFollow = true ----> 曾经关注过，并且现在在关注中
		 * 3.查有此人，isFollow = false ----> 曾经关注过，并且现在已取消关注
		 * **/
		FocusProject focusProject = focusProjectDao.getFocusProjectByUserInfoIdAndProjectId(userInfoId, projectId);
		if(focusProject == null) { //情况1
			FocusProject f = new FocusProject();
			f.setUserInfoId(userInfoId);
			f.setProjectId(projectId);
			f.setFollow(true);
			focusProjectDao.save(f);
			return true;
		}else {
			//状态反转
			if(focusProject.isFollow()) {//情况2
				focusProject.setFollow(false);
				focusProjectDao.update(focusProject);
			}else { //情况3
				focusProject.setFollow(true);
				focusProjectDao.update(focusProject);
			}
			return true;
		}
	}

	/**
	 * @Description:根据用户id获取数据装载ReviewProjectInfo
	 * @exception:
	 */
	@Override
	public List<ReviewProjectInfo> findFocusProjectInfo(int userInfoId, PageUtil page) throws Exception {
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		List<Object[]> objList = focusProjectDao.findFocusProjectInfo(userInfoId, page);
		/*if(objList == null || objList.size() == 0) {
			return null;
		}*/
		List<ReviewProjectInfo> reviewProjectInfos = new ArrayList<>();
		ReviewProjectInfo projectInfo = null;
		for (Object[] objects : objList) {
			projectInfo = new ReviewProjectInfo();
			projectInfo.setId((int)objects[0]);
			projectInfo.setTitle((String)objects[1]);
			Date focusTime = (Date)objects[2];
			projectInfo.setFocusTime(DateUtil.DateToString(focusTime));
			projectInfo.setFollowByCurrentUser((boolean)objects[3]);
			
			reviewProjectInfos.add(projectInfo);
		}
		return reviewProjectInfos;
	}

	/**
	 * @Description://根据用户id统计数据数量
	 * @exception:
	 */
	@Override
	public long countByUserInfoId(int userInfoId) throws Exception {
		return focusProjectDao.countByUserInfoId(userInfoId);
	}
	
	

}
