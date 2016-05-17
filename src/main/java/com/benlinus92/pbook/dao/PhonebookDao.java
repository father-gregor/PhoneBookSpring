package com.benlinus92.pbook.dao;

import java.util.List;

import com.benlinus92.pbook.domains.Profile;
import com.benlinus92.pbook.domains.User;

public interface PhonebookDao {
	public void saveUser(User user);
	public User findUserByUsername(String login);
	public Profile findProfile(String type);
}
