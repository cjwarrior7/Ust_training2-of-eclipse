package com.student.System;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AccountSettingServlet")
public class AccountSettingServlet extends HttpServlet {

	protected void doPOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
	   Cookie[] arr = request.getCookies();
	  System.out.println("IN ACCOUNTING:" + arr);
		ServletContext context = getServletContext();
		RequestDispatcher rd;
		try {
			System.out.println("IN TRY ASS");
			Cookie ck =arr[0];
			//if ((ck != null) && (!ck.getValue().equals(""))) {
				//System.out.println("TO UPDATE ACCOUNT SETTINGS");
				 //rd = request.getRequestDispatcher("AccountSetting.html");
				//System.out.println("before forward of acs");
				//rd.forward(request, response);
				//System.out.println("after forward of acs");
		        rd = request.getRequestDispatcher("AccountSetting.html");
		        rd.forward(request, response);
//				String name = request.getParameter("name");
//				System.out.println("name:"+name);
//				String address = request.getParameter("address");
//				System.out.println("address:"+address);
//				String username = request.getParameter("username");
//				System.out.println("username:"+username);
//				String orig_contact = (String) context.getAttribute("k2");
//				System.out.println(orig_contact);
//			if (name.length()!=0 && address.length()!=0 && username.length()!=0 ) {
//					System.out.print("The student contact is valid you entered is valid");
//
//					Class.forName("com.mysql.cj.jdbc.Driver");
//					System.out.println("Driver class is load and Registered");
//					System.out.println("Step2(Establish the Connection)");
//					System.out.println("First way:");
//					Connection conn1 = DriverManager
//							.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
//					System.out.println("ESTABLISH THE CONNECTION");
//					PreparedStatement pst1 = conn1.prepareStatement(
//							"UPDATE studentmg SET sname=? , username=? , address=? where mobno=? ");
//					System.out.println("Platform created");
//
//                    
//                    pst1.setString(1, name);
//					pst1.setString(2, username);
//					pst1.setString(3, address);
//				    pst1.setString(4 , (String)context.getAttribute("k2"));
//					
//					int rows_affected = pst1.executeUpdate();
//					System.out.println(rows_affected);
//					System.out.println("Query Executed");
//					if (rows_affected ==1) {
//					ck.setValue(username);
//					response.addCookie(ck);
//					System.out.println("UPDATED k1:"+ck.getValue());
//					//context.removeAttribute("k2");
//					//context.setAttribute("k2", new_contact);
//					context.removeAttribute("name");
//					context.setAttribute("name", name);
//					context.removeAttribute("address");
//					context.setAttribute("address", address);
//					
//					
//					System.out.println("inside rows affected");
//					pw.print("SUCCESSFULLY UPDATED INFORMATION");
//					pw.print("<br><a href=/LogoutServlet>LOGOUT HERE</a>");
//					pw.print("<br><a href=/ProfileServlet>CHECK PROFILE HERE</a>");
//					//pw.print("<br><a href=/AccountSettingServlet>MAKE ACCOUNT SETTINGS HERE</a>");
//
//					//RequestDispatcher rd1=request.getRequestDispatcher("home.html");
//					//rd1.include(request, response);
//				    }
//
//
//				} else {
//					System.out.println("all the fields are mandatory to fill");
//					pw.print("<h2>*ALL FIELDS ARE MANADTORY TO FILL</h2> ");
//					System.out.println("after error print");
//					pw.print("<br><a href=/LogoutServlet>LOGOUT HERE</a>");
//					pw.print("<br><a href=/ProfileServlet>CHECK PROFILE HERE</a>");
//					pw.print("<br><a href=/AccountSettingServlet>MAKE ACCOUNT SETTINGS HERE</a>");
//					//RequestDispatcher rd1 = request.getRequestDispatcher("AccountSetting.html");
//					//System.out.println("dispatcher");
//					//rd1.include(request, response);
//					//System.out.println("after include");
//				}
//               
////			}else {
////				System.out.println("ACS KA ELSE");
////				System.out.println("IT MEANS ck==null hai ck.get value khali hai ");
////				pw.print("LOGIN FIRST TO UPDATE ACCOUNT SETTINGS");
////				rd = request.getRequestDispatcher("Login.html");
////			    rd.include(request, response);
////			}
		} catch (Exception e) {
//			// TODO Auto-generated catch block
			e.printStackTrace();
	} 
////		} catch (NullPointerException e)
////		// TODO: handle exception
////		{
////			System.out.println("IN NPE of ACS");
////			pw.print("LOGIN FIRST TO UPDATE ACCOUNT SETTINGS");
////			rd = request.getRequestDispatcher("Login.html");
////	        rd.include(request, response);
////		}

	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		Cookie[] arr = req.getCookies();
		System.out.println("IN ACCOUNTING:" + arr);
		//ServletContext context = getServletContext();
		RequestDispatcher rd;
		try {
			System.out.println("IN TRY ASS");
			Cookie ck = arr[0];
			if ((ck != null) && (!ck.getValue().equals(""))) {
		    System.out.println("inside service method of ACCS");

		    doPOST(req, resp);
		    }
			else {
				System.out.println("ACS KA ELSE");
				System.out.println("IT MEANS ck==null hai ck.get value khali hai ");
				pw.print("LOGIN FIRST TO UPDATE ACCOUNT SETTINGS");
				rd = req.getRequestDispatcher("Login.html");
			    rd.include(req, resp);
			}
	}catch (Exception e) {
		System.out.println("IN NPE of ACS");
       pw.print("LOGIN FIRST TO UPDATE ACCOUNT SETTINGS");
	   rd = req.getRequestDispatcher("Login.html");
       rd.include(req, resp);
	}

	}

}
