package com.client;
import java.util.Scanner;
import com.objectcreationlayer.*;


public class Customer {
	public static void main(String[] args) {
		System.out.println("Welcome");
		char ch='y';
		while(ch=='y') {
		System.out.println("How many movie Ticket You want to Book ?");
		Scanner sc=new Scanner(System.in);
		int tickets=sc.nextInt();
		TicketBook tm=TicketManage.ticketprovider("paytm");
		tm.getMyTicket(tickets);
		
		}
		
		
		
				
	}

}
