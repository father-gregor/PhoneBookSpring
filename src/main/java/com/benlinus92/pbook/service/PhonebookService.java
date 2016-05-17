package com.benlinus92.pbook.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benlinus92.pbook.domains.Profile;
import com.benlinus92.pbook.domains.User;

@Service("phonebookService")
@Transactional
public interface PhonebookService {
	public boolean addNewUser(User user);
	public User findUserByUsername(String login);
	public List<Profile> getProfiles();
}
