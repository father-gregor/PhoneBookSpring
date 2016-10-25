package com.benlinus92.pbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benlinus92.pbook.dao.PhonebookDao;
import com.benlinus92.pbook.domains.Entry;
import com.benlinus92.pbook.domains.Profile;
import com.benlinus92.pbook.domains.User;

@Service("phonebookService")
@Transactional
public class PhonebookServiceImpl implements PhonebookService {

	@Autowired
	public PhonebookDao dao;
	@Autowired
	public PasswordEncoder encoder;
	@Override
	public boolean addNewUser(User user) {
		if(dao.findUserByUsername(user.getLogin()) == null) {
			user.setPassword(encoder.encode(user.getPassword()));
			user.setProfiles(getProfiles());
			dao.saveUser(user);
			return true;
		}
		return false;
	}
	@Override
	public User findUserByUsername(String username) {
		return dao.findUserByUsername(username);
	}
	@Override
	public List<Profile> getProfiles() {
		List<Profile> auth = new ArrayList<>();
		auth.add(dao.findProfile("USER"));
		return auth;
	}
	@Override
	public List<Entry> getEntryByUsername(String username) {
		User user = this.findUserByUsername(username);
		if(user != null) {
			return dao.getEntry(user);
		} else {
			return null;
		}
	}
	@Override
	public void createEntry(Entry entry, String username) {
		entry.setUser(this.findUserByUsername(username));
		dao.createEntry(entry);
	}
	@Override
	public Entry getEntryById(int entryId, String username) {
		User user = this.findUserByUsername(username);
		Entry entry = dao.getSingleEntry(entryId);
		if(entry.getUser().getUserId() == user.getUserId())
			return entry;
		return null;
	}
	@Override
	public void updateEntry(Entry entry) {
		Entry tempEntry = dao.getSingleEntry(entry.getEntryId());
		entry.setUser(tempEntry.getUser());
		dao.updateEntry(entry);
	}
	@Override
	public void deleteEntry(int entryId, String username) {
		Entry entry = this.getEntryById(entryId, username);
		if(entry != null)
			dao.deleteEntry(entry);
	}
}
