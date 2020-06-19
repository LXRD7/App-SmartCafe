package modelo;

import java.time.LocalDate;

public class Ticket {
	private int claveTicket;
	private LocalDate fecha;
	private String descripcion;
	private int total;
	
	public int getClaveTicket() {
		return claveTicket;
	}
	public void setClaveTicket(int claveTicket) {
		this.claveTicket = claveTicket;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
