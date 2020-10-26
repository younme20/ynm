package kr.ko.ym.study.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ko.ym.common.auth.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ko.ym.common.dao.CommonDao;
import kr.ko.ym.common.util.PagingUtil;

@Service("studyService")
public class StudyServiceImpl implements StudyService {
	
	@Autowired
	private CommonDao commonDao;	  

	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> param) throws Exception {
		PagingUtil paging = new PagingUtil();
		
		int index = 1;
		if(param.containsKey("pageIndex")) {
			index = Integer.parseInt(param.get("pageIndex").toString());
		}		
		
		paging.countPaging(index, 10);
		
		param.put("page", paging);		
		
		return commonDao.selectList("study.selectList", param);
	}

	@Override
	public Map<String, Object> selectDetail(Map<String, Object> param) throws Exception {
		commonDao.insert("study.updateBoardHit", param);

		return commonDao.selectOne("study.selectDetail", param);
	}

	@Override
	public Object insertBoard(Map<String, Object> param) throws Exception {
		commonDao.insert("study.insertBoard", param);	
		return param;
	}

	@Override
	public void updateBoard(Map<String, Object> param) throws Exception {
		commonDao.update("study.updateBoard", param);			
	}

	@Override
	public void deleteBoard(Map<String, Object> param) throws Exception {
		commonDao.delete("study.deleteBoard", param);			
	}
	
	@Override
	public Map<String, Object> selectTotalCount(Map<String, Object> param) throws Exception {
		return commonDao.selectOne("study.selectTotalCount", param);
	}



}