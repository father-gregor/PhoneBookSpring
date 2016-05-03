package com.benlinus92.pbook.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PhoneBookDaoImpl implements PhonebookDao {
	@PersistenceContext
	EntityManager em;
	

}
