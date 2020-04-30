package com.brainmentors.testengine.utils;

public interface Query {
	String LOGIN_SQL = "select userid, user.name as uname, phone ,email, role.name as rolename, rights.name as rightname,"
			+ " rights.url from user_mst user, role_mst role, user_role_mapping urmap, "
			+ "right_mst rights,role_right_mapping rrmap  where userid=? and password=?"
			+ " and user.uid=urmap.uid and role.roleid=urmap.roleid and rrmap.roleid=role.roleid "
			+ "and rrmap.rightid=rights.rightid";
	
	String TEST_ADD_SQL = "insert into test (name,descr, duration, attempts, createdby, creationtime, passingscore) values(?,?,?,?,?,?,?)";
	String TEST_MAPPING_ADD_SQL = "insert into user_test_mapping (testid,uid) values(?,?)";
	String TEST_SELECT_BY_ID = "select testid from test where name=?";
}
