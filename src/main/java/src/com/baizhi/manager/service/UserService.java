package src.com.baizhi.manager.service;

import java.util.Map;

import src.com.baizhi.manager.entity.User;

public interface UserService {
	/**
	 * 验证用户名的业务
	 * @param userCount
	 * @return
	 */
	boolean checkCount(String userCount);
	/**
	 * 登录的业务
	 * @param u
	 * @return
	 */
	Map login(User u);

}
