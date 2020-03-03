package com.brainmentors.apps.jdbcexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public UserDTO login(UserDTO user) {
		return null;
	}
	
	public boolean register(UserDTO user) {
		return false;
	}

}
