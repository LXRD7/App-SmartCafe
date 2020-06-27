package services;

import java.util.List;

import api.ServiceCategoria;
import dao.FuenteDatos;
import dao.TablaCategoria;
import modelo.Categoria;
import modelo.ProductoInventario;

public class ServiceCategoriaImpl implements ServiceCategoria{
	private TablaCategoria tablaCategoria;

	public ServiceCategoriaImpl() {
		tablaCategoria= new TablaCategoria(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarCategoria(Categoria categoria) {
		return tablaCategoria.registrarCategoria(categoria);
	}

	@Override
	public Categoria getCategoria(int claveCategoria) {
		return tablaCategoria.getCategoria(claveCategoria);
	}

	@Override
	public List<Categoria> getCategorias() {
		return tablaCategoria.getCategorias();
	}

	@Override
	public int eliminarCategoria(int claveCategoria) {
		return tablaCategoria.eliminarCategoria(claveCategoria);
	}

	@Override
	public String modificarCategoria(Categoria categoria) {
		if(tablaCategoria.existeCategoria(categoria.getClaveCategoria()))
			return tablaCategoria.modificarCategoria(categoria);
		else
			return "La categoria no existe";
			
	}

	@Override
	public boolean existeCategoria(int claveCategoria) {
		return tablaCategoria.existeCategoria(claveCategoria);
	}
}
