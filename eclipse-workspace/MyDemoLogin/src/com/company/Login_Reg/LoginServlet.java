package com.company.Login_Reg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet {

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
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		PrintWriter pw = resp.getWriter();
		pw.print("RESPONSE FROM Login");
		pw.print("\n");
		// String orig_user="admin";
		// String orig_pass="1234";
		// if(orig_user.equals(user)&& orig_pass.equals(pass)) {
		// pw.print("Login is successful");
		// }
		// else {
		// pw.print("Login is failed");
		// }
		try {
			System.out.println("LOGIN");
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("LOAD AND REGISTERED");
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
			System.out.println("ESTABLISH THE CONNECTION");
			PreparedStatement pst = conn.prepareStatement("Select id , name from ust1 where username=? AND password=?");
			System.out.println("Platform created");
            System.out.println(user);
            System.out.println(pass);
			pst.setString(1, user);
			pst.setString(2, pass);
			ResultSet result_set = pst.executeQuery();
			//System.out.println(result_set.getInt("id"));
			System.out.println("Query Executed");
			if (result_set.next()) {
				pw.print("Login successful");
				pw.print("\n");
				pw.print("Hi " + result_set.getString("name"));
			} else {
				pw.print("Login failed");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
