package api;

import java.util.List;

import modelo.Receta;

public interface ServiceReceta {
	String registrarReceta(Receta receta);
	Receta getReceta(int claveReceta);
	List<Receta> getRecetas();
	int eliminarReceta(int claveReceta);
	String modificarReceta(Receta receta);
	 boolean existeReceta(int claveReceta);
}
