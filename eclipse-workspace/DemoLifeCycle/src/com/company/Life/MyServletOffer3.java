package com.company.Life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyServletOffer3 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.print("<h2>MyServletoffer3</h2>");
		
		ServletContext context=getServletContext();
		String co_info=context.getInitParameter("co");
		pw.print("<h2>"+co_info+"</h2>");
		ServletConfig config=getServletConfig();
		String info=config.getInitParameter("key3");
		pw.print("<br>"+ info);
		
	}

}