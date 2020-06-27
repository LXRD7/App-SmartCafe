package api;

import java.util.List;

import modelo.Precio;

public interface ServicePrecio {
	 String registrarPrecio(Precio precio);
	 Precio getPrecio(String codigoBarras);
	 List<Precio> getPrecios();
}
