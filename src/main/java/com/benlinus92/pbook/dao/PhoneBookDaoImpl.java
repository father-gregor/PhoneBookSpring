package com.benlinus92.pbook.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benlinus92.pbook.domains.Entry;
import com.benlinus92.pbook.domains.Profile;
import com.benlinus92.pbook.domains.User;

@Repository
@Transactional
public class PhoneBookDaoImpl implements PhonebookDao {
	@PersistenceContext
	EntityManager em;
	
	@Override
	public void saveUser(User user) {
		em.persist(user);
	}
	@Override
	public User findUserByUsername(String login) {
		User user = null;
		try {
			Query query = em.createQuery("SELECT r FROM User r WHERE r.login=:login", User.class);
			query.setParameter("login", login);
			user = (User)query.getSingleResult();
		} catch (NoResultException e) {		}
		return user;
	}
	@Override
	public Profile findProfile(String type) {
		Profile profile = null;
		try {
			Query query = em.createQuery("SELECT r FROM Profile r WHERE r.type=:type", Profile.class);
			query.setParameter("type", type);
			profile = (Profile)query.getSingleResult();
		} catch(NoResultException e) {		}
		return profile;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Entry> getEntry(User user) {
		List<Entry> entries = new ArrayList<>();
		try {
			Query query = em.createQuery("SELECT r FROM Entry r WHERE r.user=:userId", Entry.class);
			query.setParameter("userId", user);
			entries = (List<Entry>)query.getResultList();
		} catch(NoResultException e) {
			entries = null;
		}
		return entries;
	}
	@Override
	public void createEntry(Entry entry) {
		em.persist(entry);
	}
	@Override
	public Entry getSingleEntry(int entryId) {
		Entry entry = null;
		try {
			Query query = em.createQuery("SELECT r FROM Entry r WHERE r.entryId=:entryId", Entry.class);
			query.setParameter("entryId", entryId);
			entry = (Entry)query.getSingleResult();
		} catch(NoResultException e) {		}
		return entry;
	}
	@Override
	public void updateEntry(Entry entry) {
		em.merge(entry);
	}
	@Override
	public void deleteEntry(Entry entry) {
		em.remove(entry);
	}
}
