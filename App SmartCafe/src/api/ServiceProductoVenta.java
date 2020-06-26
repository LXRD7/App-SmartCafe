package api;

import java.util.List;

import modelo.ProductoVenta;

public interface ServiceProductoVenta {
	String registrarProductoVenta(ProductoVenta productoVenta);
	ProductoVenta getProductoVenta(String codigoBarras);
	List<ProductoVenta> getProductosVenta();
	int eliminarProductoVenta(String codigoBarras);
	String modificarProductoVenta(ProductoVenta productoVenta);
}
