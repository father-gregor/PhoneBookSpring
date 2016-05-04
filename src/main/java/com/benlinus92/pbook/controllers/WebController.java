package com.benlinus92.pbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping({
		"/",
		"/register",
		"/home"
	})
	public String index() {
		return "index";
		//return "forward:/index.html";
	}
}
