package kr.ko.ym.hashtag.service;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ko.ym.common.dao.CommonDao;

@Service("HashtagService")
public class HshtagServiceImpl implements HashtagService {
	
	@Autowired
	private CommonDao commonDao;

	@Override
	public void insertHashTag(Map<String, Object> param) throws Exception {
		 commonDao.insert("hashtag.insertHashTag", param);
	}

}
