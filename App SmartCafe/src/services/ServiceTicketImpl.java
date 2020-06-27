package services;

import java.util.List;

import api.ServiceTicket;
import dao.FuenteDatos;
import dao.TablaProductoInventario;
import dao.TablaTicket;
import modelo.Ticket;

public class ServiceTicketImpl implements ServiceTicket {
	private TablaTicket tablaTicket;
	
	public ServiceTicketImpl() {
		tablaTicket= new TablaTicket(FuenteDatos.getBaseDatos().getConexion());
	}
	
	@Override
	public String registrarTicket(Ticket ticket) {
		return tablaTicket.registrarTicket(ticket);
	}

	@Override
	public Ticket getTicket(int claveTicket) {
		return tablaTicket.getTicket(claveTicket);
	}

	@Override
	public List<Ticket> getTickets() {
		return tablaTicket.getTickets();
	}

	@Override
	public int eliminarTicket(int claveTicket) {
		return tablaTicket.eliminarTicket(claveTicket);
	}

	@Override
	public String modificarTicket(Ticket ticket) {
		if(tablaTicket.existeTicket(ticket.getClaveTicket()))
			return tablaTicket.modificarTicket(ticket);
		else
			return "El ticket no existe";
	}

	@Override
	public boolean existeTicket(int claveTicket) {
		return tablaTicket.existeTicket(claveTicket);

	}

}
