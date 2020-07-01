package modelo;

import java.time.LocalDate;
import java.util.Date;

public class Resurtir {
	private int numResurtir;
	private LocalDate fechaResurtir;
	private int precioUnidad;
	private LocalDate fechaCaducidad;
	private int lote;
	private int baja;
	private String codigoBarras;
	private int claveProveedor;
	
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public int getClaveProveedor() {
		return claveProveedor;
	}
	public void setClaveProveedor(int claveProveedor) {
		this.claveProveedor = claveProveedor;
	}
	public int getNumResurtir() {
		return numResurtir;
	}
	public void setNumResurtir(int numResurtir) {
		this.numResurtir = numResurtir;
	}
	public LocalDate getFechaResurtir() {
		return fechaResurtir;
	}
	public void setFechaResurtir(LocalDate fechaResurtir) {
		this.fechaResurtir = fechaResurtir;
	}
	public int getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(int precioUnidad) {
		this.precioUnidad = precioUnidad;
	}
	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}
	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	public int getLote() {
		return lote;
	}
	public void setLote(int lote) {
		this.lote = lote;
	}
	public int getBaja() {
		return baja;
	}
	public void setBaja(int baja) {
		this.baja = baja;
	}
	
	
}
