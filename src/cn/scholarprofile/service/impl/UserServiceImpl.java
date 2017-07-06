package cn.scholarprofile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.User;
import cn.scholarprofile.dao.UserDao;
import cn.scholarprofile.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	/*public boolean exists(User u) throws Exception {
		return userDao.checkUserExistsWithName(u.getUsername());

	}*/

	public void add(User u) throws Exception {
		userDao.save(u);
	}

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#list()
	 */
	@Override
	public List<User> listAll() throws Exception {
		return userDao.listAll();
	}

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#delete(cn.scholarprofile.bean.User)
	 */
	@Override
	public void delete(User u) throws Exception {
		userDao.delete(u);
	}

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#deleteById(int)
	 */
	@Override
	public void deleteById(int id) throws Exception {
		userDao.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#getById(int)
	 */
	@Override
	public User get(int id) throws Exception {
		User user = userDao.get(User.class, id);
		return user;
	}

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#update(cn.scholarprofile.bean.User)
	 */
	@Override
	public void update(User user) throws Exception {
		userDao.update(user);
	}

	
}
