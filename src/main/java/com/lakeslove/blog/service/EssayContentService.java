package com.lakeslove.blog.service;

import com.lakeslove.blog.model.EssayContent;

public interface EssayContentService extends AbstractService<EssayContent, Long>{
	EssayContent getEssayContentByEssayId(Long essayId);
	void saveEssayContentByEssayId(Long essayId);
}
