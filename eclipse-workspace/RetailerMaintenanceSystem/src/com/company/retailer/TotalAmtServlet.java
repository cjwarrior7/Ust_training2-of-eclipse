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


@WebServlet("/TotalAmtServlet")
public class TotalAmtServlet extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
			String sid=request.getParameter("id");
		    PrintWriter pw=response.getWriter();
			System.out.println(sid);
			int id=Integer.parseInt(sid);
			 pw.print("<h4 align='center'>TOTAL AMOUNT TO PAY BY YOU GIVEN BELOW THANKS FOR BUYING WITH US</h4>");
			 
				System.out.println("============jdbc===========");
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
							Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
							PreparedStatement pst=con.prepareStatement("Select sum(amount) from product where ret_id=? ");
							pst.setInt(1, id);
							
							ResultSet rs=pst.executeQuery();
							pw.print("<table align='center' border='1'><tr><th>AMOUNT</th> </tr>");
							if (rs.next()) {
								//System.out.println(rs.getLong("amount"));
								pw.print("<tr><td>"+rs.getBigDecimal("sum(amount)")+"</td></tr>");
							}
							pw.print("</table>");
							
						} catch (ClassNotFoundException | SQLException e) {
							e.printStackTrace();
						}
	}

}
