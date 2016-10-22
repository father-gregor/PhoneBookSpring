package com.benlinus92.pbook.dao;

import java.util.List;

import com.benlinus92.pbook.domains.Entry;
import com.benlinus92.pbook.domains.Profile;
import com.benlinus92.pbook.domains.User;

public interface PhonebookDao {
	public void saveUser(User user);
	public User findUserByUsername(String login);
	public Profile findProfile(String type);
	public List<Entry> getEntry(User user);
	public void createEntry(Entry entry);
	public Entry getSingleEntry(int entryId);
	public void updateEntry(Entry entry);
}
