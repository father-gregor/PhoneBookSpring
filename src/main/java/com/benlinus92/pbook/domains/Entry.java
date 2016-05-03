package com.benlinus92.pbook.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="entry")
public class Entry {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int entryId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	@Column
	@NotNull
	private String surname;
	@Column 
	@NotNull
	private String name;
	@Column(name="father_name")
	@NotNull
	private String fatherName;
	@Column(name="mobile_number")
	@NotNull
	private String mobileNumb;
	@Column(name="home_number")
	private String homeNumb;
	@Column
	private String address;
	@Column
	private String email;
	public int getEntryId() {
		return entryId;
	}
	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMobileNumb() {
		return mobileNumb;
	}
	public void setMobileNumb(String mobileNumb) {
		this.mobileNumb = mobileNumb;
	}
	public String getHomeNumb() {
		return homeNumb;
	}
	public void setHomeNumb(String homeNumb) {
		this.homeNumb = homeNumb;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
