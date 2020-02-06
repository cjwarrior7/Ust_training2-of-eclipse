package com.company.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Addcart {
@Id
@GenericGenerator(name="auto",strategy ="increment")
@GeneratedValue(generator="auto")	
int id;
String Pname;
int quant_pur;
double price;
double gst;
double total_money;
String pur_email;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPname() {
	return Pname;
}
public void setPname(String pname) {
	Pname = pname;
}
public int getQuant_pur() {
	return quant_pur;
}
public void setQuant_pur(int quant_pur) {
	this.quant_pur = quant_pur;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getGst() {
	return gst;
}
public void setGst(double gst) {
	this.gst = gst;
}
public double getTotal_money() {
	return total_money;
}
public void setTotal_money(double total_money) {
	this.total_money = total_money;
}
public String getPur_email() {
	return pur_email;
}
public void setPur_email(String pur_email) {
	this.pur_email = pur_email;
}

}
