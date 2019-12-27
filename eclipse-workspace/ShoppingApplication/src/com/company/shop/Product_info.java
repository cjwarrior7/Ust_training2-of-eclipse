package com.company.shop;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity



public class Product_info {
	
	@Id
	@GenericGenerator(name="auto",strategy ="increment")
	@GeneratedValue(generator="auto")
	 
	 private int Product_ID;
	
	 private String Product_Name;
	
	 private Double Product_Cost;
	
	 private String Product_Color;
	 
	 private String Description;
	 private int Number_ofProducts;
	public int getProduct_ID() {
		return Product_ID;
	}
	public void setProduct_ID(int product_ID) {
		Product_ID = product_ID;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public Double getProduct_Cost() {
		return Product_Cost;
	}
	public void setProduct_Cost(double product_cost) {
		Product_Cost = product_cost;
	}
	public String getProduct_Color() {
		return Product_Color;
	}
	public void setProduct_Color(String product_Color) {
		Product_Color = product_Color;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getNumber_ofProducts() {
		return Number_ofProducts;
	}
	public void setNumber_ofProducts(int number_ofProducts) {
		Number_ofProducts = number_ofProducts;
	}
	 
	

}
