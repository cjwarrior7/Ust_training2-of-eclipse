package com.company.crudoperations;

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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

  



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
				PreparedStatement pst=conn.prepareStatement("Select * from student_crud where username=? and password=?");
			
			    pst.setString(1,username);
			    pst.setString(2,password);
			     ResultSet rs = pst.executeQuery();
			     if(rs.next()) {
			    	 pw.print("Login Successfull");
			     }
			     else {
			    	 pw.print("Login failed");
			     }
				
		    
		    
		    } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block 
		    	pw.print("in catch Login failed");
				
				e.printStackTrace();
			
			
		}

	}

}
