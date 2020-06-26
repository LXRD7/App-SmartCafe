package services;

import java.util.List;

import api.ServiceProductoInventario;
import dao.FuenteDatos;
import dao.TablaProductoInventario;
import modelo.ProductoInventario;

public class ServiceProductoInventarioImpl implements ServiceProductoInventario{
	private TablaProductoInventario tablaProductoInventario;

	public ServiceProductoInventarioImpl() {
		tablaProductoInventario= new TablaProductoInventario(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarProducto(ProductoInventario producto) {
		return tablaProductoInventario.registrarProducto(producto);
	}

	@Override
	public ProductoInventario getProducto(String cve) {
		return tablaProductoInventario.getProducto(cve);
	}

	@Override
	public List<ProductoInventario> getProductos() {
		return tablaProductoInventario.getProductos();
	}

	@Override
	public int eliminarProducto(String cve) {
		return tablaProductoInventario.eliminarProducto(cve);
	}

	@Override
	public String modificarProducto(ProductoInventario producto) {
		if(tablaProductoInventario.existeProducto(producto.getCodigoBarras()))
			return tablaProductoInventario.modificarProducto(producto);
		else
			return "El producto no existe";
			
	}
	
}
