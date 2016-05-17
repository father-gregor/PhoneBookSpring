package com.benlinus92.pbook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.benlinus92.pbook.domains.Profile;
import com.benlinus92.pbook.domains.User;

@Service("appUserDetailsService")
public class AppUserDetailsService implements UserDetailsService {
	@Autowired
	private PhonebookService service;
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		User user = service.findUserByUsername(login);
		if(user == null) {
			throw new UsernameNotFoundException("User not found: " + login);
		}
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), 
				true, true, true, true, getGrantedAuthorities(user));
		return userDetails;
	}
	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		for(Profile up: user.getProfiles()) {
			auth.add(new SimpleGrantedAuthority(up.getType()));
		}
		return auth;
	}
}
