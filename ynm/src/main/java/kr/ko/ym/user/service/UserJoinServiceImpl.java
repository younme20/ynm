package kr.ko.ym.user.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import kr.ko.ym.common.dao.CommonDao;

@Service("UserJoinService")
public class UserJoinServiceImpl implements UserJoinService {
	
	@Autowired
	private CommonDao commonDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public Object insertUser(Map<String, Object> param) throws Exception {
		
		String password = (String) param.get("password");
		param.put("password", passwordEncoder.encode(password));
		
		commonDao.insert("user.insertUser", param);
		return null;
	}

	@Override
	public void updateUser(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Map<String, Object> param) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object selectUserNameCehck(Map<String, Object> param) throws Exception {
		param.put("USE", commonDao.selectCount("user.selectUserNameCehck", param));
		return param;
	}

}
