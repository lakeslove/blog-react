package com.lakeslove.blog.dao;

import com.lakeslove.blog.model.UserMessage;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMessageDao {
	UserMessage getUserMessage(Long id);
}
