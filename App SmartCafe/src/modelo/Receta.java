package modelo;

import enumeraciones.UnidadMedida;

public class Receta {
	private int claveReceta;
	private int cantidad;
	private UnidadMedida unidadMedida;
	
	public int getClaveReceta() {
		return claveReceta;
	}
	public void setClaveReceta(int claveReceta) {
		this.claveReceta = claveReceta;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public UnidadMedida getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(UnidadMedida unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
}
