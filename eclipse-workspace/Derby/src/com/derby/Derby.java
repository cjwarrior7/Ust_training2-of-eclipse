package com.derby;

import com.company.*;

public class Derby implements Connection {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		System.out.println("Inserting Data into Derby");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Deleting Data from Derby");
		
		
}

	@Override
	public void read(){
		// TODO Auto-generated method stub
		 System.out.println("Reading Data from  Derby");
		
		}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Updating Data from  Derby");
		
	}

	public Derby() {
		
		// TODO Auto-generated constructor stub
	}
	
	

} 
