package com.company.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Stock_User_info {
	@Id
	@GenericGenerator(name="auto",strategy ="increment")
	@GeneratedValue(generator="auto")
	private int id ;
	private String UserName ;
	private String Password ; 
	private String Email ;
	private String Etype
	;
	public String getEtype() {
		return Etype;
	}
	public void setEtype(String etype) {
		Etype = etype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

}
