package modelo;

public class ProductoResurtir {
	
	private String codigoBarras;
	private String nombreProducto;
	private String marca;
	private String unidadMedida;
	private double contenido;
	private String tipo;
	private String presentacion;
	private String descripcion;
	private double utilidad;
	private String urlImage;

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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public double getContenido() {
		return contenido;
	}
	public void setContenido(double contenido) {
		this.contenido = contenido;
	}
	public double getUtilidad() {
		return utilidad;
	}
	public void setUtilidad(double utilidad) {
		this.utilidad = utilidad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getPresentacion() {
		return presentacion;
	}
	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Producto [codigoBarras=" + codigoBarras + ", nombreProducto=" + nombreProducto + ", marca=" + marca
				+ ", unidadMedida=" + unidadMedida + ", contenido=" + contenido + ", tipo=" + tipo + ", presentacion="
				+ presentacion + ", descripcion=" + descripcion + "]";
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
}
