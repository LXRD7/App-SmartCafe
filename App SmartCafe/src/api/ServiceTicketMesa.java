package api;

import java.util.List;

import modelo.TicketMesa;

public interface ServiceTicketMesa {
	String registrarTicketMesa(TicketMesa ticketMesa);
	TicketMesa getTicket(int numTicketMesa);
	List<TicketMesa> getTickets();
	int eliminarTicketMesa(int numTicketMesa);
	String modificarTicketMesa(TicketMesa ticketMesa);
	 boolean existeTicketMesa(int numTicketMesa);
}
