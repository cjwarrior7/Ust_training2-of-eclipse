package com.ust.manytomany;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyDAO {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		CustomerDTO cdto=new CustomerDTO();
		cdto.setCname("aman");
		cdto.setCtype("male");
		
		CustomerDTO cdto1=new CustomerDTO();
		cdto1.setCname("amandeep");
		cdto1.setCtype("female");
		
		List<CustomerDTO> lCustomer=new LinkedList<CustomerDTO>();
		lCustomer.add(cdto);
		lCustomer.add(cdto1);
		
		VenderDTO vdto=new VenderDTO();
		vdto.setVname("Amazon");
		vdto.setVtype("E-commerse");
		vdto.setLcustomer(lCustomer);
		
//		VenderDTO v1=new VenderDTO();
//		v1.setVname("snapdeal");
//		v1.setVtype("E.com");
//		
//
//		VenderDTO v2=new VenderDTO();
//		v1.setVname("flipkart");
//		v1.setVtype("E.com");
//		
//		List<VenderDTO> list=new LinkedList<>();
//		list.add(v1);
//		list.add(v2);
//		
//		CustomerDTO c4=new CustomerDTO();
//		c4.setCname("alok");
//		c4.setCtype("tiktok");
//		c4.setLvenders(list);
		
		//ss.save(c4);
		ss.save(vdto);
		//ss.save(list);
		
		Transaction tx=ss.beginTransaction();
		tx.commit();
		ss.close();
		sf.close();
		

	}

}
