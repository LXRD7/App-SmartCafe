package services;

import java.util.List;

import api.ServiceTicketMesa;
import dao.FuenteDatos;
import dao.TablaProductoInventario;
import dao.TablaTicketMesa;
import modelo.TicketMesa;

public class ServiceTicketMesaImpl implements ServiceTicketMesa{
	private TablaTicketMesa tablaTicketMesa;

	public ServiceTicketMesaImpl() {
		tablaTicketMesa= new TablaTicketMesa(FuenteDatos.getBaseDatos().getConexion());
	}
	
	@Override
	public String registrarTicketMesa(TicketMesa ticketMesa) {
		return tablaTicketMesa.registrarTicketMesa(ticketMesa);
	}

	@Override
	public TicketMesa getTicketMesa(int numTicketMesa) {
		return tablaTicketMesa.getTicketMesa(numTicketMesa);
	}

	@Override
	public List<TicketMesa> getTicketsMesa1() {
		return tablaTicketMesa.getTicketsMesa1();
	}

	@Override
	public int eliminarTicketMesa(int numTicketMesa) {
		return tablaTicketMesa.eliminarTicketMesa(numTicketMesa);
	}

	@Override
	public String modificarTicketMesa(TicketMesa ticketMesa) {
		if(tablaTicketMesa.existeTicketMesa(ticketMesa.getNumTicketMesa()))
			return tablaTicketMesa.modificarTicketMesa(ticketMesa);
		else
			return "El ticket mesa no existe";
	}

	@Override
	public boolean existeTicketMesa(int numTicketMesa) {
		return tablaTicketMesa.existeTicketMesa(numTicketMesa);
	}
	
}
