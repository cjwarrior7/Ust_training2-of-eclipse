package com.oracle;
import  com.company.*;

public class Oracle implements Connection{
	public void create() {
		System.out.println("Inserting Data into oracle");
		
	}

	@Override
	public void delete() {
		System.out.println("Deleting Data from  oracle");
		
	}

	@Override
	public void read() {
		System.out.println("Reading Data from  oracle");// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Update Data from  oracle");
		
	}

	public Oracle() {
		
		// TODO Auto-generated constructor stub
	}
	

}
