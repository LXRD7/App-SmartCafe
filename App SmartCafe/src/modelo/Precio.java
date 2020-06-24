package modelo;

import java.time.LocalDate;

public class Precio {
	private int clavePrecio;
	private LocalDate fechaPrecio;
	private int precio;
	
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
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	
}