package com.student.System;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.exceptions.DataConversionException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		// int db_age = Integer.parseInt(age);
		String contact = request.getParameter("contact");
		// String yop = request.getParameter("yop");
		// int db_yop = Integer.parseInt(yop);
		String username = request.getParameter("username");
		// String password = request.getParameter("password");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd;
		if (contact.length() == 10 && name.length() != 0 && address.length() != 0 && username.length() != 0) {
			System.out.print("The student contact is valid you entered is valid");

			Random rand = new Random();
			String abc = "ABCD";
			char grade = abc.charAt(rand.nextInt(abc.length()));
			System.out.println("************************************");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver class is load and Registered");
				System.out.println("Step2(Establish the Connection)");
				System.out.println("First way:");
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
				PreparedStatement pst = conn.prepareStatement("Select * from studentmg where mobno=?");
				System.out.println("Platform created");
				//System.out.println(username);
				System.out.println(contact);
				//pst.setString(1, username);
				pst.setString(1, contact);
				ResultSet rs = pst.executeQuery();
				System.out.println(rs);
				if (rs.next()) {
					System.out.println("inside of rs.next()");
					pw.println("contact and username already exist register with another contact and username");
					rd = request.getRequestDispatcher("Register.html");
					rd.include(request, response);
					System.out.println("inside if of rs.next()");
					Connection conn1 = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
					System.out.println("ESTABLISH THE CONNECTION");
					PreparedStatement pst1 = conn1.prepareStatement(
							"Insert into studentmg(sname,address,result,mobno,username) value(?,?,?,?,?)");
					System.out.println("Platform created");
					pst1.setString(1, name);
					pst1.setString(2, address);
					pst1.setString(3, grade + "");
					pst1.setString(4, contact);
					pst1.setString(5, username);
					int rows_affected = pst1.executeUpdate();
					System.out.println(rows_affected);
					System.out.println("Query Executed");
					if (rows_affected > 0) {
						pw.println("congrats you are successfully registered");
						rd = request.getRequestDispatcher("Login.html");

						ServletContext context = getServletContext();
						context.setAttribute("name", name);
						context.setAttribute("address", address);
						rd.include(request, response);

					}

				}

				else {
					System.out.println("out of rs.next()");

					Connection conn1 = DriverManager
							.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
					System.out.println("ESTABLISH THE CONNECTION");
					PreparedStatement pst1 = conn1.prepareStatement(
							"Insert into studentmg(sname,address,result,mobno,username) value(?,?,?,?,?)");
					System.out.println("Platform created");
					pst1.setString(1, name);
					pst1.setString(2, address);
					pst1.setString(3, grade + "");
					pst1.setString(4, contact);
					pst1.setString(5, username);
					int rows_affected = pst1.executeUpdate();
					
					System.out.println(rows_affected);
					System.out.println("Query Executed");
					if (rows_affected > 0) {
						pw.println("congrats you are successfully registered");
						rd = request.getRequestDispatcher("Login.html");

						ServletContext context = getServletContext();
						context.setAttribute("name", name);
						context.setAttribute("address", address);
						rd.include(request, response);

					}
				}

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e ) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		} else {
			pw.print(
					"incorrect digits entered correct 10 digits of mobile number and fill all the fields correctly and mandatory");
			rd = request.getRequestDispatcher("Register.html");
			rd.include(request, response);
		}
	}
}
