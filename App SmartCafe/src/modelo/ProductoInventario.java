package modelo;

import enumeraciones.TipoProductoInventario;
import enumeraciones.UnidadMedida;

public class ProductoInventario{
	
	private String codigoBarras;
	private String nombreProducto;
	private TipoProductoInventario tipoProducto;
	private String marca;
	private double contenido;
	private UnidadMedida unidadMedida;
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public TipoProductoInventario getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProductoInventario tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getContenido() {
		return contenido;
	}
	public void setContenido(double contenido) {
		this.contenido = contenido;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

}
