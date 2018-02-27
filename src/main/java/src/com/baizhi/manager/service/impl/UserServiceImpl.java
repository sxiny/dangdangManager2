package src.com.baizhi.manager.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.com.baizhi.manager.dao.UserDao;
import src.com.baizhi.manager.entity.User;
import src.com.baizhi.manager.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	public boolean checkCount(String userCount) {
		
		User u = dao.getByCount(userCount);
		if (u!=null){
			
			return true;
		}
		return false;
	}

	public Map login(User u) {
		Map map = new HashMap();
		
		User uu = dao.getByPwd(u);
		boolean isLogin =false;
		if(uu!=null){
			isLogin = true;
			map.put("user", uu);
		}
		map.put("isLogin", isLogin);
		return map;
	}

}
