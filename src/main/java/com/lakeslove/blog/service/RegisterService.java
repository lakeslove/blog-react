package com.lakeslove.blog.service;

import com.lakeslove.blog.model.Register;
import com.lakeslove.blog.model.User;

public interface RegisterService extends AbstractService<Register, Long>{
	Boolean existEmail(String email);
	Boolean validateEmailAndVerificationCode(User user, String code);
	void sendEmail(String email);
}
