package com.student.System;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Cookie[] arr = request.getCookies();
		System.out.println(arr);
		RequestDispatcher rd;
		try {
			System.out.println("I AM IN TRY");
			Cookie ck = arr[0];
			System.out.println(ck.getValue());
			if ((ck != null) && (!ck.getValue().equals(""))) {
				System.out.println("PS if ke andar hu");
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver class is load and Registered");
				System.out.println("Step2(Establish the Connection)");
				System.out.println("First way:");
				Connection conn = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
				PreparedStatement pst = conn.prepareStatement("Select * from studentmg where username=? AND mobno=?");
				System.out.println("Platform created");
				ServletContext context = getServletContext();

				System.out.println("cookie  updated successfully");
				System.out.println("k1:" + ck.getValue());
				System.out.println("k2:" + (String) context.getAttribute("k2"));

				pst.setString(1, ck.getValue());
				pst.setString(2, (String) context.getAttribute("k2"));
				ResultSet result_set = pst.executeQuery();
				// System.out.println(result_set.getInt("id"));
				System.out.println("Query Executed");
				String db_sname = (String) context.getAttribute("name");
				String db_address = (String) context.getAttribute("address");
				;

				if (result_set.next()) {

					pw.println("HI:" + result_set.getString("sname"));
					pw.println("ADDRESS:" + result_set.getString("address"));
					pw.println("RESULT:" + result_set.getString("result"));
					pw.println("MOB:" + result_set.getString("mobno"));
					pw.println("USERNAME:" + result_set.getString("username"));
					pw.print("<br><a href=Register.html>REGISTER</a>");
					pw.print("<br><a href=LogoutServlet>LOGOUT HERE</a>");
					pw.print("<br><a href=AccountSettingServlet>MAKE ACCOUNT SETTINGS HERE</a>");

				} else {
					System.out.println("result set is empty");
					pw.println("hi:" + db_sname);
					pw.println("address:" + db_address);
					pw.println("username:" + ck.getValue());
					pw.print("<br><a href=Register.html>REGISTER</a>");
					pw.print("<br><a href=LogoutServlet>LOGOUT HERE</a>");
					pw.print("<br><a href=AccountSettingServlet>MAKE ACCOUNT SETTINGS HERE</a>");

				}

				// rd=request.getRequestDispatcher("index.html");
				// rd.include(request, response);
			} else {
				System.out.println("REJECT BY IF OF PROFILE SERVLET");
				pw.print("please login first");
				rd = request.getRequestDispatcher("Login.html");

				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
			System.out.println("NPE CATCH");
			pw.print("please login first");
			rd = request.getRequestDispatcher("Login.html");
			// rd.include(request, response);
			// pw.print("<br><a href=Register.html>REGISTER HERE</a>");
			// pw.print("<br><a href=Logout.html>LOGOUT HERE</a>");
			// pw.print("<br><a href=Profile.html>CHECK PROFILE HERE</a>");
			// pw.print("<br><a href=AccountSetting.html>MAKE ACCOUNT SETTINGS HERE</a>");
			rd.include(request, response);
		}
	}

}
