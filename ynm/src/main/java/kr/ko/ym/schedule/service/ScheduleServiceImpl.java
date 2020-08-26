package kr.ko.ym.schedule.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ko.ym.common.dao.CommonDao;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private CommonDao commonDao;


	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> selectSchedule(Map<String, Object> param) throws Exception {
		return commonDao.selectList("schedule.selectScheduleList", param);
	}	
	
	@Override
	public Map<String, Object> insertSchedule(Map<String, Object> param) throws Exception {
		commonDao.insert("schedule.insertSchedule", param);
		
		return commonDao.selectOne("schedule.selectScheduleOne", param);
	}

}
