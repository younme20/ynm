package kr.ko.ym.hashtag.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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

	@Override
	public Map<String, Object> selectOneHashTag(Map<String, Object> param) throws Exception {
		return  commonDao.selectOne("hashtag.selectOneHashTag", param);
	}

	@Override
	public void updateHashTag(Map<String, Object> param) throws Exception {
		 commonDao.update("hashtag.updateHashTag", param);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashSet<String> selectHashTag(Map<String, Object> param) throws Exception {
		
		List<Map<String, Object>> list =  commonDao.selectList("hashtag.selectHashTag", param);
		HashSet<String> set = new HashSet<String>();
		String[] arr = null;
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i).get("CONTENTS").toString();
			arr = str.split(",");
			
			for(int j=0; j<arr.length; j++) {
				set.add(arr[j]);
			}
		}
	        return set;
	}

	@Override
	public HashSet<String> selectAllHashTag() throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list =  commonDao.selectList("hashtag.selectAllHashTag");
		HashSet<String> set = new HashSet<String>();
		String[] arr = null;
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i).get("CONTENTS").toString();
			arr = str.split(",");
			
			for(int j=0; j<arr.length; j++) {
				set.add(arr[j]);
			}
		}
		
		
	   return set;
	}

	@Override
	public void deleteHashTag(Map<String, Object> param) throws Exception {
		commonDao.selectList("hashtag.deleteHashTag", param);
		
	}

}
