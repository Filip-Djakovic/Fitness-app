package net.etfbl.beans;

import net.etfbl.dao.UserAccountDao;
import net.etfbl.dto.UserAccount;

public class UserAccountBean {

	public UserAccountBean() {
	}
	
	public boolean login(UserAccount user) {
		return UserAccountDao.login(user);
	}

}
