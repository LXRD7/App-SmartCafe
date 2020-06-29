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
	public ProductoInventario getProducto(String codigoBarras) {
		return tablaProductoInventario.getProducto(codigoBarras);
	}

	@Override
	public List<ProductoInventario> getProductos() {
		return tablaProductoInventario.getProductos();
	}

	@Override
	public int eliminarProducto(String codigoBarras) {
		return tablaProductoInventario.eliminarProducto(codigoBarras);
	}

	@Override
	public String modificarProducto(ProductoInventario producto) {
		return tablaProductoInventario.modificarProducto(producto);

	}

	@Override
	public boolean existeProducto(String codigoBarras) {
		return tablaProductoInventario.existeProducto(codigoBarras);
	}

}
