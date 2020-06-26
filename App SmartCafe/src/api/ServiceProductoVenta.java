package api;

import java.util.List;

import modelo.ProductoInventario;
import modelo.ProductoVenta;

public interface ServiceProductoVenta {
	 String registrarProducto(ProductoVenta productoVenta);
	 ProductoVenta getProductoVenta(String codigoBarras);
	 List<ProductoVenta> getProductosVenta();
	 int eliminarProductoVenta(String codigoBarras);
	 String modificarProductoVenta(ProductoVenta productoVenta);
}
