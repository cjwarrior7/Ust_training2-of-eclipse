package com.company.relation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

public class OneToOneDAO {
	public static void main(String[] args) {
		
	
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		EngineDTO engineDTO=new EngineDTO();
		engineDTO.setEngname("ENGINE SWAG");
		CarDTO carDTO=new CarDTO();
		carDTO.setcarname("MG HECTOR");
		carDTO.setEngi(engineDTO);
		ss.save(carDTO);
		ss.beginTransaction().commit();
		ss.close();
		sf.close();
		

	}

}
