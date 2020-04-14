package com.brainmentors.testengine.models.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
	@Autowired
	UserHelper helper;
	
	public UserHelper getHelper() {
		return helper;
	}

	public void setHelper(UserHelper helper) {
		this.helper = helper;
	}

	public UserInfo login(User userObject) {
		return helper.login(userObject);
	}
}
