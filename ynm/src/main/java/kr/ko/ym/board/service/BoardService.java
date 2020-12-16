package kr.ko.ym.board.service;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<Map<String,Object>>selectBoard(Map<String, Object> param) throws Exception;

	Map<String,Object> selectDetail(Map<String, Object> param) throws Exception;

	Integer insertBoard(Map<String, Object> param) throws Exception;

	void updateCount(Map<String, Object> param) throws Exception;

	void updateBoard(Map<String, Object> param) throws Exception;

	void deleteBoard(Map<String, Object> param) throws Exception;

	Map<String, Object> selectMaxIdx()throws Exception;

	List<Map<String,Object>> serchBoard(Map<String, Object> param)throws Exception;

	List<Map<String,Object>>selectLastComment() throws Exception;

	List<Map<String, Object>> selectCategory()throws Exception;
}
