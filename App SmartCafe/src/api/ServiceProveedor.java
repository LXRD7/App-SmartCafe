package api;

import java.util.List;

import modelo.Proveedor;

public interface ServiceProveedor {
	String registrarProveedor(Proveedor proveedor);
	Proveedor getProveedor(int claveProveedor);
	List<Proveedor> getProveedor();
	int eliminarProveedor(int claveProveedor);
	String modificarProveedor(Proveedor proveedor);
}
