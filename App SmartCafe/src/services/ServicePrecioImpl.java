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
	public Precio getPrecio(String codigoBarras) {
		return tablaPrecio.getPrecio(codigoBarras);
	}

	@Override
	public List<Precio> getPrecios() {
		return tablaPrecio.getPrecios();
	}
}
