package com.company.spring.daolayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.spring.model.Stock;
@Component
public class MyDaoImp implements MyDao{
	@Autowired
    SessionFactory sf;
	public void addproduct(Stock dto) {
		// TODO Auto-generated method stub
		System.out.println("Inside dao");
		Session ss=sf.openSession();
		ss.save(dto);
		ss.beginTransaction().commit();
		ss.close();
		
		
	}
}
