package api;

import java.util.List;
import modelo.Ticket;

public interface ServiceTicket {
	String registrarTicket(Ticket ticket);
	Ticket getTicket(int claveTicket);
	List<Ticket> getTickets();
	int eliminarTicket(int claveTicket);
	String modificarTicket(Ticket ticket);
}
