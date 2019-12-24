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


@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);

		// ============jdbc===========//
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
			PreparedStatement pst = con.prepareStatement("select * from retailer where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			pw.print("<h1 align='center'>Update Page</h1>");
			pw.print("<h4 align='center'>"+
			"<form action='UpdatePasswordServlet' method='post'>"+
			"<input type='hidden' name='id' value='"+rs.getString("id")+"'>"+
			"<input type='password' name='password' value='"+rs.getString("password")+"'><br>"+
			"<input type='submit' value='Update'>"+
			"</form>"+
			"</h4>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
