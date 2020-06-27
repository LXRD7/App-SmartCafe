package services;

import java.util.List;

import api.ServiceReceta;
import dao.TablaReceta;
import modelo.Receta;

public class ServiceRecetaImpl implements ServiceReceta{
	private TablaReceta tablaReceta;

	@Override
	public String registrarReceta(Receta receta) {
		return tablaReceta.registrarReceta(receta);
	}

	@Override
	public Receta getReceta(int claveReceta) {
		return tablaReceta.getReceta(claveReceta);
	}

	@Override
	public List<Receta> getRecetas() {
		return tablaReceta.getRecetas();
	}

	@Override
	public int eliminarReceta(int claveReceta) {
		return tablaReceta.eliminarReceta(claveReceta);
	}

	@Override
	public String modificarReceta(Receta receta) {
		if(tablaReceta.existeReceta(receta.getClaveReceta()))
			return tablaReceta.modificarReceta(receta);
		else
			return "La receta no existe";
			
	}
	@Override
	public boolean existeReceta(int claveReceta) {
		return tablaReceta.existeReceta(claveReceta);
	}

}
