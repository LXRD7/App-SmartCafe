package modelo;

import enumeraciones.EnumCategoria;
import enumeraciones.Presentacion;
import enumeraciones.Tamanio;

public class ProductoVenta {
	private int claveVenta;
	private EnumCategoria categoria;
	private int precio;
	private Tamanio tamanio;
	private Presentacion presentacion;
	private String urlImage;
	public int getClaveVenta() {
		return claveVenta;
	}
	public void setClaveVenta(int claveVenta) {
		this.claveVenta = claveVenta;
	}
	public EnumCategoria getCategoria() {
		return categoria;
	}
	public void setCategoria(EnumCategoria categoria) {
		this.categoria = categoria;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public Tamanio getTamanio() {
		return tamanio;
	}
	public void setTamanio(Tamanio tamanio) {
		this.tamanio = tamanio;
	}
	public Presentacion getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	@Override
	public String toString() {
		return "ProductoVenta [claveVenta=" + claveVenta + ", categoria=" + categoria + ", precio=" + precio
				+ ", tamanio=" + tamanio + ", presentacion=" + presentacion + ", urlImage=" + urlImage + "]";
	}

	
	
}
