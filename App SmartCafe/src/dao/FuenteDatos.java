package dao;

public class FuenteDatos {
	private static BaseDatos baseDatos;


	public static BaseDatos getBaseDatos() {
		if (baseDatos==null) {
			baseDatos=new BaseDatos("smartcafe","root", "toor");
			baseDatos.setDriver("com.mysql.jdbc.Driver");
			baseDatos.setProtocolo("jdbc:mysql://localhost/");

			System.out.println("Conectado a la base "+baseDatos.hacerConexion());
		}
		return baseDatos;
	}


}