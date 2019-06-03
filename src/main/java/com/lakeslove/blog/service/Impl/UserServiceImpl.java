package com.lakeslove.blog.service.Impl;

import com.lakeslove.blog.dao.UserDao;
import com.lakeslove.blog.model.User;
import com.lakeslove.blog.service.UserService;
import com.lakeslove.blog.util.PageData;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends AbstractServiceImpl<User, Long>implements UserService {

	private static final Logger log = LogManager.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(Long id) {
		return this.userDao.getUser(id);
	}

	@Override
	public int insertUser(User user) {
		return this.userDao.insertUser(user);
	}

	@Override
	public int deleteUser(Long id) {
		return this.userDao.deleteUser(id);
	}

	@Override
	public int updateUser(User user) {
		return this.userDao.updateUser(user);
	}

	@Override
	public List<User> findUsers(String userName, int start, int limit) {
		return this.userDao.findUsers(userName);
	}
	
	@Override
	public PageData<User> serchUsers(User user, int currentPage) {
		
		Long sizeOfAll = userDao.getCount(user.getName());
		PageData<User> pageData = new PageData<User>(currentPage);
		if(sizeOfAll>0){
			List<User> userList = findUsers(user.getName(),pageData.getOffset(currentPage),pageData.getPerPageNum());
			pageData.setData(sizeOfAll, userList);
		}
		return pageData;
	}

	@Override
	public User loginValidate(User user) {
		User wholeUser = userDao.getUserByEmailAndPassword(user);
		return wholeUser;
	}

	@Override
	public String getUserDetail(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}