package com.company.spring.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ModelDTO {
@Id
@GenericGenerator(name="auto",strategy ="increment")
@GeneratedValue(generator="auto")
private int id ;	
private String Name ;
private String Password ; 
private String Address ;
private String Email ;
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}

}
