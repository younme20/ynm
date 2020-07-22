package kr.ko.ym.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ko.ym.common.dao.CommonDao;
@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private CommonDao commonDao;	
	
	//공지사항 목록 조회
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> param) throws Exception {
		
		return commonDao.selectList("notice.noticeList", param);
	}

	@Override
	public Map<String, Object> noticeDetail(Map<String, Object> param) throws Exception {
	
		return commonDao.selectOne("notice.noticeDetail",param);
	}

	@Override
	public Map<String, Object> noticeSelect(Map<String, Object> param) throws Exception {
		
		return commonDao.selectOne("notice.noticeSelect",param);
	}

	@Override
	public Object noticeInsert(Map<String, Object> param) throws Exception {
		
		return commonDao.insert("notice.noticeInsert",param);
	}

	@Override
	public void noticeHitcnt(Map<String, Object> param) throws Exception {
		commonDao.update("notice.noticeHitcnt",param);
	}

	@Override
	public void noticeUpdate(Map<String, Object> param) throws Exception {
		commonDao.update("notice.updateBoard",param);
	}

	@Override
	public void noticeDelete(Map<String, Object> param) throws Exception {
		commonDao.delete("notice.noticeDelete", param);
	}


}
