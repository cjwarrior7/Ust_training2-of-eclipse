package com.company.minor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyProfileServlet")
public class MyProfileServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		ServletContext context=getServletContext();
		String username=(String)context.getAttribute("name");
		String usermobi=(String)context.getAttribute("contact");
		if(username==null && usermobi==null) {
			pw.println("LOGIN PLEASE WITH BELOW LINK<br>");
			pw.println("<a href=login.html>LOGIN HERE</a>");
		}
		else {
			try {
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        System.out.println("Driver class is load and Registered");
		        System.out.println("Step2(Establish the Connection)");
		        System.out.println("First way:");
		        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
		        PreparedStatement pst = conn.prepareStatement("Select * from ust_pro where name=? AND contact=?");
				System.out.println("Platform created");
		        System.out.println(username);
		        System.out.println(usermobi);
				pst.setString(1, username);
				pst.setString(2, usermobi);
				ResultSet result_set = pst.executeQuery();
				//System.out.println(result_set.getInt("id"));
				System.out.println("Query Executed");
				if (result_set.next()) {
					pw.print("ACCOUNT INFO:");
					pw.print("\n");
					pw.println("HI "+result_set.getString("name"));
					pw.println(result_set.getString("contact"));
					pw.println(result_set.getString("address"));
					pw.println(result_set.getString("dob"));
					
					//ServletContext context=getServletContext();
					//context.setAttribute("name", name);
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

}
