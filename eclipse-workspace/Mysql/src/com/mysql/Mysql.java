package com.mysql;
import  com.company.*;


public class Mysql implements Connection{
    
	@Override
	public void create() {
		System.out.println("Inserting Data into mysql");
		
	}

	@Override
	public void delete() {
		System.out.println("Deleting Data from mysql");
		
	}

	@Override
	public void read() {
		System.out.println("Reading Data from mysql");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Update Data from mysql");
		
	}

	public Mysql() {
		
		// TODO Auto-generated constructor stub
	}
	

}
