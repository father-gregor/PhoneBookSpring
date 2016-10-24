package com.benlinus92.pbook.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.benlinus92.pbook.domains.PersistentLogin;

@Repository("tokenRepositoryDao")
@Transactional
public class JpaTokenRepositoryImpl implements PersistentTokenRepository {

	@PersistenceContext
	EntityManager em;
	@Override
	public void createNewToken(PersistentRememberMeToken token) {
		PersistentLogin persistentLogin = new PersistentLogin();
		persistentLogin.setUsername(token.getUsername());
		persistentLogin.setSeries(token.getSeries());
		persistentLogin.setToken(token.getTokenValue());
		persistentLogin.setLast_used(token.getDate());
		em.persist(persistentLogin);
	}

	@Override
	public PersistentRememberMeToken getTokenForSeries(String series) {
		try {
			PersistentLogin persLog = this.getPersistentLoginBySeries(series);
			if(persLog != null)
				return new PersistentRememberMeToken(persLog.getUsername(), persLog.getSeries(), persLog.getToken(), persLog.getLast_used());
		} catch(Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public void removeUserTokens(String username) {
		try {
			Query query = em.createQuery("SELECT r FROM PersistentLogin r WHERE r.username=:username", PersistentLogin.class);
			query.setParameter("username", username);
			PersistentLogin persLog = (PersistentLogin)query.getSingleResult();
			if(persLog != null) {
				em.remove(persLog);
			}
		} catch(Exception e) {
			
		}
	}

	@Override
	public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
		PersistentLogin persLog = this.getPersistentLoginBySeries(seriesId);
		persLog.setToken(tokenValue);
		persLog.setLast_used(lastUsed);
	}

	public PersistentLogin getPersistentLoginBySeries(String series) {
		try {
			Query query = em.createQuery("SELECT r FROM PersistentLogin r WHERE r.series=:series", PersistentLogin.class);
			query.setParameter("series", series);
			PersistentLogin persLog= (PersistentLogin)query.getSingleResult();
			if(persLog != null)
				return persLog;
		} catch(Exception e) {
			return null;
		}
		return null;
	}
}
