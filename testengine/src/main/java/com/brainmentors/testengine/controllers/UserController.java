package com.brainmentors.testengine.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brainmentors.testengine.models.user.IUserService;
import com.brainmentors.testengine.models.user.Student;
import com.brainmentors.testengine.models.user.User;
import com.brainmentors.testengine.models.user.UserInfo;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	private Logger logger = Logger.getLogger(UserController.class);
	
	@GetMapping(path = "/dashboard")
	//@RequestMapping(method =RequestMethod.GET, path="/dashboard")
	public String dashBoard(@RequestParam(value = "tokenId",required = false, defaultValue = "")  String token, HttpSession session) {
		if(session.getId().equals(token)) {
		return "Welcome User You are on DashBoard Page"+token;
		}
		else {
			return "Invalid User to Access DashBoard Page";
		}
	}
	
	@PostMapping(path="/register",consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Student register(@Valid @RequestBody Student student) {
		return student;
	}
	
	//@PostMapping(path="/login",consumes = ,produces=)
	@RequestMapping(method = RequestMethod.POST,path = "/login",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody UserInfo doLogin(@RequestBody User userObject, HttpSession session) {
		//return "U r On Login Page";
//		UserInfo userInfo = new UserInfo();
//		userInfo.setUserid(userObject.getUserid());
//		userInfo.setRoleName("Teacher");
//		userInfo.setMessage("Login SuccessFully");
//		System.out.println("##############User Object is "+userObject);
		//return "{msg:'Hello User U r on Login','user':"+userObject+"}";
		logger.debug("Inside doLogin "+userObject.getUserid());
		UserInfo userInfo = userService.login(userObject);
		logger.debug("After Service call Data is coming  "+userInfo);
		if(userInfo!=null) {
			userInfo.setTokenId(session.getId());
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
