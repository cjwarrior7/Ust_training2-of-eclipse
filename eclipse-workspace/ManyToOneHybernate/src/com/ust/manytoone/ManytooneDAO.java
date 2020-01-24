package com.ust.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManytooneDAO {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		CompanyDTO cdto=new CompanyDTO();
		cdto.setCname("ust");
		cdto.setType("software company");
		
		EmployeeDTO edto1=new EmployeeDTO();
		edto1.setEname("Ashish");
		edto1.setEsal(20000);
		edto1.setCdto(cdto);
		
		EmployeeDTO edto2=new EmployeeDTO();
		edto2.setEname("Asif");
		edto2.setEsal(20000);
		edto2.setCdto(cdto);
		
		EmployeeDTO edto3=new EmployeeDTO();
		edto3.setEname("yogesh");
		edto3.setEsal(20000);
		edto3.setCdto(cdto);
		
		ss.save(edto1);
		ss.save(edto2);
		ss.save(edto3);
		
		Transaction tx=ss.beginTransaction();
		tx.commit();
		ss.close();
		sf.close();
	

	}

}
