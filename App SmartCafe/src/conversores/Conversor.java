package conversores;

import java.time.LocalDate;

import enumeraciones.TipoProducto;
import enumeraciones.UnidadMedida;

public class Conversor {
	public static TipoProducto convertirATipoProductoIventario(String tipoProducto) {
		switch (tipoProducto) {
		case "cafe":
			return TipoProducto.CAFE;
		case "postre":
			return TipoProducto.POSTRE;
		case "endulzante":
			return TipoProducto.ENDULZANTE;
		case "otro":
			return TipoProducto.OTRO;
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
