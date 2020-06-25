package api;

import java.util.List;

import modelo.Categoria;
import modelo.ProductoInventario;

public interface ServiceCategoria {
	String registrar(Categoria categoria);
	 Categoria getCategoria(int claveCategoria);
	 List<Categoria> getProductos();
	 int eliminar(int claveCategoria);
	 String modificar(Categoria categoria);
	 
}
