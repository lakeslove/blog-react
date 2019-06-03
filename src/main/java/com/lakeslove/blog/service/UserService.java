package com.lakeslove.blog.service;

import com.lakeslove.blog.model.User;
import com.lakeslove.blog.util.PageData;
import java.util.List;

public interface UserService extends AbstractService<User, Long>{
	PageData<User> serchUsers(User user, int currentPage);
	User getUser(Long id);
	int insertUser(User user);
	int deleteUser(Long id);
	int updateUser(User user);
	List<User> findUsers(String userName, int start, int limit);
	
	User loginValidate(User user);
	
	String getUserDetail(User user);
}
