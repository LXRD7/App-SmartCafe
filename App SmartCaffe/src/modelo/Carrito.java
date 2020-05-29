package modelo;

import java.time.LocalDate;

public class Carrito {
	private int claveCarrito;
	private LocalDate fechaCarrito;
	
	public int getClaveCarrito() {
		return claveCarrito;
	}
	public void setClaveCarrito(int claveCarrito) {
		this.claveCarrito = claveCarrito;
	}
	public LocalDate getFechaCarrito() {
		return fechaCarrito;
	}
	public void setFechaCarrito(LocalDate fechaCarrito) {
		this.fechaCarrito = fechaCarrito;
	}
	
}
