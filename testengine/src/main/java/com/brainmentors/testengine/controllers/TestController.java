package com.brainmentors.testengine.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.testengine.models.test.Test;
import com.brainmentors.testengine.models.test.TestResponse;
import com.brainmentors.testengine.models.test.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService service;
	@RequestMapping(path = "/addtest",method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody TestResponse createTest(@RequestBody Test test) {
		test.setCreationDateTime(new Date());
		return service.addTest(test);
		
	}
}
