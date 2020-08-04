package kr.ko.ym.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	List<Map<String,Object>>selectList(Map<String, Object> param) throws Exception;

	Map<String,Object> noticeDetail(Map<String, Object> param) throws Exception;

	Map<String,Object> noticeSelect(Map<String, Object> param) throws Exception;

	Object noticeInsert(Map<String, Object> param) throws Exception;

	void noticeHitcnt(Map<String, Object> param) throws Exception;

	void noticeUpdate(Map<String, Object> param) throws Exception;

	void noticeDelete(Map<String, Object> param) throws Exception;
}
