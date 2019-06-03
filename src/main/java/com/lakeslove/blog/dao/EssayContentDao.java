package com.lakeslove.blog.dao;

import com.lakeslove.blog.model.EssayContent;
import org.springframework.stereotype.Repository;

@Repository
public interface EssayContentDao {
	EssayContent getEssayContentByEssayId(Long essayId);

	void saveEssayContent(EssayContent essayContent);

	void updateEssayContent(EssayContent essayContent);

	void deleteEssayContentByEssayId(Long essayId);
}
