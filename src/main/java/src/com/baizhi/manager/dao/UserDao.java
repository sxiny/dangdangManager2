package src.com.baizhi.manager.dao;

import src.com.baizhi.manager.entity.User;

public interface UserDao {

	User getByCount(String userCount);

	User getByPwd(User u);
	
}
