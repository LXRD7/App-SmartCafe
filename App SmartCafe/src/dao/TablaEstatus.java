package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Estatus;
import modelo.ProductoInventario;

public class TablaEstatus {
	private Connection conexion;
	private Statement statement;

	public TablaEstatus(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en la TablaEstatus");
			e.printStackTrace();
		}
	}

	public boolean existeEstatus(int numStatus){
		String sql ="select* from status where num_sta='"+numStatus+"'";
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

	public String modificarEstatus(Estatus p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE status SET fecha_sta='"+p.getFecha()+"', estatus_sta='"+p.getEstatus()+ "' WHERE num_sta='"+p.getNumStatus();	
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

	public int eliminarEstatus(int numStatus){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from status where num_sta="+numStatus;
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

	public List<Estatus> getEstatus1(){
		String sql ="select * from status where num_sta";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<Estatus> lista = new ArrayList<Estatus>();
			while (rs.next()) {
				Estatus p = new Estatus();
				p.setNumStatus(rs.getInt("num_sta"));
				p.setFecha(Conversor.convertirAFecha(rs.getString("fecha_sta")));
				p.setEstatus(rs.getString("status_sta"));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public Estatus getEstatus(int numStatus){
		String sql ="select* from status where num_sta='"+numStatus+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Estatus p = new Estatus();
				p.setNumStatus(rs.getInt("num_sta"));
				p.setFecha(Conversor.convertirAFecha(rs.getString("fecha_sta")));
				p.setEstatus(rs.getString("status_sta"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarEstatus(Estatus p){
		String sql = "insert into status values('"+p.getNumStatus()+"','"+p.getFecha()+"','"+p.getEstatus()+"')";
		try {
			statement.executeUpdate(sql);
			return "Estatus registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
