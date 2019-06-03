package com.lakeslove.blog.service.Impl;

import com.lakeslove.blog.dao.UserMessageDao;
import com.lakeslove.blog.model.UserMessage;
import com.lakeslove.blog.service.UserMessageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserMessageServiceImpl extends AbstractServiceImpl<UserMessage, Long> implements UserMessageService {

	private static final Logger log = LogManager.getLogger(UserMessageServiceImpl.class);

	@Autowired
	private UserMessageDao userMessageDao;
	
	@Override
	public UserMessage getUserMessage(Long id) {
		return this.userMessageDao.getUserMessage(id);
	}
}