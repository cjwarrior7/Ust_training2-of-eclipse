package com.ust.onetomanyrel;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyDAO {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session ss=sf.openSession();
		
		//create
//		StudentDTO s1=new StudentDTO();
//		s1.setSname("Rahul");
//		
//		StudentDTO s2=new StudentDTO();
//		s2.setSname("parul");
//		
//		StudentDTO s3=new StudentDTO();
//		s3.setSname("tamil");
//		
//		List<StudentDTO> list=new LinkedList<>();
//		list.add(s1);
//		list.add(s2);
//		list.add(s3);
//		 
//		FacultyDTO f=new FacultyDTO();
//		f.setFname("soniya");
//		f.setSlist(list);
//		
//		ss.save(f);
//		ss.beginTransaction().commit();
		
		//read
//		FacultyDTO f=ss.load(FacultyDTO.class, 1);
//		System.out.println("faculty  "+f.getFname());
//		List<StudentDTO> list=f.getSlist();
//		for (StudentDTO studentDTO : list) {
//			System.out.println(studentDTO.getSname());
//			}
//		}
	
	//update
//		FacultyDTO f=ss.load(FacultyDTO.class, 1);
//		f.setFname(f.getFname()+"Gandhi");
//		List<StudentDTO> list=f.getSlist();
//		for (StudentDTO studentDTO2 : list) {
//			if(studentDTO2.getSname().equals("Rahul")) {
//				studentDTO2.setSname(studentDTO2.getSname()+"Gandhi");
//			
//		}
	
		
		
		ss.close();
		sf.close();

	}

}
