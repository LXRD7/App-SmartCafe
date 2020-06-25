package api;

import java.util.List;

import modelo.Proveedor;

public interface ServiceProveedor {
	String registrarProveedor(Proveedor proveedor);
	Proveedor getProveedor(String claveProveedor);
	List<Proveedor> getProveedor();
	int eliminarProveedor(String claveProveedor);
	String modificarProveedor(Proveedor proveedor);
}
