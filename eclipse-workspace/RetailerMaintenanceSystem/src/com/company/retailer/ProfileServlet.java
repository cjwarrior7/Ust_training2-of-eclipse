package com.company.retailer;

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



@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
       

  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html");
			String sid=request.getParameter("id");
		    PrintWriter pw=response.getWriter();
			System.out.println(sid);
			int id=Integer.parseInt(sid);
			
		 pw.print("<h1 align='center'>View Page</h1>");
		 
		//============jdbc===========//
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
					PreparedStatement pst=con.prepareStatement("select * from retailer where id=?");
					pst.setInt(1, id);
					
					ResultSet rs=pst.executeQuery();
					pw.print("<table align='center' border='5'><tr><th>Id</th><th>Rname</th><th>Email</th><th>Password</th> </tr>");
					while (rs.next()) {
						pw.print("<tr><td>"+rs.getInt("id")+"</td><td>"+rs.getString("rname")+"</td> <td>"+rs.getString("email")+"</td><td>"+rs.getString("password")+"</td> </tr>");
					}
					pw.print("</table>");
					
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
	}

	

}
