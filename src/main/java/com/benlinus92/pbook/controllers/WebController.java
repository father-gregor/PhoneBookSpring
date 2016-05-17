package com.benlinus92.pbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.benlinus92.pbook.domains.User;
import com.benlinus92.pbook.service.PhonebookService;

@Controller
public class WebController {

	@Autowired
	PhonebookService service;
	@RequestMapping({
		"/",
		"/register",
		"/auth",
		"/home"
	})
	public String index() {
		System.out.println("===============INDEX============");
		return "index";
		//return "forward:/index.html";
	}
	@RequestMapping(value="/register-user", method=RequestMethod.POST, produces="text/plain")
	public @ResponseBody String createUser(@RequestBody User user) {
		System.out.println("USER TRANSMITTED");
		service.addNewUser(user);
		return "/auth";
	}
}
