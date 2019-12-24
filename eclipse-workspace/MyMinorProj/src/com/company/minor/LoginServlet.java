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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("IN LOGIN PAGE");
		String name=request.getParameter("name");
		String contact=request.getParameter("user_tel");
		try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver class is load and Registered");
        System.out.println("Step2(Establish the Connection)");
        System.out.println("First way:");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
        PreparedStatement pst = conn.prepareStatement("Select * from ust_pro where name=? AND contact=?");
		System.out.println("Platform created");
        System.out.println(name);
        System.out.println(contact);
		pst.setString(1, name);
		pst.setString(2, contact);
		ResultSet result_set = pst.executeQuery();
		//System.out.println(result_set.getInt("id"));
		System.out.println("Query Executed");
		if (result_set.next()) {
			pw.print("Login successful");
			pw.print("\n");
			pw.print("\n");
			ServletContext context=getServletContext();
			context.setAttribute("name", name);
			context.setAttribute("contact", contact);
			
			} else {
			pw.print("\n");
			pw.print("Login failed");
			pw.print("\n");
			pw.print("<a href=reg.html>REGISTER HERE</a>");
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
