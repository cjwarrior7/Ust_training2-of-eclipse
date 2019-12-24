package com.objectcreationlayer;

import com.implementationlayer.CinemaTicket;

public class TicketManage {
	public static TicketBook ticketprovider(String ticketBookingmedium) {
	if(ticketBookingmedium.equalsIgnoreCase("paytm")) {
	  return new CinemaTicket();	
	}
	return null;

	}

}
