package com.company.register;

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


@WebServlet("/YopServlet")
public class YopServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String yop=request.getParameter("yop");
		System.out.println("===========jdbc===========");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
			PreparedStatement pst=con.prepareStatement("select * from register where yop=?");
			pst.setString(1, yop);
		    ResultSet rs =pst.executeQuery();
		    pw.print("<table border=2 align=center ><tr><th>ID</th><th>Email</th><th>Name</th><th>YOP</th><th>Send</th></tr>");
		    while(rs.next()) {
		    	   pw.println("<tr><td>"+rs.getInt("id")+"</td><td>"+rs.getString("email")+"</td><td>"+rs.getString("name")+"</td><td>"+rs.getString("yop")+"</td><td><a href='SendServlet?id="+rs.getInt("id")+"'>send</a></td></tr>");
		    }
		    pw.print("</table>");
		    
		
		    
			
		} catch (ClassNotFoundException | SQLException e) {
			pw.print("<h3>fetch unsuccessful</h3>");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
