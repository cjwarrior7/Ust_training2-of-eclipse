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


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
				PreparedStatement pst=conn.prepareStatement("select * from student_crud");
			    ResultSet rs=pst.executeQuery();
			    pw.print("<table border=2 align=center ><tr><th>ID</th><th>Email</th><th>Username</th><th>Name</th><th>Password</th><th>Edit</th></tr>");
			    while(rs.next()) {
			    	   pw.println("<tr><td>"+rs.getInt("id")+"</td><td>"+rs.getString("email")+"</td><td>"+rs.getString("username")+"</td><td>"+rs.getString("name") +"</td><td>"+rs.getString("password")+"</td><td><a href='EditServlet?id="+rs.getInt("id")+"'>edit</a></td></tr>");
			    }
			    pw.print("</table>");
				
		    
		    
		    
		    
		    
		    } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				pw.println("unable to fetch"); 
				e.printStackTrace();
			
			
		}
		
	}

	

}
