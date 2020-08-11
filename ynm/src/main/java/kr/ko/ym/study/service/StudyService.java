package kr.ko.ym.study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface StudyService {

	List<Map<String,Object>>selectList(Map<String, Object> param) throws Exception;

	Map<String,Object> selectDetail(Map<String, Object> param) throws Exception;

	Object insertBoard(Map<String, Object> param) throws Exception;

	void updateBoard(Map<String, Object> param) throws Exception;

	void deleteBoard(Map<String, Object> param) throws Exception;

	List<HashMap<String, Object>> selectSearchList(Map<String, Object> param) throws Exception;

}
