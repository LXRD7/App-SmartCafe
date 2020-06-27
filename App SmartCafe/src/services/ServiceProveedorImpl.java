package services;

import java.util.List;

import api.ServiceProveedor;
import dao.FuenteDatos;
import dao.TablaProductoInventario;
import dao.TablaProveedor;
import modelo.Proveedor;

public class ServiceProveedorImpl implements ServiceProveedor{
	private TablaProveedor tablaProveedor;
	
	public ServiceProveedorImpl() {
		tablaProveedor= new TablaProveedor(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarProveedor(Proveedor proveedor) {
		return tablaProveedor.registrarProveedor(proveedor);
	}

	@Override
	public Proveedor getProveedor(int claveProveedor) {
		return tablaProveedor.getProveedor(claveProveedor);
	}

	@Override
	public List<Proveedor> getProveedores() {
		return tablaProveedor.getProveedores();
	}

	@Override
	public int eliminarProveedor(int claveProveedor) {
		return tablaProveedor.eliminarProveedor(claveProveedor);
	}

	@Override
	public String modificarProveedor(Proveedor proveedor) {
		if(tablaProveedor.existeProveedor(proveedor.getClaveProveedor()))
			return tablaProveedor.modificarProveedor(proveedor);
		else
			return "El proveedor no existe";
	}
	@Override
	public boolean existeProveedor(int claveProveedor) {
		return tablaProveedor.existeProveedor(claveProveedor);
	}
}
