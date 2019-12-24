package com.company.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		if(username.equals("admin")&&password.equals("1234")) 
		{   HttpSession session=request.getSession();
		    session.setAttribute("user", username);
			pw.println("login successfull");
			request.getRequestDispatcher("link.html").include(request,response);
		}
		else {
			pw.println("login failed try again");
			request.getRequestDispatcher("login.html").include(request,response);
			
		}
	}

}
