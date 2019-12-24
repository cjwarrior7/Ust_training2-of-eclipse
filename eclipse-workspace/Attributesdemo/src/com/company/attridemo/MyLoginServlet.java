package com.company.attridemo;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class MyLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		// String val_user="admin";
		String val_pass = "1234";
        String password = req.getParameter("password");
        String username = req.getParameter("username");
		PrintWriter pw = resp.getWriter();
		ServletContext context=getServletContext();
		if (val_pass.equals(password)) {
		
			context.setAttribute("username", username);
			pw.print("login successfull"+username);
			pw.print("<br><a href='MyLink1'>Link1</a>");
			pw.print("<br><a href='MyLink2'>Link2</a>");
			pw.print("<br><a href='MyLink3'>Link3</a>");
		} else {
			pw.print("login failed");
		}

	}

}
