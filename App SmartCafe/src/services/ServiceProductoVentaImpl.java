package services;

import java.util.List;

import api.ServiceProductoVenta;
import dao.FuenteDatos;
import dao.TablaProductoInventario;
import dao.TablaProductoVenta;
import modelo.ProductoVenta;

public class ServiceProductoVentaImpl implements ServiceProductoVenta {
	private TablaProductoVenta tablaProductoVenta;

	public ServiceProductoVentaImpl() {
		tablaProductoVenta= new TablaProductoVenta(FuenteDatos.getBaseDatos().getConexion());
	}
	
	@Override
	public String registrarProductoVenta(ProductoVenta productoVenta) {
		return tablaProductoVenta.registrarProductoVenta(productoVenta);
	}

	@Override
	public ProductoVenta getProductoVenta(String codigoBarras) {
		return tablaProductoVenta.getProductoVenta(codigoBarras);
	}

	@Override
	public List<ProductoVenta> getProductosVenta() {
		return tablaProductoVenta.getProductosVenta();

	}

	@Override
	public int eliminarProductoVenta(String codigoBarras) {
		return tablaProductoVenta.eliminarProductoVenta(codigoBarras);
	}

	@Override
	public String modificarProductoVenta(ProductoVenta productoVenta) {
		if(tablaProductoVenta.existeProductoVenta(productoVenta.getCodigoBarras()))
			return tablaProductoVenta.modificarProductoVenta(productoVenta);
		else
			return "El producto venta no existe";
			
	}

	@Override
	public boolean existeProductoVenta(String codigoBarras) {
		return tablaProductoVenta.existeProductoVenta(codigoBarras);

	}

}
