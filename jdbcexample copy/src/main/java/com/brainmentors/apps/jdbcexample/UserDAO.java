package com.brainmentors.apps.jdbcexample;



import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

class UserMapper implements RowMapper<UserDTO>{
	
	@Override
	public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		UserDTO userDTO = new UserDTO();
		userDTO.setName(rs.getString("name"));
		userDTO.setCity(rs.getString("city"));
		return  userDTO;
		
		
	}
	
}
@Repository
public class UserDAO implements SQLConstants {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserDTO login(UserDTO user) {
		try {
		return jdbcTemplate.queryForObject(LOGIN_SQL, new UserMapper(),user.getUserid(), user.getPassword());
		}
		catch(EmptyResultDataAccessException e) {
			return null;
		}
		}
	
	public boolean register(UserDTO user) {
		int recordCount = jdbcTemplate.update(REGISTER_SQL, user.getUserid(), user.getPassword(),user.getCity(), user.getName());
		return recordCount>0;
		//return false;
	}

}
