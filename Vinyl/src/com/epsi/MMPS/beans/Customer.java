package com.epsi.MMPS.beans;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable{
	private int customerId;
	private String firstname;
	private String lastname;
	private String mail;
	private Date birthDate;
	private String address;
	private String login;
	private String password;
	
	public Customer() {
		super();
	}
	public Customer(int customerId, String firstname, String lastname,
			String mail, Date birthDate, String address, String login,
			String password) {
		super();
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.birthDate = birthDate;
		this.address = address;
		this.login = login;
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	
}
