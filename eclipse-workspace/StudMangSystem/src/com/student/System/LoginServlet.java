package com.student.System;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		//pw.println("IN LOGIN PAGE");
		String username=request.getParameter("username");
		String contact=request.getParameter("user_tel");
		try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver class is load and Registered");
        System.out.println("Step2(Establish the Connection)");
        System.out.println("First way:");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
        PreparedStatement pst = conn.prepareStatement("Select * from studentmg where username=? AND mobno=?");
		System.out.println("Platform created");
        System.out.println(username);
        System.out.println(contact);
		pst.setString(1, username);
		pst.setString(2, contact);
		ResultSet result_set = pst.executeQuery();
		//System.out.println(result_set.getInt("id"));
		System.out.println("Query Executed");
		RequestDispatcher rd;
		if (result_set.next()) {
			System.out.println("inside rs");
			Cookie ck=new Cookie("k1", username);
			response.addCookie(ck);
			System.out.println(ck);
			ServletContext context=getServletContext();  
			context.setAttribute("k2",contact);
			//context.setAttribute("id", result_set.getInt("id"));
			
			pw.println("HI "+ck.getValue());
			rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);			
			//pw.print("<br><a href=/LogoutServlet>LOGOUT HERE</a>");
			//pw.print("<br><a href=/ProfileServlet>CHECK PROFILE HERE</a>");
			//pw.print("<br><a href=/AccountSettingServlet>MAKE ACCOUNT SETTINGS HERE</a>");

			} else {
			pw.print("\n");
			pw.print("Login failed");
			rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			//pw.print("<br><a href=Register.html>REGISTER HERE</a>");
			//pw.print("<br><a href=/LogoutServlet>LOGOUT HERE</a>");
			//pw.print("<br><a href=/ProfileServlet>CHECK PROFILE HERE</a>");
			//pw.print("<br><a href=/AccountSettingServlet>MAKE ACCOUNT SETTINGS HERE</a>");
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
