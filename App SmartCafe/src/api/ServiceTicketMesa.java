package api;

import java.util.List;

import modelo.TicketMesa;

public interface ServiceTicketMesa {
	String registrarTicketMesa(TicketMesa ticketMesa);
	TicketMesa getTicketMesa(int numTicketMesa);
	List<TicketMesa> getTicketsMesa1();
	int eliminarTicketMesa(int numTicketMesa);
	String modificarTicketMesa(TicketMesa ticketMesa);
	 boolean existeTicketMesa(int numTicketMesa);
}
