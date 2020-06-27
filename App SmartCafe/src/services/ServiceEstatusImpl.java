package services;

import java.util.List;

import api.ServiceEstatus;
import dao.FuenteDatos;
import dao.TablaEstatus;
import dao.TablaProductoInventario;
import modelo.Estatus;
import modelo.ProductoInventario;

public class ServiceEstatusImpl implements ServiceEstatus{
	private TablaEstatus tablaEstatus;

	public ServiceEstatusImpl() {
		tablaEstatus= new TablaEstatus(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarEstatus(Estatus estatus) {
		return tablaEstatus.registrarEstatus(estatus);
	}

	@Override
	public Estatus getEstatus(int numStatus) {
		return tablaEstatus.getEstatus(numStatus);
	}

	@Override
	public List<Estatus> getEstatus1() {
		return tablaEstatus.getEstatus1();
	}

	@Override
	public int eliminarEstatus(int numStatus) {
		return tablaEstatus.eliminarEstatus(numStatus);
	}

	@Override
	public String modificarEstatus(Estatus estatus) {
		if(tablaEstatus.existeEstatus(estatus.getNumStatus()))
			return tablaEstatus.modificarEstatus(estatus);
		else
			return "El estatus no existe";
	}
}
