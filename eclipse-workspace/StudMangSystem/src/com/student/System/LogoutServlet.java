package com.student.System;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Cookie[] arr=request.getCookies();
		System.out.println(arr);
		RequestDispatcher rd;
		Cookie ck;
		try{
			ck=arr[0];
			System.out.println(ck.getValue());
			ServletContext context=getServletContext();  
			if((ck!=null)&&(!ck.getValue().equals("")) ) {
				ck=new Cookie("k1", "");
				response.addCookie(ck);
				pw.print("<h1>Logout"+ck.getValue()+"</h1>");
				context.removeAttribute("k2");
				
				rd=request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			else {
				pw.print("PLEASE LOGIN FIRST");
				rd=request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			}
		  }
			catch(NullPointerException e){
				pw.print("PLEASE LOGIN FIRST");
				rd=request.getRequestDispatcher("Login.html");
				rd.include(request, response);
				//pw.print("<br><a href=Register.html>REGISTER HERE</a>");
				//pw.print("<br><a href=Logout.html>LOGOUT HERE</a>");
				//pw.print("<br><a href=Profile.html>CHECK PROFILE HERE</a>");
				//pw.print("<br><a href=AccountSetting.html>MAKE ACCOUNT SETTINGS HERE</a>");
			}
	
	}

}
