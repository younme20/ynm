package kr.ko.ym.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	List<Map<String,Object>>selectBoard(Map<String, Object> param) throws Exception;

	Map<String,Object> selectDetail(Map<String, Object> param) throws Exception;

	Object insertBoard(Map<String, Object> param) throws Exception;

	void updateCount(Map<String, Object> param) throws Exception;

	void updateBoard(Map<String, Object> param) throws Exception;

	void deleteBoard(Map<String, Object> param) throws Exception;

	Map<String, Object> selectMaxIdx()throws Exception;

	List<Map<String,Object>> serchBoard(Map<String, Object> param)throws Exception;
}
