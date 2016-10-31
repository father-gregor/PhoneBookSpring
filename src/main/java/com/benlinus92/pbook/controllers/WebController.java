package com.benlinus92.pbook.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.benlinus92.pbook.domains.Entry;
import com.benlinus92.pbook.domains.User;
import com.benlinus92.pbook.service.PhonebookService;

@Controller
public class WebController  {

	@Autowired
	PhonebookService service;
	@RequestMapping({
		"/",
		"/register",
		"/auth",
		"/home",
		"/edit-entry/**"
	})
	public String index() {
		System.out.println("===============INDEX============");
		return "/index.html";
		//return "forward:/index.html";
	}

	@RequestMapping(value="/register-user", method=RequestMethod.POST, produces="text/plain")
	public @ResponseBody String createUser(@RequestBody User user) {
		service.addNewUser(user);
		return "/auth";
	}
	@RequestMapping(value="/authenticated", method=RequestMethod.GET)
	public @ResponseBody Map<String, Object> isAuthenticated() {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("user", getPrincipal());
		System.out.println("User is " + getPrincipal());
		return model;
	}
	@RequestMapping(value="/getentry", method=RequestMethod.GET)
	public @ResponseBody List<Entry> getEntry() {
		String username = getPrincipal();
		List<Entry> list = null;
		if(username != null) {
			list = service.getEntryByUsername(username);
			for(Entry en: list) {
				en.setUser(null);
			}
		}
		return list;
	}
	@RequestMapping(value="/newentry", method=RequestMethod.POST, produces="text/plain")
	public @ResponseBody String createEntry(@RequestBody Entry entry) {
		System.out.println(entry.getName());
		String username = getPrincipal();
		if(username != null) {
			service.createEntry(entry, username);
		}
		return "/dashboard";
	}
	@RequestMapping(value="/get-entry-{entryId}", method=RequestMethod.GET)
	public @ResponseBody Entry getEntryForById(@PathVariable int entryId) {
		String username = getPrincipal();
		Entry entry = service.getEntryById(entryId, username);
		if(entry != null)
			entry.setUser(null);
		//else
			//response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return entry;
	}
	@RequestMapping(value="/update-entry", method=RequestMethod.PUT, produces="text/plain")
	public @ResponseBody String updateEntry(@RequestBody Entry entry) {
		if(entry != null) {
			service.updateEntry(entry);
		}
		return "/dashboard";
	}
	@RequestMapping(value="/delete-entry-{entryId}", method=RequestMethod.DELETE, produces="text/plain")
	public @ResponseBody String deleteEntry(@PathVariable int entryId) {
		System.out.println("DELETE ID _ " + entryId);
		String username = getPrincipal();
		service.deleteEntry(entryId, username);
		return "/dashboard";
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public String handleException(Exception e) {
		System.out.println(e.toString());
	    return e.toString();
	}
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} 
		return userName;
	}
}
