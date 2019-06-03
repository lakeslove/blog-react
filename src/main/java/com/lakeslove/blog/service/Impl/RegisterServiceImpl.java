package com.lakeslove.blog.service.Impl;

import com.lakeslove.blog.dao.RegisterDao;
import com.lakeslove.blog.dao.UserDao;
import com.lakeslove.blog.model.Register;
import com.lakeslove.blog.model.User;
import com.lakeslove.blog.service.RegisterService;
import com.lakeslove.blog.util.Email;
import com.lakeslove.blog.util.PropertyUtil;
import com.lakeslove.blog.util.RandomCodeUtil;
import com.lakeslove.blog.util.SpringEmailUtil;
import com.lakeslove.blog.util.VelocitiesUtil;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class RegisterServiceImpl extends AbstractServiceImpl<Register, Long>implements RegisterService {

	private static final Logger log = LogManager.getLogger(RegisterServiceImpl.class);

	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public Boolean existEmail(String email) {
		int emailCount = registerDao.existEmail(email);
		return emailCount>0?true:false;
	}

	@Override
	@Transactional(readOnly=false, rollbackFor=Exception.class)
	public void sendEmail(String emailAddress) {
		String verificationCode = RandomCodeUtil.createNumberAndLetterCode(4);
		Register register = new Register();
		register.setEmail(emailAddress);
		register.setVerificationCode(verificationCode);
		registerDao.insertRegister(register);
//		SpringEmailUtil.sendEmail(email);
		Email email = new Email();	
		email.setFromEmailAddress(PropertyUtil.getPropertyValue("mail.fromAddress"));
		email.setFromPersonName(PropertyUtil.getPropertyValue("mail.fromAddress"));
		email.setToEmailAddresses(new String[]{emailAddress});
		email.setSubject("微博客验证码");
		Map<String,Object> velocityContext = new HashMap<>();
		velocityContext.put("code", verificationCode);
		velocityContext.put("webAddress",PropertyUtil.getPropertyValue("web.address"));
		String content = VelocitiesUtil.getVelocityText("email_register.vm", velocityContext);
		email.setContent(content);
		try {
			SpringEmailUtil.sendEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Boolean validateEmailAndVerificationCode(User user,String code) {
		Register register = new Register();
		register.setEmail(user.getEmail());
		register.setVerificationCode(code);
		HashMap<String,Integer> resultMap = registerDao.validateEmailAndVerificationCode(register);
		if(resultMap.size()>0){
			registerDao.deleteRegister((long)resultMap.get("id"));
			userDao.insertUser(user);
			return true;
		}
		return false;
	}
	
	
}