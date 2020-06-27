package modelo;

import java.time.LocalDate;

public class Precio {
	private int clavePrecio;
	private LocalDate fechaPrecio;
	private double precio;
	private String codigoBarras;
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public int getClavePrecio() {
		return clavePrecio;
	}
	public void setClavePrecio(int clavePrecio) {
		this.clavePrecio = clavePrecio;
	}
	public LocalDate getFechaPrecio() {
		return fechaPrecio;
	}
	public void setFechaPrecio(LocalDate fechaPrecio) {
		this.fechaPrecio = fechaPrecio;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}