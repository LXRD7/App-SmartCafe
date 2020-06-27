package services;

import java.util.List;

import api.ServiceTicketProductoVenta;
import dao.FuenteDatos;
import dao.TablaProductoInventario;
import dao.TablaTicketProductoVenta;
import modelo.TicketProductoVenta;

public class ServiceTicketProductoVentaImpl implements ServiceTicketProductoVenta {
	private TablaTicketProductoVenta tablaTicketProductoVenta;

	public ServiceTicketProductoVentaImpl() {
		tablaTicketProductoVenta= new TablaTicketProductoVenta(FuenteDatos.getBaseDatos().getConexion());
	}
	
	@Override
	public String registrarTicketProductoVenta(TicketProductoVenta ticketProductoVenta) {
		return tablaTicketProductoVenta.registrarTicketProductoVenta(ticketProductoVenta);
	}

	@Override
	public TicketProductoVenta getTicketProductoVenta(int numeroTicket) {
		return tablaTicketProductoVenta.getTicketProductoVenta(numeroTicket);
	}

	@Override
	public List<TicketProductoVenta> getTicketsProductoVenta() {
		return tablaTicketProductoVenta.getTicketsProductoVenta();

	}

	@Override
	public int eliminarTicketProductoVenta(int numeroTicket) {
		return tablaTicketProductoVenta.eliminarTicketProductoVenta(numeroTicket);

	}

	@Override
	public String modificarTicketProductoVenta(TicketProductoVenta ticketProductoVenta) {
		if(tablaTicketProductoVenta.existeTicketProductoVenta(ticketProductoVenta.getNumeroTicket()))
			return tablaTicketProductoVenta.modificarTicketProductoVenta(ticketProductoVenta);
		else
			return "El ticket producto venta no existe";
			
	}

	@Override
	public boolean existeTicketProductoVenta(int numeroTicket) {
		return tablaTicketProductoVenta.existeTicketProductoVenta(numeroTicket);
	}

}
