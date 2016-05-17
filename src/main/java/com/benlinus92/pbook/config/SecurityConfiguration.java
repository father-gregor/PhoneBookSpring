package com.benlinus92.pbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.benlinus92.pbook.service.PhonebookService;
import com.benlinus92.pbook.service.PhonebookServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("appUserDetailsService")
	UserDetailsService service;
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/home", "/register", "/auth").permitAll()
		.and().formLogin().loginPage("/auth")
		.usernameParameter("login").passwordParameter("pass")
		.and().exceptionHandling().accessDeniedPage("/")
		.and().csrf().disable();
	}
}
