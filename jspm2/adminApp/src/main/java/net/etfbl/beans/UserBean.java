package net.etfbl.beans;

import java.util.List;

import net.etfbl.dao.UserDao;
import net.etfbl.dto.User;

public class UserBean {

	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<User> getAll(){
		return UserDao.getAll();
	}
	
	public int update(User user) {
		return UserDao.update(user);
	}
	public int create(User user) {
		return UserDao.create(user);
	}
}
