package api;

import java.util.List;

import modelo.TicketProductoVenta;

public interface ServiceTicketProductoVenta {
	String registrarTicketProductoVenta(TicketProductoVenta ticketProductoVenta);
	TicketProductoVenta getTicketProductoVenta(int numeroTicket);
	List<TicketProductoVenta> getTicketsProductoVenta();
	int eliminarTicketProductoVenta (int numeroTicket);
	String modificarTicketProductoVenta(TicketProductoVenta ticketProductoVenta);
	 boolean existeTicketProductoVenta(int numeroTicket);
}


