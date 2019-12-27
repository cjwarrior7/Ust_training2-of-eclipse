package com.company.relation;

import java.io.Serializable;
import java.util.Scanner;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class CarDTO  implements Serializable{
	@Id
	@GenericGenerator(name="auto",strategy ="increment")
	@GeneratedValue(generator="auto")
	
	private int id;
	private String cname;
	@OneToOne(cascade = CascadeType.ALL)
	private EngineDTO engi;
	public EngineDTO getEngi() {
		return engi;
	}
	public void setEngi(EngineDTO engi) {
		this.engi = engi;
	}
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getcarname() {
		return cname;
	}
	public void setcarname(String cname) {
		this.cname = cname;
	}
	
	
	

}
