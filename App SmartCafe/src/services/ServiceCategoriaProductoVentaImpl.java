package services;

import java.util.List;

import api.ServiceCategoriaProductoVenta;
import dao.FuenteDatos;
import dao.TablaCategoriaProductoVenta;
import modelo.CategoriaProductoVenta;
import modelo.ProductoInventario;

public class ServiceCategoriaProductoVentaImpl implements ServiceCategoriaProductoVenta {
	private TablaCategoriaProductoVenta tablaCategoriaProductoVenta;

	public ServiceCategoriaProductoVentaImpl() {
		tablaCategoriaProductoVenta= new TablaCategoriaProductoVenta(FuenteDatos.getBaseDatos().getConexion());
	}

	@Override
	public String registrarCategoriaProductoVenta(CategoriaProductoVenta categoriaProductoVenta) {
		return tablaCategoriaProductoVenta.registrarCategoriaProductoVenta(categoriaProductoVenta);
	}

	@Override
	public CategoriaProductoVenta getCategoriaProductoVenta(int numProductoVenta) {
		return tablaCategoriaProductoVenta.getCategoriaProductoVenta(numProductoVenta);
	}

	@Override
	public List<CategoriaProductoVenta> getCategoriasProductoVenta() {
		return tablaCategoriaProductoVenta.getCategoriasProductoVenta();
	}

	@Override
	public int eliminarCategoriaProductoVenta(int numProductoVenta) {
		return tablaCategoriaProductoVenta.eliminarCategoriaProductoVenta(numProductoVenta);
	}

	@Override
	public String modificarCategoriaProductoVenta(CategoriaProductoVenta categoriaProductoVenta) {
		if(tablaCategoriaProductoVenta.existeCategoriaProductoVenta(categoriaProductoVenta.getNumProductoVenta()))
			return tablaCategoriaProductoVenta.modificarCategoriaProductoVenta(categoriaProductoVenta);
		else
			return "La categoria producto no existe.";
			
	}
	
}
