package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Precio;
import modelo.ProductoInventario;

public class TablaPrecio {
	private Connection conexion;
	private Statement statement;

	public TablaPrecio(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en la TablaPrecio");
			e.printStackTrace();
		}
	}

	public boolean existePrecio(int clavePrecio){
		String sql ="select* from precio where cve_pre='"+clavePrecio+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		}catch(SQLException e){
			return false;
		}
	}

	public String modificarPrecio(Precio p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE precio SET fecha_pre='"+p.getFechaPrecio()+"', precio_pre='"+p.getPrecio()+ "' WHERE cve_pre='"+p.getClavePrecio();	
		try{
			statement.executeUpdate(sql2);
			int n = statement.executeUpdate(sql);
			statement.executeUpdate(sql3);
			if(n==1){
				return "exito.";
			} else {
				return "error.";
			}
		}catch(SQLException e){
			try {
				statement.executeUpdate(sql3);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.toString());
			return e.toString();
		}
	}

	public int eliminarPrecio(int clavePrecio){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from precio where cve_pre="+clavePrecio;
		try{
			statement.executeUpdate(sql2);
			int n = statement.executeUpdate(sql);
			statement.executeUpdate(sql3);
			if(n==1){
				return 1;
			} else {
				return 0;
			}
		}catch(SQLException e){
			try {
				statement.executeUpdate(sql3);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			System.out.println(e.toString());
			return 0;
		}
	}

	public List<Precio> getPrecios(){
		String sql ="select * from precio";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<Precio> lista = new ArrayList<Precio>();
			while (rs.next()) {
				Precio p = new Precio();
				p.setClavePrecio(rs.getInt("cve_pre"));
				p.setFechaPrecio(Conversor.convertirAFecha(rs.getString("fecha_pre")));
				p.setPrecio(rs.getInt("cve_pre"));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public Precio getPrecio(String codigoBarras){
		String sql ="select * from precio where cve_pin='"+codigoBarras+"' and fecha_pre=(select max(fecha_pre) from precio where cve_pin='"+codigoBarras+"')";
		System.out.println(sql);
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Precio p = new Precio();
				p.setClavePrecio(rs.getInt("cve_pre"));
				p.setFechaPrecio(Conversor.convertirAFecha(rs.getString("fecha_pre")));
				p.setPrecio(rs.getDouble("cve_pre"));				
				p.setCodigoBarras(rs.getString("cve_pin"));
				System.out.println(p.getClavePrecio());
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarPrecio(Precio p){
		String sql = "insert into precio values('null','"+p.getFechaPrecio()+"',"+p.getPrecio()+",'"+p.getCodigoBarras()+"')";
		try {
			statement.executeUpdate(sql);
			return "Precio registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
