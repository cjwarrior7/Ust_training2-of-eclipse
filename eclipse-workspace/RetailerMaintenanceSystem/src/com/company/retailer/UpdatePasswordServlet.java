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

@WebServlet("/UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		//=========accept value form reg.html==========//
		String sid=request.getParameter("id");
		System.out.println(sid);
		int id=Integer.parseInt(sid);
		String password=request.getParameter("password");
		
		
		
		//============jdbc===========//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
			PreparedStatement pst=con.prepareStatement("update retailer set  password=? where id=?");
			pst.setString(1,password);
			pst.setInt(2, id);
			pst.execute();
			pw.print("<h3>UPDATED SUCCESSFULLY</h3>");
		} catch (ClassNotFoundException | SQLException e) {
			pw.print("<h3>Registration unsuccessful</h3>");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


