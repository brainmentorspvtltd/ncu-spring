package com.brainmentors.testengine.models.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brainmentors.testengine.utils.StatusCode;

@Component
public class TestHelper {
	@Autowired
	TestDAO dao;
public TestResponse addTest(Test test) {
	TestResponse response = dao.addTest(test);
	if(response.getStatusCode().equals(StatusCode.SUCCESS)) {
		int testId = dao.getTestId(test.getName());
		int uid = test.getUid();
		boolean result = dao.addTestMap(testId, uid);
		if(!result) {
			response.setStatusCode(StatusCode.FAIl);
			response.setMessage("Error During Test Mapping");
		}
	
	}
	return response;
	}
}
