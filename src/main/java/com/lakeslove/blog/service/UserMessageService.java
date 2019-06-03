package com.lakeslove.blog.service;

import com.lakeslove.blog.model.UserMessage;

public interface UserMessageService extends AbstractService<UserMessage, Long>{
	UserMessage getUserMessage(Long id);
}
