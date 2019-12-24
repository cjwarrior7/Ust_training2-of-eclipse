
public class TicketBookingThread extends Thread {
 GetTicket getticket;
 private String ticket_Booker_name;
 private int no_of_seats_to_book;
 public TicketBookingThread(GetTicket getticket,String ticket_Booker_name, int no_of_seats_to_book) {
	this.getticket=getticket;
	this.ticket_Booker_name = ticket_Booker_name;
	this.no_of_seats_to_book = no_of_seats_to_book;
}
public void run() {
getticket.bookMyTicket(ticket_Booker_name,no_of_seats_to_book);
	
}
 
}
