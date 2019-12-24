
public  class GetTicket {
	int available_tickets=110;
	
public synchronized void bookMyTicket(String ticket_booker_name,int no_of_tickets_to_book) {
	if(available_tickets >= no_of_tickets_to_book && available_tickets>0 ) {
		System.out.println("Hi," + ticket_booker_name + " : " + no_of_tickets_to_book+ " Seats booked Successfully..");
		available_tickets = available_tickets- no_of_tickets_to_book;	
	}
	{
		System.out.println("Hi," + ticket_booker_name + " : Seats Not Available");
	}
}
}
