package com.brainmentors.testengine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.testengine.models.user.IUserService;
import com.brainmentors.testengine.models.user.User;
import com.brainmentors.testengine.models.user.UserInfo;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping(method = RequestMethod.POST,path = "/login",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody UserInfo doLogin(@RequestBody User userObject) {
		//return "U r On Login Page";
//		UserInfo userInfo = new UserInfo();
//		userInfo.setUserid(userObject.getUserid());
//		userInfo.setRoleName("Teacher");
//		userInfo.setMessage("Login SuccessFully");
//		System.out.println("##############User Object is "+userObject);
		//return "{msg:'Hello User U r on Login','user':"+userObject+"}";
		UserInfo userInfo = userService.login(userObject);
		if(userInfo!=null) {
			userInfo.setMessage("Login SuccessFully");
		}
		else {
			userInfo = new UserInfo();
			userInfo.setMessage("Invalid Userid or Password");
		}
		return userInfo;
	}
	@RequestMapping(method = RequestMethod.GET,path = "/register")
	public String doRegister() {
		return "U r On Register Page";
	}
}
