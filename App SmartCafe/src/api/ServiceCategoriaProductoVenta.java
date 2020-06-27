package api;

import java.util.List;

import modelo.Categoria;
import modelo.CategoriaProductoVenta;

public interface ServiceCategoriaProductoVenta {
	String registrarCategoriaProductoVenta(CategoriaProductoVenta categoriaProductoVenta);
	CategoriaProductoVenta getCategoriaProductoVenta(int numProductoVenta);
	 List<CategoriaProductoVenta> getCategoriasProductoVenta();
	 int eliminarCategoriaProductoVenta(int numProductoVenta);
	 String modificarCategoriaProductoVenta(CategoriaProductoVenta categoriaProductoVenta);
	 boolean existeCategoriaProductoVenta(int numProductoVenta);
}
