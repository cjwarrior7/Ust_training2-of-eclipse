package com.implementationlayer;

import com.objectcreationlayer.TicketBook;

public class CinemaTicket implements TicketBook {
	static int seats = 110;
	static int count_seats ;

	@Override
	public String getMyTicket(int Ticket) {
		if (Ticket <= (seats-count_seats)) {
			count_seats = +Ticket ;
			System.out.println("Your Bookd: " + count_seats + " Tickets");
			return "Your Ticket Booked Successfully";
		} else {
			int left_ticket = seats - count_seats;
			if (left_ticket > 0) {
				System.out.println("Sorry for Inconvience");
				return "only ticket left is:" + left_ticket;
			}
		}
		return "No Ticket left";
	}

}
