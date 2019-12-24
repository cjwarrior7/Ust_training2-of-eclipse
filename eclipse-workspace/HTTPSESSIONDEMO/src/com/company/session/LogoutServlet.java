package com.company.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	
       


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		request.getRequestDispatcher("link.html").include(request,response);
		HttpSession session=request.getSession(false);
		if(session!=null) {
			pw.println("logout success "+session.getAttribute("user"));
			session.invalidate();
		}
		else {pw.println("login first");
			request.getRequestDispatcher("login.html").include(request,response);
		}
	}

	
	

}