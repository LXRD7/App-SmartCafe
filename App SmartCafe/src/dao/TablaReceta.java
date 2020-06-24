package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.ProductoInventario;
import modelo.Receta;

public class TablaReceta {
	private Connection conexion;
	private Statement statement;

	public TablaReceta(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaReceta");
			e.printStackTrace();
		}
	}

	public boolean existeReceta(int claveReceta){
		String sql ="select* from receta where cve_rec='"+claveReceta+"'";
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

	public String modificarReceta(Receta p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE receta SET cantidad_rec='"+p.getCantidad()+"', umedida_rec='"+p.getUnidadMedida()+ "' WHERE cve_rec='"+p.getClaveReceta();	
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

	public int eliminarReceta(int claveReceta){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from receta where cve_rec="+claveReceta;
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.toString());
			return 0;
		}
	}

	public List<Receta> getRecetas(){
		String sql ="select * from receta where cve_rec";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<Receta> lista = new ArrayList<Receta>();
			while (rs.next()) {
				Receta p = new Receta();
				p.setClaveReceta(rs.getInt("cve_rec"));
				p.setCantidad(rs.getInt("cantidad"));
				p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_rec")));
			
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public Receta getReceta(int claveReceta){
		String sql ="select* from receta where cve_rec='"+claveReceta+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Receta p = new Receta();
				p.setClaveReceta(rs.getInt("cve_rec"));
				p.setCantidad(rs.getInt("cantidad"));
				p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_rec")));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarReceta(Receta p){
		String sql = "insert into receta values('"+p.getClaveReceta()+"','"+p.getCantidad()+"','"+p.getUnidadMedida()+"')";
		try {
			statement.executeUpdate(sql);
			return "Receta registrada.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
