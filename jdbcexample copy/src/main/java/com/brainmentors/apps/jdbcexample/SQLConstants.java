package com.brainmentors.apps.jdbcexample;

public interface SQLConstants {
	String REGISTER_SQL = "insert into user_mst (userid, password, city, name) values(?,?,?,?)";
	String LOGIN_SQL = "select * from user_mst where userid=? and password=?";
}
