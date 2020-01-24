package com.company.register;

import java.io.IOException;
import java.io.PrintWriter;
//import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {

	public static void send(String from,String password,String to,String sub,String msg,HttpServletResponse resp){
		resp.setContentType("text/html");
		
	      Properties props = new Properties();
	        props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.socketFactory.port", "465");
	        props.put("mail.smtp.socketFactory.class",
	                "javax.net.ssl.SSLSocketFactory");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.port", "465");
	        //get Session
	        Session session = Session.getDefaultInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(from,password);
	                    }
	                });
	        //compose message
	        try {
	            MimeMessage message = new MimeMessage(session);
	            System.out.println("message:"+message);
	            System.out.println("to:"+to);
	            System.out.println("msg:"+msg);
	            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	            message.setSubject(sub);
	            message.setText(msg);
	            //send message
	            Transport.send(message);
	            PrintWriter pw=resp.getWriter();
	            pw.println("message sent successfully");
	        }
	        catch (MessagingException e ) {
	        	throw new RuntimeException(e);
	        	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        

	    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String to=request.getParameter("to");
		System.out.println("to in Post:"+to);
		String from=request.getParameter("from");
		String sub=request.getParameter("sub");
		String msg=request.getParameter("msg");
		  //from,password,to,subject,message
        send(from,"********",to,sub,msg,response);
        //change from, password and to// TODO Auto-generated method stub
	
	}

}