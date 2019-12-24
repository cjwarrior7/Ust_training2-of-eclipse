package com.company.crudoperations;

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


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String sid=request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
				PreparedStatement pst=conn.prepareStatement("update student_crud set name=?, username=? , password=? ,email=? where set id=?");
				pst.setString(1,name);
				pst.setString(2,username);
				pst.setString(3, password);
				pst.setString(4, email);
				pst.setInt(5, id);
				pst.execute();
				response.sendRedirect("ViewServlet");
				
	} catch (ClassNotFoundException | SQLException  | NullPointerException e) {
		// TODO Auto-generated catch block
		pw.println("update  failed"); 
		e.printStackTrace();
		e.getMessage();

}
	}

}
