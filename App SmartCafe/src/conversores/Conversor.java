package conversores;

import java.time.LocalDate;

import enumeraciones.TipoProductoInventario;
import enumeraciones.UnidadMedida;

public class Conversor {
	public static TipoProductoInventario convertirATipoProductoIventario(String tipoProducto) {
		switch (tipoProducto) {
		case "cafe":
			return TipoProductoInventario.CAFE;
		case "postre":
			return TipoProductoInventario.POSTRE;
		case "endulzante":
			return TipoProductoInventario.ENDULZANTE;
		case "otro":
			return TipoProductoInventario.OTRO;
		default:
			throw new IllegalArgumentException("Unexpected value: " + tipoProducto);
		}
	}

	public static UnidadMedida convertirAUnidadMedida(String unidadMedida) {
		switch (unidadMedida) {
		case "unidad":
			return UnidadMedida.UNIDAD;
		case "kilo":
			return UnidadMedida.KILO;
		case "gramo":
			return UnidadMedida.GRAMO;
		case "litro":
			return UnidadMedida.LITRO;
		case "mililitro":
			return UnidadMedida.MILILITRO;
		case "porcion":
			return UnidadMedida.PORCION;
		default:
			throw new IllegalArgumentException("Unexpected value: " + unidadMedida);
		}
	}
	public static LocalDate convertirAFecha(String fecha) {
		return LocalDate.parse(fecha);
	}
}
