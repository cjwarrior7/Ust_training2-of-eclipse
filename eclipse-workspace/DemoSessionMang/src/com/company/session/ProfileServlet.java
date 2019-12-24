package com.company.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Cookie[] arr=request.getCookies();
		Cookie ck=arr[0];	
		if((ck!=null)&&(!ck.getValue().equals(""))) {
			//ck=new Cookie("k1", "");
			//response.addCookie(ck);
			pw.print("<h1>PROFILE PAGE OF"+ck.getValue()+"</h1>");
		}else {
			pw.print("please login");
		}
	
	}

}
