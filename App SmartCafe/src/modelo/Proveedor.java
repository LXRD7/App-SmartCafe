package modelo;

public class Proveedor {
	private int claveProveedor;
	private String razonSocial;
	private String calle;
	private String telefono;
	private String email;
	
	public int getClaveProveedor() {
		return claveProveedor;
	}
	public void setClaveProveedor(int claveProveedor) {
		this.claveProveedor = claveProveedor;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
