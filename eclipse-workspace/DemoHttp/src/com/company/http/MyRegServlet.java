package com.company.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/MyRegServlet")
public class MyRegServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		String val_user="admin";
		String val_pass="1234";
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		PrintWriter pw=resp.getWriter();
		if(val_user.equals(username)&& val_pass.equals(password)) {
			pw.print("login successfull");
		}
		else {
			pw.print("login failed");
		}
			
		
	}

}
