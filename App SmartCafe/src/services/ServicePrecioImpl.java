package services;

import java.util.List;

import api.ServicePrecio;
import dao.TablaPrecio;
import modelo.Precio;

public class ServicePrecioImpl implements ServicePrecio{
	private TablaPrecio tablaPrecio;

	@Override
	public String registrarPrecio(Precio precio) {
		return tablaPrecio.registrarPrecio(precio);
	}

	@Override
	public Precio getPrecio(int clavePrecio) {
		return tablaPrecio.getPrecio(clavePrecio);
	}

	@Override
	public List<Precio> getPrecios() {
		return tablaPrecio.getPrecios();
	}

	@Override
	public int eliminarPrecio(int clavePrecio) {
		return tablaPrecio.eliminarPrecio(clavePrecio);
	}

	@Override
	public String modificarPrecio(Precio precio) {
		if(tablaPrecio.existePrecio(precio.getPrecio()))
			return tablaPrecio.modificarPrecio(precio);
		else
			return "El precio no existe";
	}
	@Override
	public boolean existePrecio(int clavePrecio) {
		return tablaPrecio.existePrecio(clavePrecio);
	}

}
