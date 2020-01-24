package com.company.relation;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class EngineDTO implements Serializable{
	@Id
	@GenericGenerator(name="auto",strategy ="increment")
	@GeneratedValue(generator="auto")
	private int id;
	private String engname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEngname() {
		return engname;
	}
	public void setEngname(String engname) {
		this.engname = engname;
	}
	

}
