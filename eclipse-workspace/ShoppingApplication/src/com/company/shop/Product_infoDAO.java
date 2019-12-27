package com.company.shop;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Product_infoDAO {
	public static void main(String[] args) {
		
	
	Configuration cfg=new Configuration();
	cfg.configure();
	SessionFactory sf=cfg.buildSessionFactory();
	Session ss=sf.openSession();
	Scanner sc=new Scanner(System.in);
	
	Product_info dto=new Product_info();
	dto.setProduct_Name("Recliner");
	dto.setProduct_Cost(20000);
	dto.setNumber_ofProducts(5);
	dto.setProduct_Color("BLACK");
	ss.save(dto);
	ss.beginTransaction().commit();
	System.out.println("*********************PRODUCT INSERTED******************************");
	System.out.println("1.SHOW ITEMS");
	System.out.println("2.SEARCH ITEMS");
	System.out.println("ENTER VALID OPTION");
	int options=sc.nextInt();
	
	
	

	switch(options){
	case 1:
		ProductOper.showitem(ss);
		break;
	case 2:
		ProductOper.searchitem(ss);
		break;
		
	default:System.out.println("INVALID");
	}
	ss.close();
	sf.close();
	
	
	
	
}
}
