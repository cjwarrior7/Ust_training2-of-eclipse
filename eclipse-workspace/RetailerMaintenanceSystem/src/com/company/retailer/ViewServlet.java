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


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	
 
 

		// TODO Auto-generated method stub
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
						PreparedStatement pst=con.prepareStatement("select * from product where ret_id=?");
						pst.setInt(1, id);
						
						ResultSet rs=pst.executeQuery();
						pw.print("<table align='center' border='1'><tr><th>Pid</th><th>Orderid</th><th>Pname</th><th>Price</th><th>Quantity</th><th>Amount</th><th>Retailer_id</th> </tr>");
						while (rs.next()) {
							pw.print("<tr><td>"+rs.getInt("pid")+"</td><td>"+rs.getInt("orderid")+"</td> <td>"+rs.getString("pname")+"</td> <td>"+rs.getDouble("price")+"</td><td>"+rs.getInt("quant")+"</td> <td>"+rs.getDouble("amount")+"</td><td>"+rs.getInt("ret_id")+"</td></tr>");
						}
						pw.print("</table>");
						
					} catch (ClassNotFoundException | SQLException e) {
						e.printStackTrace();
					}
			}
	}

	


