package com.company.retailer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	
	
		// TODO Auto-generated method stub
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			
			//=========accept value form login.html==========//
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			RequestDispatcher rd;
			
			System.out.println("============jdbc===========");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
				PreparedStatement pst=con.prepareStatement("select* from retailer where email=? and password=?");
				
				pst.setString(1, email);
				pst.setString(2, password);
				ResultSet rs=pst.executeQuery();
				if (rs.next()) {
					HttpSession session=request.getSession();
				    session.setAttribute("email", email);
					pw.print("<h1>Login Successfull</h1>");
					pw.print("<h2>WELCOME</h2>");
					pw.print("<h3>HI "+rs.getString("rname")+"</h3>");
					pw.print("<a href='EditServlet?id="+rs.getInt("id")+"'>UPDATE_PASSWORD</a>");
					pw.println("<br>");
					pw.print("<a href='ViewServlet?id="+rs.getInt("id")+"'>VIEW_ORDERS</a>");
					pw.println("<br>");
					pw.print("<a href='ProfileServlet?id="+rs.getInt("id")+"'>MY_PROFILE</a>");
					pw.println("<br>");
					pw.print("<a href='TotalAmtServlet?id="+rs.getInt("id")+"'>TOTAL_AMOUNT</a>");
					pw.println("<br>");
					pw.print("<a href='LogoutServlet'>LOGOUT</a>");
					pw.println("<br>");
					rd=request.getRequestDispatcher("search.html");
					rd.include(request, response);
					
					
				} else {
					pw.print("<h1>Login failed</h1>");
					rd=request.getRequestDispatcher("Login.html");
					rd.include(request, response);
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}

