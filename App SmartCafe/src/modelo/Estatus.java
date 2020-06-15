package modelo;

import java.time.LocalDate;

public class Estatus {
	private int numStatus;
	private LocalDate fecha;
	private String estatus;

	public int getNumStatus() {
		return numStatus;
	}
	public void setNumStatus(int numStatus) {
		this.numStatus = numStatus;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


}
