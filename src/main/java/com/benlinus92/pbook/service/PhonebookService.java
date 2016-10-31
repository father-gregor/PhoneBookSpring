package com.benlinus92.pbook.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benlinus92.pbook.domains.Entry;
import com.benlinus92.pbook.domains.Profile;
import com.benlinus92.pbook.domains.User;

@Service("phonebookService")
@Transactional
public interface PhonebookService {
	public boolean addNewUser(User user);
	public User getUserByUsername(String username);
	public List<Profile> getProfiles();
	public List<Entry> getEntryByUsername(String username);
	public void createEntry(Entry entry, String username);
	public Entry getEntryById(int entryId, String username);
	public void updateEntry(Entry entry);
	public void deleteEntry(int EntryId, String username);
}
