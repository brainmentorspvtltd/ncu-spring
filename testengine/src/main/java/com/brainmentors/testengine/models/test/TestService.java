package com.brainmentors.testengine.models.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmentors.testengine.utils.StatusCode;

@Service
public class TestService {
	@Autowired
	TestHelper helper;
	public TestResponse addTest(Test test) {
		TestResponse response = helper.addTest(test);
		return response;
	}
}

