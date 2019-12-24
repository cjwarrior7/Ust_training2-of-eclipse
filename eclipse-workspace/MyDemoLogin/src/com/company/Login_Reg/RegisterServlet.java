package com.company.Login_Reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class RegisterServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		int db_age = Integer.parseInt(age);
		String stream = req.getParameter("stream");
		String contact = req.getParameter("contact");

		String yop = req.getParameter("yop");
		int db_yop = Integer.parseInt(yop);
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter pw = res.getWriter();
		pw.print("Register Page");
		pw.print("\n");
		pw.print("Register Successful");
		pw.print("\n");
		pw.print("name:" + name);
		pw.print("\n");
		pw.print("age:" + age);
		pw.print("\n");
		pw.print("stream:" + stream);
		pw.print("\n");
		pw.print("contact:" + contact);
		pw.print("\n");
		pw.print("yop:" + yop);
		pw.print("\n");
		System.out.println("************************************");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("LOAD AND REGISTERED");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
			System.out.println("ESTABLISH THE CONNECTION");
			PreparedStatement pst = conn.prepareStatement(
					"Insert into ust1(name,yop,stream,contact,age,username,password) value(?,?,?,?,?,?,?)");
			System.out.println("Platform created");
			pst.setString(1, name);
			pst.setInt(2, db_yop);
			pst.setString(3, stream);
			pst.setString(4, contact);
			pst.setInt(5, db_age);
			pst.setString(6, username);
			pst.setString(7, password);
			int rows_affected = pst.executeUpdate();
			System.out.println(rows_affected);
			System.out.println("Query Executed");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
