package kr.ko.ym.user.service;

import kr.ko.ym.common.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private CommonDao commonDao;

    @Override
    public List<Map<String, Object>> selectUserByName(Map<String,Object>param) {
        return commonDao.selectList("user.selectUserByUserName", param);
    }
}
