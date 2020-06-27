package api;

import java.util.List;

import modelo.Precio;

public interface ServicePrecio {
	 String registrarPrecio(Precio precio);
	 Precio getPrecio(int clavePrecio);
	 List<Precio> getPrecios();
	 int eliminarPrecio(int clavePrecio);
	 String modificarPrecio(Precio precio);
	 boolean existePrecio(int clavePrecio);
}
