package com.benlinus92.pbook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
}
