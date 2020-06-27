package api;

import java.util.List;

import modelo.ProductoInventario;

public interface ServiceProductoInventario {
	 String registrarProducto(ProductoInventario producto);
	 ProductoInventario getProducto(String codigoBarras);
	 List<ProductoInventario> getProductos();
	 int eliminarProducto(String codigoBarras);
	 String modificarProducto(ProductoInventario producto);
	 boolean existeProducto(String codigoBarras);
}
