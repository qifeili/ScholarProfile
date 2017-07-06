package cn.scholarprofile.dao;

import java.util.List;

import cn.scholarprofile.bean.User;

public interface UserDao extends BaseDao<User>{
	/**
	 * 
	 * @Description:查询出所有User
	 * @return
	 * List<User>
	 * @exception:
	 */
	public List<User> listAll();
	
	/**
	 * 
	 * @Description:根据Id删除User对象
	 * @param id
	 * void
	 * @exception:
	 */
	public void deleteById(int id);
}