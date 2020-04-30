package com.brainmentors.testengine.models.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.brainmentors.testengine.utils.Lang;
import com.brainmentors.testengine.utils.MessageBundle;
import com.brainmentors.testengine.utils.Query;
import com.brainmentors.testengine.utils.StatusCode;

@Repository
public class TestDAO {
	@Autowired
	private MessageBundle messageBundle;
	@Autowired
	JdbcTemplate jdbcTemplate;
public TestResponse addTest(Test test) {
	messageBundle.setLang(Lang.ENGLISH);
	// name,descr, duration, attempts, createdby, creationtime, passingscore
	int records = jdbcTemplate.update(Query.TEST_ADD_SQL,test.getName(), test.getDescr(),
			test.getDuration(),test.getNoOfAttempts(), test.getCreatedBy(),
			test.getCreationDateTime(), test.getPassingScore());
	TestResponse response = new TestResponse();
	if(records>0) {
		
		response.setName(test.getCreatedBy());
		response.setMessage(messageBundle.getMessage("test.msg"));
		response.setStatusCode(StatusCode.SUCCESS);
		
	}
	else {
		response.setMessage(messageBundle.getMessage("test.errormsg"));
		response.setStatusCode(StatusCode.FAIl);
	}
	return response;
	}

public int getTestId(String name) {
	int testid = jdbcTemplate.queryForObject(Query.TEST_SELECT_BY_ID, new Object[] {name}, Integer.class);
	return testid;
}

public boolean addTestMap(int testId, int uid) {
	int records = jdbcTemplate.update(Query.TEST_MAPPING_ADD_SQL,testId, uid);
	return records>0;
}
}
