package com.java.demohibernate;



import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
	public static void main(String[] args) {
		Configuration cfg =new Configuration();
		cfg.configure();
SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
//	StudentDTO dto=new StudentDTO();
//		dto.setName("ram");
//		dto.setStream("cs");
//		dto.setPercentage(65.3);//ss.save(dto);
		//Transaction tx=ss.beginTransaction();
		//tx.commit();
		//read
		//StudentDTO dto=ss.load(StudentDTO.class, 1);
		//System.out.println(dto.getId()+dto.getName()+dto.getPercentage()+dto.getStream());
		//update
//		StudentDTO dto=ss.load(StudentDTO.class, 1);
//		dto.setPercentage(68);
//		ss.update(dto);
//		Transaction tx=ss.beginTransaction();
//		tx.commit();
		//delete
//		StudentDTO dto=ss.load(StudentDTO.class, 1);
//		ss.delete(dto);
//		Transaction tx=ss.beginTransaction();
//		tx.commit();
		//ss.save(dto);
		//Transaction tx=ss.beginTransaction();
		//tx.commit();
		
		ss.close();
		sf.close();
		
		
	}

}
