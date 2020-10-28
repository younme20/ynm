package kr.ko.ym.hashtag.service;

import java.util.Map;

public interface HashtagService {
	void insertHashTag(Map<String, Object> param) throws Exception;
	
	Map<String, Object> selectOneHashTag(Map<String, Object> param) throws Exception;
	
	void updateHashTag(Map<String, Object> param) throws Exception;

}
