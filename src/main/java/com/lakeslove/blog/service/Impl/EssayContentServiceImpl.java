package com.lakeslove.blog.service.Impl;

import com.lakeslove.blog.dao.EssayContentDao;
import com.lakeslove.blog.model.EssayContent;
import com.lakeslove.blog.service.EssayContentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EssayContentServiceImpl extends AbstractServiceImpl<EssayContent, Long> implements EssayContentService {

	private static final Logger log = LogManager.getLogger(EssayContentServiceImpl.class);

	@Autowired
	private EssayContentDao essayContentDao;

	@Override
	public EssayContent getEssayContentByEssayId(Long essayId) {
		return essayContentDao.getEssayContentByEssayId(essayId);
	}

	@Override
	public void saveEssayContentByEssayId(Long essayId) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}