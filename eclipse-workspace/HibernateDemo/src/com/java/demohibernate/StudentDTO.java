package com.java.demohibernate;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.*;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class StudentDTO implements Serializable {
@Id
@GenericGenerator(name="auto",strategy ="increment")
@GeneratedValue(generator="auto")
@Column(name="student_id")

private int id;
@Column(name="student_name")
private String name;
@Column(name="student_percentage")
private double percentage;
@Column(name="student_stream")
private String stream;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPercentage() {
	return percentage;
}
public void setPercentage(double percentage) {
	this.percentage = percentage;
}
public String getStream() {
	return stream;
}
public void setStream(String stream) {
	this.stream = stream;
}

}
