package com.company.minor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name");
		String contact=request.getParameter("user_tel");
		String address=request.getParameter("address");
		String dob=request.getParameter("bday");
		System.out.println("hello");
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        System.out.println("Driver class is load and Registered");
	        System.out.println("Step2(Establish the Connection)");
	        System.out.println("First way:");
	        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
	        PreparedStatement pst = conn.prepareStatement("select * from ust_pro where contact=?");
	        pst.setString(1, contact);
	        ResultSet rs=pst.executeQuery();
	        if(rs.next()) {
	        	pw.print("mobile number already exist");
	        	pw.print("registeration failed");
	        	pw.print("<a href=reg.html>REGISTER Again</a>");
	        	
	        }
	        else {
	            PreparedStatement pst1 = conn.prepareStatement("insert into ust_pro(name,contact,dob,address) values(?,?,?,?)");
				System.out.println("Platform created");
		        System.out.println(name);
		        System.out.println(contact);
		        System.out.println(address);
		        System.out.println(dob);
		        pst1.setString(1, name);
				pst1.setString(2, contact);
				pst1.setString(3, dob);
				pst1.setString(4, address);
				int row_affected= pst1.executeUpdate();
				//System.out.println(result_set.getInt("id"));
				System.out.println("Query Executed");
				System.out.println(row_affected);
				if(row_affected>0) {
				pw.print("REGISTERED SUCCESSFULLY");
				pw.print("\n");
				pw.print("<a href=login.html>LOGIN HERE</a>");
				}
	        	
	        }
	        
	        
	        
	        
	      
			
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
		
		
		
	}

}
