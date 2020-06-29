package modelo;

import enumeraciones.TipoProductoVenta;
import enumeraciones.UnidadMedida;

public class ProductoVenta{
	
	private String codigoBarras;
	private String nombreProducto;
	private TipoProductoVenta tipoProductoVenta;
	private double precio;
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
	public TipoProductoVenta getTipoProductoVenta() {
		return tipoProductoVenta;
	}
	public void setTipoProductoVenta(TipoProductoVenta tipoProducto) {
		this.tipoProductoVenta = tipoProducto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
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
