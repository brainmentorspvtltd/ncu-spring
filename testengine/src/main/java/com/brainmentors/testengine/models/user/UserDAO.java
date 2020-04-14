package com.brainmentors.testengine.models.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.brainmentors.testengine.utils.Query;

@Repository
public class UserDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	static List<Right> rights ;
	private Logger logger = Logger.getLogger(UserDAO.class);
	public UserInfo doLogin(User user) {
		logger.debug("Inside DAO "+user);
		 rights = new ArrayList<>();
		List<UserInfo> list  = jdbcTemplate.query(Query.LOGIN_SQL, new Object[] {user.getUserid(), 
				user.getPassword()},new UserInfoMapper() );
		logger.debug("After JDBC Call "+list);
		if(list==null) {
			return null;
		}
		if(list.size()==0) {
			return null;
		}
		list.get(0).setRights(rights);
		 return list.get(0);
	}

}
class UserInfoMapper implements RowMapper<UserInfo>{

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		UserInfo userInfo = new UserInfo();
		userInfo.setUserid(rs.getString("userid"));
		userInfo.setRoleName(rs.getString("rolename"));
		Right right = new Right();
		right.setName(rs.getString("rightname"));
		right.setUrl(rs.getString("url"));
		UserDAO.rights.add(right);
		return userInfo;
	}
	
}
