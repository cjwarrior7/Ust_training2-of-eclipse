package com.company.gmail;

import java.util.Scanner;

public class ClientGmail {
	  public static void main(String[] args) {
	        System.out.println("***********GMAIL APPLICATION************************");
	        System.out.println("Enter valid option 1 to login or 2 to register proceed");
	        Scanner sc=new Scanner(System.in);
	        String option=sc.next();
	        if(option.equals("1")){
	            System.out.println("**************LOGIN******************");
                System.out.println("enter the email");
	            String email=sc.next();
	            System.out.println("enter the password");
	            String password=sc.next();
	            Accountoperations ac=new Accountoperations(email,password);
	            ac.loginacc();
	        }
	        else if(option.equals("2")){
	            System.out.println("**************SIGN UP******************");
	            System.out.println("enter the username");
	            String username=sc.next();
	            System.out.println("enter the email");
	            String email=sc.next();
	            System.out.println("enter the password");
	            String password=sc.next();
	            Accountoperations ac=new Accountoperations(username,password,email);
	            ac.createacc();
	        }
	        else{
	            System.out.println("enter valid option");
	        }
}
}
