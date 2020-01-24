package com.company.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;


@WebServlet("/SendServlet")
public class SendServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String sid=request.getParameter("id");
		int id = Integer.parseInt(sid);
		
		
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_testdb_adv_java?user=root&password=root");
				PreparedStatement pst=conn.prepareStatement("select email from register where  id=?");
			    pst.setInt(1, id);
				ResultSet rs=pst.executeQuery();
			    if(rs.next()) {
			    	//pw.println(rs.getString("email"));
			    	
			        String to=rs.getString("email");
			    	pw.print("<html>");
			    	pw.print("<h4 align='center'>");
			    	pw.print("<form action='EmailServlet' method='Post'><br>");
			    	pw.print("TO:<br>");
			    	pw.print("<input type='text' name='to' value='"+to+"' align=middle><br>");
			    	pw.print("FROM:<br>");
			    	pw.print("<input type='text' name='from' placeholder='from' align=middle><br>");
			    	pw.print("SUB:<br>");
			    	pw.print("<input type='text' name='sub' placeholder='sub' align=middle><br>");
			    	pw.print("TEXT:<br>");
			    	pw.print("<input type='text',name='msg'  align=middle><br>");
			    	pw.print( "<input type='submit'  value='submit'>");
			    	pw.print("</form>");
			    	pw.print("</h4>");
			    	pw.print("</html>");
			    	
			    }
			    else {
			    	pw.println("record not found");
			    }
				
	} catch (ClassNotFoundException | SQLException  | NullPointerException e) {
		// TODO Auto-generated catch block
		pw.println("send  failed"); 
		e.printStackTrace();
		e.getMessage();

}
	
	}

	
}
