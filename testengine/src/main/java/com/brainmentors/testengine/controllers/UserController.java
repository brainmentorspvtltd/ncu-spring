package com.brainmentors.testengine.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.brainmentors.testengine.utils.Lang;
//import com.brainmentors.testengine.utils.Mail;
import com.brainmentors.testengine.utils.MessageBundle;

@RestController
public class UserController implements Lang {
//	@Autowired
//	private Mail mail;
	@Autowired
	private MessageBundle messageBundle;
	
//	@Autowired
//	private MessageSource messageSource;

	@Autowired
	private IUserService userService;
	private Logger logger = Logger.getLogger(UserController.class);
	
	
	
	
	
//	public MessageSource getMessageSource() {
//		return messageSource;
//	}
//
//	public void setMessageSource(MessageSource messageSource) {
//		this.messageSource = messageSource;
//	}
	
	

	@GetMapping(path = "/allstudents",produces = "text/plain;charset=utf8")
	//@RequestMapping(method =RequestMethod.GET, path="/dashboard")
	public String allStudentsInfo(HttpServletRequest request, HttpSession session) {
		
		String msg = "";
		String token = request.getHeader("AUTH-TOKEN");
		System.out.println("All Students Token is "+token);
		messageBundle.setLang(ENGLISH);
		System.out.println("Token is "+token+" Session is "+session.getId());
		if(session.getId().equals(token)) {
			msg = messageBundle.getMessage("user.welcome.msg");
			//msg= messageSource.getMessage("user.welcome.msg", null, null, new Locale("hi"));
			//return "Welcome User You are on DashBoard Page"+token;
		}
		else {
			msg = messageBundle.getMessage("user.welcome.errormsg");
			//msg= messageSource.getMessage("user.welcome.errormsg", null, null, new Locale("hi"));
			//return "Invalid User to Access DashBoard Page";
		}
		return msg;
	}

	@GetMapping(path = "/alltest",produces = "text/plain;charset=utf8")
	//@RequestMapping(method =RequestMethod.GET, path="/dashboard")
	public String dashBoard(@RequestParam(value = "tokenId",required = false, defaultValue = "")  String token, HttpSession session) {
		System.out.println("Inside All Test "+token);
		String msg = "";
		messageBundle.setLang(ENGLISH);
		System.out.println("Token is "+token+" Session is "+session.getId());
		if(session.getId().equals(token)) {
			msg = messageBundle.getMessage("user.welcome.msg");
			//msg= messageSource.getMessage("user.welcome.msg", null, null, new Locale("hi"));
			//return "Welcome User You are on DashBoard Page"+token;
		}
		else {
			msg = messageBundle.getMessage("user.welcome.errormsg");
			//msg= messageSource.getMessage("user.welcome.errormsg", null, null, new Locale("hi"));
			//return "Invalid User to Access DashBoard Page";
		}
		return msg;
	}
	
	@PostMapping(path="/register",consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Student register(@Valid @RequestBody Student student) {
		return student;
	}
	
	//@PostMapping(path="/login",consumes = ,produces=)
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,path = "/login",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody UserInfo doLogin(@RequestBody User userObject, HttpSession session) {
		System.out.println("DO Login "+userObject);
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
			System.out.println(":::::: Token Generated on Server "+session.getId());
			userInfo.setMessage("Login SuccessFully");
			//boolean result = mail.sendMail("edumaker3@gmail.com", "amit.shashi.srivastava@gmail.com", "Hello", "Test Mail");
			//System.out.println(result?"Mail Send It ":"Not Send It");
		}
		else {
			userInfo = new UserInfo();
			userInfo.setMessage("Invalid Userid or Password");
		}
		logger.debug("Ending Login "+userInfo);
		return userInfo;
	}
	@RequestMapping(method = RequestMethod.GET,path = "/register")
	public String doRegister() {
		return "U r On Register Page";
	}
}
