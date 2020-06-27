package services;

import java.util.List;

import api.ServiceResurtir;
import dao.FuenteDatos;
import dao.TablaCategoria;
import dao.TablaResurtir;
import modelo.Categoria;
import modelo.Resurtir;

public class ServiceResurtirImpl implements ServiceResurtir{
	private TablaResurtir tablaResurtir;

	public ServiceResurtirImpl() {
		tablaResurtir= new TablaResurtir(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarResurtir(Resurtir resurtir) {
		return tablaResurtir.registrarResurtir(resurtir);
	}

	@Override
	public Resurtir getResurtir(int numResurtir) {
		return tablaResurtir.getResurtir(numResurtir);
	}

	@Override
	public List<Resurtir> getResurtidos() {
		return tablaResurtir.getResurtidos();
	}

	@Override
	public int eliminarResurtir(int numResurtir) {
		return tablaResurtir.eliminarResurtir(numResurtir);
	}

	@Override
	public String modificarResurtir(Resurtir resurtir) {
		if(tablaResurtir.existeResurtir(resurtir.getNumResurtir()))
			return tablaResurtir.modificarResurtir(resurtir);
		else
			return "El resurtir no existe";
			
	}

	@Override
	public boolean existeResurtir(int numResurtir) {
		return tablaResurtir.existeResurtir(numResurtir);
	}

	
}
