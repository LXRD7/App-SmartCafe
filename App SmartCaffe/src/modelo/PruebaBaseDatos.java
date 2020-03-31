package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaBaseDatos {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/smartcafe";
	public static void main(String args[]) throws SQLException {
		final String usuario = "root";
		final String password = "serrato33";
		Connection dbConnection = null;
		Statement statement = null;
		try {
			Class.forName(DRIVER);
			Connection conexion = DriverManager.getConnection(URL_CONEXION, usuario, password);
			String selectTableSQL = "SELECT cve_caf,nom_caf,ubicacion from cafeteria";
			statement = conexion.createStatement();
			ResultSet rs = statement.executeQuery(selectTableSQL);
			while (rs.next()) {
				String clave = rs.getString("cve_caf");
				String nombre = rs.getString("nom_caf");
				String ubicacion = rs.getString("ubicacion");
				System.out.println("Clave : " + clave);
				System.out.println("Nombre : " + nombre);
				System.out.println("Ubicación : " + ubicacion);
			}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println(e.getMessage());
			} finally {
				if (statement != null) {
					statement.close();
				}
				if (dbConnection != null) {
					dbConnection.close();
				}
			}
		}

	}
