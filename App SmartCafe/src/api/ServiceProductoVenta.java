package api;

import java.util.List;

import modelo.ProductoVenta;

public interface ServiceProductoVenta {
	String registrarProducto(ProductoVenta producto);
	ProductoVenta getProducto(String codigoBarras);
	List<ProductoVenta> getProductos();
	int eliminarProducto(String codigoBarras);
	String modificarProducto(ProductoVenta producto);
}
