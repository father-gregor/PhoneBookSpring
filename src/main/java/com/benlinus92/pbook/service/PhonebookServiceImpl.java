package com.benlinus92.pbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benlinus92.pbook.dao.PhonebookDao;
import com.benlinus92.pbook.domains.Profile;
import com.benlinus92.pbook.domains.User;

@Service("phonebookService")
@Transactional
public class PhonebookServiceImpl implements PhonebookService {

	@Autowired
	public PhonebookDao dao;
	@Override
	public boolean addNewUser(User user) {
		if(dao.findUserByUsername(user.getLogin()) == null) {
			user.setProfiles(getProfiles());
			dao.saveUser(user);
			return true;
		}
		return false;
	}
	@Override
	public User findUserByUsername(String login) {
		return dao.findUserByUsername(login);
	}
	@Override
	public List<Profile> getProfiles() {
		List<Profile> auth = new ArrayList<>();
		auth.add(dao.findProfile("USER"));
		return auth;
	}
}
