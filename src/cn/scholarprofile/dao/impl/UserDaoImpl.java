package cn.scholarprofile.dao.impl;

import java.util.List;


import org.springframework.stereotype.Component;
import cn.scholarprofile.bean.User;
import cn.scholarprofile.dao.UserDao;

@Component("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/*@Resource
	private SessionFactory sessionFactory;*/
	
	/* (non-Javadoc)
	 * @see cn.scholarprofile.dao.UserDao#listAll()
	 */
	@Override
	public List<User> listAll() {
		return this.find("from User");
	}

	/* (non-Javadoc)
	 * @see cn.scholarprofile.dao.UserDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		User user = this.get(User.class, id);
		this.delete(user);
	}

	
}
