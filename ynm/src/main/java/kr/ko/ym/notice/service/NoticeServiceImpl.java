package kr.ko.ym.notice.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ko.ym.common.dao.CommonDao;
import kr.ko.ym.common.util.PagingUtil;
@Service("NoticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private CommonDao commonDao;	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectBoard(Map<String, Object> param) throws Exception {
		PagingUtil paging = new PagingUtil();
		int index = 1;
		if(param.containsKey("pageIndex")) {
 			index = Integer.parseInt(param.get("pageIndex").toString());
 			paging.setPageIndex(index);
			
		}
		paging.countPaging(index, 5);
		param.put("page",paging);
		
		return commonDao.selectList("notice.selectBoard", param);
	}

	@Override
	public Map<String, Object> selectDetail(Map<String, Object> param) throws Exception {
	
		return commonDao.selectOne("notice.detailBoard",param);
	}

	@Override
	public Object insertBoard(Map<String, Object> param) throws Exception {
		
		return commonDao.insert("notice.insertBoard",param);
	}

	@Override
	public void updateCount(Map<String, Object> param) throws Exception {
		commonDao.update("notice.updateCount",param);
	}

	@Override
	public void updateBoard(Map<String, Object> param) throws Exception {
		commonDao.update("notice.updateBoard",param);
	}

	@Override
	public void deleteBoard(Map<String, Object> param) throws Exception {
		commonDao.delete("notice.deleteBoard", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public  Map<String, Object> selectMaxIdx() throws Exception {
		return commonDao.selectOne("notice.selectMaxIdx");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> serchBoard(Map<String, Object> param) throws Exception {
		return commonDao.selectList("notice.selectBoard", param);
	}
	
	
	@Override
	public Map<String, Object> selectCount(Map<String, Object> param) throws Exception {
		return commonDao.selectOne("notice.selectCount", param);
	}


}
