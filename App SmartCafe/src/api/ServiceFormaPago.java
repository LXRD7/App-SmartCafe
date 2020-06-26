package api;

import java.util.List;

import modelo.FormaPago;
import modelo.ProductoInventario;

public interface ServiceFormaPago {
	 String registrarFormaPago(FormaPago formaPago);
	 FormaPago getFormaPago(int claveFormaPago);
	 List<FormaPago> getFormaPagos();
	 int eliminarFormaPago(int claveFormaPago);
	 String modificarFormaPago(FormaPago formaPago);
}
