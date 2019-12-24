package com.company.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String val_user="admin";
		String val_pass="1234";
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		PrintWriter pw=response.getWriter();
		RequestDispatcher rd;
		if(val_user.equals(username)&& val_pass.equals(password)) {
			Cookie ck=new Cookie("k1", username);
			response.addCookie(ck);
			rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		}
		else {
			
			pw.print("Login failed");
			System.out.println("reached failed");
			rd=request.getRequestDispatcher("Login.html");
		    rd.include(request, response);
		    
			
		}
			
		
	}

	


}
