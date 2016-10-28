package com.benlinus92.pbook.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

	private static final String PATH = "/error";
	@RequestMapping(value = PATH)
	public String error(HttpServletRequest req) {
		Integer status = (Integer)req.getAttribute("javax.servlet.error.status_code");
		System.out.println(status.intValue());
		return "/404.html";
	}
	
	@Override
	public String getErrorPath() {
		return PATH;
	}

}
