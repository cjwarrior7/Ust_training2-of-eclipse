package com.company.retailer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	
	
		// TODO Auto-generated method stub
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			
			//=========accept value form reg.html==========//
			//String username=request.getParameter("username");
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			
			System.out.println("===========jdbc===========");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
				PreparedStatement pst=con.prepareStatement("insert into retailer(rname,email,password) values(?,?,?)");
				pst.setString(1, name);
				pst.setString(2, email);
				pst.setString(3, password);
				pst.execute();
				pw.print("<h1>Registration Success</h1>");
				
			} catch (ClassNotFoundException | SQLException e) {
				pw.print("<h3>Registration unsuccessful</h3>");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
