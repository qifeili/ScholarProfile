package cn.scholarprofile.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.scholarprofile.bean.Field;
import cn.scholarprofile.dao.FieldDao;
import cn.scholarprofile.service.FieldService;

@Service("fieldService")
@Transactional
public class FieldServiceImpl implements FieldService {

	private FieldDao fieldDao;

	public FieldDao getFieldDao() {
		return fieldDao;
	}

	@Resource
	public void setFieldDao(FieldDao fieldDao) {
		this.fieldDao = fieldDao;
	}

	/*public boolean exists(User u) throws Exception {
		return userDao.checkUserExistsWithName(u.getUsername());

	}*/

/*	public void add(User u) throws Exception {
		userDao.save(u);
	}*/

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#list()
	 */
	@Override
	public List<Field> listAll() throws Exception {
		return fieldDao.listAll();
	}

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#delete(cn.scholarprofile.bean.User)
	 */
/*	@Override
	public void delete(User u) throws Exception {
		userDao.delete(u);
	}*/

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#deleteById(int)
	 */
/*	@Override
	public void deleteById(int id) throws Exception {
		userDao.deleteById(id);
	}*/

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#getById(int)
	 */
/*	@Override
	public User get(int id) throws Exception {
		User user = userDao.get(User.class, id);
		return user;
	}*/

	/* (non-Javadoc)
	 * @see cn.scholarprofile.service.UserService#update(cn.scholarprofile.bean.User)
	 */
/*	@Override
	public void update(User user) throws Exception {
		userDao.update(user);
	}*/

	
}
