package api;

import java.util.List;

import modelo.Categoria;
import modelo.ProductoInventario;

public interface ServiceCategoria {
	String registrarCategoria(Categoria categoria);
	 Categoria getCategoria(int claveCategoria);
	 List<Categoria> getCategorias();
	 int eliminarCategoria(int claveCategoria);
	 String modificarCategoria(Categoria categoria);
	 
}
