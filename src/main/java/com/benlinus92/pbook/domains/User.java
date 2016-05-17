package com.benlinus92.pbook.domains;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int userId;
	@Column
	@NotNull
	private String login;
	@Column
	@NotNull
	private String password;
	@Column
	@NotNull
	private String fio;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="user_profile",
			joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="profile_id", referencedColumnName="id"))
	private List<Profile> profiles;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFio() {
		return fio;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public List<Profile> getProfiles() {
		return this.profiles;
	}
	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}
}
