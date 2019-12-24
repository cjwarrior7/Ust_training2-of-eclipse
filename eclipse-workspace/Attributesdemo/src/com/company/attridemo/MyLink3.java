package com.company.attridemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyLink3")
public class MyLink3 extends HttpServlet {
	

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ServletContext context = getServletContext();

		String str = (String) context.getAttribute("username");
		if(str==null) {
			pw.print("Hi "+"anonymous");
			}
			else {
				pw.print("Hi "+str);
				}
		System.out.println("********signoff**********");
		context.removeAttribute("username");
	}

}
