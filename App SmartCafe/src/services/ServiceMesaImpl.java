package services;

import java.util.List;

import api.ServiceMesa;
import dao.FuenteDatos;
import dao.TablaMesa;
import dao.TablaProductoInventario;
import modelo.Mesa;
import modelo.ProductoInventario;

public class ServiceMesaImpl implements ServiceMesa{
	private TablaMesa tablaMesa;

	public ServiceMesaImpl() {
		tablaMesa= new TablaMesa(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarMesa(Mesa mesa) {
		return tablaMesa.registrarMesa(mesa);
	}

	@Override
	public Mesa getMesa(int claveMesa) {
		return tablaMesa.getMesa(claveMesa);
	}

	@Override
	public List<Mesa> getMesas() {
		return tablaMesa.getMesas();
	}

	@Override
	public int eliminarMesa(int claveMesa) {
		return tablaMesa.eliminarMesa(claveMesa);
	}

	@Override
	public String modificarMesa(Mesa mesa) {
		if(tablaMesa.existeMesa(mesa.getClaveMesa()))
			return tablaMesa.modificarMesa(mesa);
		else
			return "La mesa no existe";
	}

}
