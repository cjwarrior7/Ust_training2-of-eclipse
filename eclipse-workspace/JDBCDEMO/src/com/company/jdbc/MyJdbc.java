package com.company.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;



public class MyJdbc {
	public static void main(String[] args) {
		System.out.println("**********Step1(Static way)****************");
		Driver d;
		try {
			d=new Driver();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  System.out.println("**********Step1(Dynamic way)****************");
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver class is load and Registered");
	            System.out.println("Step2(Establish the Connection)");
	            System.out.println("First way:");
	            DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
	            System.out.println("Second way:");
	            final String url="jdbc:mysql://localhost:3306?";
	            final String user="root";
	            final String password="root";
	            DriverManager.getConnection(url,user,password);
	            System.out.println("Third Way:");
	            FileReader fileReader=new FileReader("Config/dbcredentials.properties");
	            Properties pr=new Properties();
	            pr.load(fileReader);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch(FileNotFoundException e){
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }


	}

}
