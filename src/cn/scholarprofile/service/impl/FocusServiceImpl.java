package cn.scholarprofile.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Focus;
import cn.scholarprofile.dao.FocusDao;
import cn.scholarprofile.dto.ReviewScholarInfo;
import cn.scholarprofile.service.FocusService;
import cn.scholarprofile.util.DateUtil;
import cn.scholarprofile.util.PageUtil;

@Service("focusService")
@Transactional
public class FocusServiceImpl implements FocusService {

	private FocusDao focusDao;

	public FocusDao getFocusDao() {
		return focusDao;
	}

	@Resource
	public void setFocusDao(FocusDao focusDao) {
		this.focusDao = focusDao;
	}

	/**
	 * @Description:改变关注学者信息的状态
	 * @exception:
	 */
	@Override
	public Boolean changeFocusStatus(int userInfoId, int scholarId)
			throws Exception {
		/*根据userId和scholarId获取出关注信息
		 * 1.查无此人   ----> 未关注过，现在首次关注
		 * 2.查有此人，isFollow = true ----> 曾经关注过，并且现在在关注中
		 * 3.查有此人，isFollow = false ----> 曾经关注过，并且现在已取消关注
		 * **/
		Focus focus = focusDao.getFocusByUserInfoIdAndScholarId(userInfoId, scholarId);
		if(focus == null) { //情况1
			Focus f = new Focus();
			f.setUserInfoId(userInfoId);
			f.setScholarId(scholarId);
			f.setFollow(true);
			System.out.println(f.getFocusTime()); 
//			f.setFocusTime(focusTime);
			focusDao.save(f);
			return true;
		}else {
			//状态反转
			if(focus.isFollow()) {//情况2
				focus.setFollow(false);
				focusDao.update(focus);
			}else { //情况3
				focus.setFollow(true);
				focusDao.update(focus);
			}
			return true;
		}
	}

	/**
	 * @Description:根据用户id查出数据装载页面
	 * @exception:
	 */
	@Override
	public List<ReviewScholarInfo> findFocusInfo(int userInfoId, PageUtil page) throws Exception {
		
		if (page == null) { // 没指定分页情况，默认是第一页，每页10条
			page = new PageUtil();
			page.setCurPage(1);
			page.setRowsPerPage(10);
		}
		List<Object[]> objList = focusDao.findFocusInfo(userInfoId, page);
		List<ReviewScholarInfo> reviewScholarInfos = new ArrayList<>();
		ReviewScholarInfo scholarInfo = null;
		for (Object[] objects : objList) {
			scholarInfo = new ReviewScholarInfo();
			scholarInfo.setId((int)objects[0]);
			Date focusTime = (Date)objects[1];
			scholarInfo.setFocusTime(DateUtil.DateToString(focusTime));
			scholarInfo.setFollowByCurrentUser((boolean)objects[2]);
			scholarInfo.setName((String)objects[3]);
			scholarInfo.setInstitution((String)objects[4]);
			
			reviewScholarInfos.add(scholarInfo);
		}
		return reviewScholarInfos;
	}

	/**
	 * @Description:根据用户id统计数量
	 * @exception:
	 */
	@Override
	public long countByUserInfoId(int userInfoId) throws Exception {
		return focusDao.countByUserInfoId(userInfoId);
	}
	
	

}
