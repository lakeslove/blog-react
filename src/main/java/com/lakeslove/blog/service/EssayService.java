package com.lakeslove.blog.service;

import com.lakeslove.blog.model.Essay;

public interface EssayService extends AbstractService<Essay, Long>{
	String getEssayListByUserId(Long userId, Integer currentPage) throws Exception;
	Essay getEssayByUserIdAndId(Long userId, Long essayId);
	Long saveEssay(Essay essay, String essayContent);
	void deleteEssay(Long id);
	Essay getEssayAndContent(Long id);
	String getEssayListByFlag(Integer flag, Integer currentPage) throws Exception;
}
