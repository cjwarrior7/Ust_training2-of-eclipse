package com.company.attridemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MyLink1")
public class Mylink1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		ServletContext context=getServletContext();
		
		String str=(String)context.getAttribute("username");//type casing
		System.out.println(str);
		if(str==null) {
			pw.print("Hi "+"anonymous");
			}
			else {
				pw.print("Hi "+str);
				}
		
		
	}

}
