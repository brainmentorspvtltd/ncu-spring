package com.brainmentors.apps.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	@RequestMapping("/hello")
	public String sayWelcome(Model model) {
		model.addAttribute("msg", "Hello User");
		return "welcome";
	}
	@RequestMapping("/login")
	public String doLogin(HttpServletRequest request, Model model) {
		String userid = request.getParameter("userid");
		String password = request.getParameter("pwd");
		if(userid.equals(password)) {
		model.addAttribute("msg", "Hello  "+userid);
		}
		else {
			model.addAttribute("msg", "Invalid Userid or Password");
		}
		return "dashboard";
	}
}
