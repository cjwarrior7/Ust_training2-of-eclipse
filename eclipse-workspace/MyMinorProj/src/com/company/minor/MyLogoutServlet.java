package com.company.minor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyLogoutServlet")
public class MyLogoutServlet extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		ServletContext context=getServletContext();
		String username=(String)context.getAttribute("user");
		String usermobi=(String)context.getAttribute("contact");
		if(username==null && usermobi==null) {
			pw.println("LOGIN PLEASE WITH BELOW LINK<br>");
			pw.println("<a href=login.html>LOGIN HERE</a>");
		}
		else {
			
			context.removeAttribute("name");
			context.removeAttribute("contact");
			pw.print("bye bye sign off performed");
		}
		
	}

}
