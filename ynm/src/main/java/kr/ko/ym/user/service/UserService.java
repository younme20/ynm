package kr.ko.ym.user.service;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<Map<String, Object>> selectUserByName(Map<String,Object>param);
}
