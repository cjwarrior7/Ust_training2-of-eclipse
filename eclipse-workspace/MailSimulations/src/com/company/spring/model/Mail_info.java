package com.company.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Mail_info {
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int id;
	private String Form_id;
	private String To_id;
	private String Subject;
	private String Body;
	private String Status;

	public String getBody() {
		return Body;
	}

	public void setBody(String body) {
		Body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getForm_id() {
		return Form_id;
	}

	public void setForm_id(String form_id) {
		Form_id = form_id;
	}

	public String getTo_id() {
		return To_id;
	}

	public void setTo_id(String to_id) {
		To_id = to_id;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
