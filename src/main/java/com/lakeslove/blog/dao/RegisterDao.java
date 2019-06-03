package com.lakeslove.blog.dao;

import com.lakeslove.blog.model.Register;
import java.util.HashMap;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDao {

	Integer existEmail(String email);

	HashMap<String, Integer> validateEmailAndVerificationCode(Register register);

	void insertRegister(Register register);

	int deleteRegister(Long id);
}
