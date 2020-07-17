package kr.ko.ym.study.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ko.ym.common.dao.CommonDao;

@Service("studyService")
public class StudyServiceImpl implements StudyService {
	
	@Autowired
	private CommonDao commonDao;	

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectList(Map<String, Object> param) throws Exception {
		return commonDao.selectList("study.selectList", param);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> selectDetail(Map<String, Object> param) throws Exception {
		Map<String,Object>map = new HashMap<String,Object>();
		if(commonDao.selectOne("study.selectDetail", param) != null) {
			map = commonDao.selectOne("study.selectDetail", param);
		}
		return map;
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

}
