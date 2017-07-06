package cn.scholarprofile.service;

import java.util.List;

import cn.scholarprofile.bean.User;

public interface UserService {

	/*public abstract boolean exists(User u) throws Exception;*/
	/**
	 * 
	 * @Description:添加一个User对象
	 * @param u
	 * @throws Exception
	 * void
	 * @exception:
	 */
	public abstract void add(User u) throws Exception;
	
	public abstract List<User> listAll() throws Exception;
	
	/**
	 * 
	 * @Description:删除一个User对象
	 * @param u
	 * @throws Exception
	 * void
	 * @exception:
	 */
	public abstract void delete(User u) throws Exception;
	
	/**
	 * 
	 * @Description:根据Id删除一个对象
	 * @param id
	 * @throws Exception
	 * void
	 * @exception:
	 */
	public abstract void deleteById(int id) throws Exception;
	
	/**
	 * 
	 * @Description:
	 * @param id
	 * @throws Exception
	 * void
	 * @exception:
	 */
	public abstract User get(int id) throws Exception;
	
	/**
	 * 
	 * @Description:更新User对象
	 * @param user
	 * @throws Exception
	 * void
	 * @exception:
	 */
	public abstract void update(User user) throws Exception;
}
