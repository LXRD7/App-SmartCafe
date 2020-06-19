package api;

import java.util.List;

import modelo.ProductoInventario;

public interface ServiceProductoInventario {
	 String registrar(ProductoInventario producto);
	 ProductoInventario getProducto(String cve);
	 List<ProductoInventario> getProductos();
	 int eliminar(String cve);
	 String modificar(ProductoInventario producto);
}
