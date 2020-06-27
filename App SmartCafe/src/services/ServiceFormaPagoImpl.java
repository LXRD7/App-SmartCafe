package services;

import java.util.List;

import api.ServiceFormaPago;
import dao.FuenteDatos;
import dao.TablaEstatus;
import dao.TablaFormaPago;
import modelo.FormaPago;

public class ServiceFormaPagoImpl implements ServiceFormaPago{
	private TablaFormaPago tablaFormaPago;

	public ServiceFormaPagoImpl() {
		tablaFormaPago= new TablaFormaPago(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarFormaPago(FormaPago formaPago) {
		return tablaFormaPago.registrarFormaPago(formaPago);
	}

	@Override
	public FormaPago getFormaPago(int claveFormaPago) {
		return tablaFormaPago.getFormaPago(claveFormaPago);
	}

	@Override
	public List<FormaPago> getFormaPagos() {
		return tablaFormaPago.getFormaPagos();
	}

	@Override
	public int eliminarFormaPago(int claveFormaPago) {
		return tablaFormaPago.eliminarFormaPago(claveFormaPago);
	}

	@Override
	public String modificarFormaPago(FormaPago formaPago) {
		if(tablaFormaPago.existeFormaPago(formaPago.getClaveFormaPago()))
			return tablaFormaPago.modificarFormaPago(formaPago);
		else
			return "La forma pago no existe";

	}

}
