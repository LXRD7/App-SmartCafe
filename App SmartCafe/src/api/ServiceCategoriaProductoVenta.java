package api;

import java.util.List;

import modelo.Categoria;
import modelo.CategoriaProductoVenta;

public interface ServiceCategoriaProductoVenta {
	String registrarCategoriaProductoVenta(CategoriaProductoVenta categoriaProductoVenta);
	CategoriaProductoVenta getCategoriaProductoVenta(int numProductoVenta);
	 List<CategoriaProductoVenta> getCategorias();
	 int eliminar(int numProductoVenta);
	 String modificar(CategoriaProductoVenta categoriaProductoVenta);
	 
}
