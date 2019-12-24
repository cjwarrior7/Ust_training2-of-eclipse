package com.company.gmail;

	import java.sql.*;
	import java.util.Scanner;



	public class Accountoperations {
	    String username;
	    String password;
	    String email;

	    public Accountoperations (String username, String password, String email) {
	        this.username = username;
	        this.password = password;
	        this.email = email;
	    }
	    public Accountoperations(String email,String password) {

	        this.password = password;
	        this.email = email;
	    }

	    public  void createacc(){
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver class is load and Registered");
	            System.out.println("Step2(Establish the Connection)");
	            System.out.println("First way:");
	            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gmail?user=root&password=root");
	            System.out.println(con1);
//	            System.out.println("Second way:");
//	            final String url = "jdbc:mysql://localhost:3306/my_testdb_adv_java?";
//	            final String user = "root";
//	            final String password = "root";
//	            Connection con2 = DriverManager.getConnection(url, user, password);
//	            System.out.println(con2);
//	            System.out.println("Third Way:");
//	            con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gmail?user=root&password=root");
	            PreparedStatement pst=con1.prepareStatement("insert into Account(User_name ,password,Email)  values(?,?,?)");
	            pst.setString(1,username);
	            pst.setString(2,password);
	            pst.setString(3,email);
	            pst.execute();
	          
	            //create

	        }   catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	    }
	    public  void loginacc(){
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver class is load and Registered");
	            System.out.println("Step2(Establish the Connection)");
	            System.out.println("First way:");
	            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gmail?user=root&password=root");
	            System.out.println(con1);
	            //System.out.println("Second way:");
	           // final String url = "jdbc:mysql://localhost:3306/my_testdb_adv_java?";
	            //final String user = "root";
	           // final String password = "root";
	           // Connection con2 = DriverManager.getConnection(url, user, password);
	            //System.out.println(con2);
	            //System.out.println("Third Way:");
	            //con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gmail?user=root&password=root");
	            PreparedStatement pst=con1.prepareStatement("select * from Account where Email=? AND password=?");
	            pst.setString(1,email);
	            pst.setString(2,password);
	            ResultSet rs=pst.executeQuery();
	            if(rs.next()){
	                System.out.println("LOGIN SUCCESFULL");
	                System.out.println("Enter the A to compose message or B to see inbox");
	                Scanner sc=new Scanner(System.in);
	                String input=sc.next();
	                if(input.equals("A")){
	                    System.out.println("COMPOSE MESSAGE");
	                    System.out.println("enter the email to which mail is to be sent");
			            String email_rec=sc.next();
			            sc.nextLine();
			            System.out.println("Enter message for Email receiver"); 
			            String Message=sc.nextLine();
			            
			            System.out.println(Message);
			            
			            try {
				        

			      
				            PreparedStatement pst1=con1.prepareStatement("insert into Inbox(Message,User_id) select ? ,User_id from Account where Email=?  ");
				            pst1.setString(1,Message);
				            pst1.setString(2,email_rec);
				            Boolean oper=pst1.execute();
				            System.out.println(oper);
				            if(oper){
				            System.out.println("sent failed");
				            }
				            else {
				            	System.out.println("sent successfully");
				        
				            }
				          
				            //create

				        }   catch (SQLException e) {
				            e.printStackTrace();
				        } 
			       
	                    
	                    

	                }
	                else if(input.equals("B")){
	                    System.out.println("SEE INBOX");
	                    try {
					        

	      			      
				            PreparedStatement pst1=con1.prepareStatement("select Message from Inbox where User_id=(Select User_id from Account where Email=?)");
				            pst1.setString(1,email);
				            ResultSet rs1=pst1.executeQuery();
				            int counter=1;
				            while(rs1.next()) {
				            	System.out.println("Message"+counter+rs1.getString("Message"));
				            	counter++;
				            }
				            
				            
				          
				          
				            //create

				        }   catch (SQLException e) {
				            e.printStackTrace();
	                   }
	                    }
	                else {
	                	System.out.println("invaid input");
	                }


	            }
	            else{
	                System.out.println("login failed");
		            System.out.println("enter the username");
		            Scanner sc=new Scanner(System.in);
		            String username=sc.next();
		            System.out.println("enter the email");
		            String email=sc.next();
		            System.out.println("enter the password");
		            String password=sc.next();
		            Accountoperations ac=new Accountoperations(username,password,email);
		            ac.createacc();
	            }




	            //create

	        }   catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	    }
	}
	   
