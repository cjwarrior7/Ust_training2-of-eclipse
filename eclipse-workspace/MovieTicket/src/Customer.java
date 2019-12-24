
public class Customer {
	public static void main(String[] args) {
		GetTicket ticketcounter = new GetTicket();
		   TicketBookingThread th1=new TicketBookingThread(ticketcounter,"ajay",100);
		   TicketBookingThread th2=new TicketBookingThread(ticketcounter,"vijay",6);
		   TicketBookingThread th3=new TicketBookingThread(ticketcounter,"shyam",6);
		   th1.start();
		   th2.start();
		   th3.start();	
	}
 
   
}
