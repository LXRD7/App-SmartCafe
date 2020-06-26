package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Mesa;
import modelo.ProductoInventario;

public class TablaMesa {
	private Connection conexion;
	private Statement statement;

	public TablaMesa(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaMesa");
			e.printStackTrace();
		}
	}

	public boolean existeMesa(int claveMesa){
		String sql ="select* from mesa where cve_mes='"+claveMesa+"'";
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

	public String modificarMesa(Mesa p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE mesa SET tipo_mesa='"+p.getTipoMesa()+"', status_mes='"+p.getStatusMesa()+ "' WHERE cve_mes='"+p.getClaveMesa();	
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

	public int eliminarMesa(int claveMesa){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from mesa where cve_mes="+claveMesa;
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

	public List<Mesa> getMesas(){
		String sql ="select * from mesa where cve_mes";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<Mesa> lista = new ArrayList<Mesa>();
			while (rs.next()) {
				Mesa p = new Mesa();
				p.setClaveMesa(rs.getInt("cve_mes"));
				p.setTipoMesa(rs.getString("tipo_mes"));
				p.setStatusMesa(rs.getString("status_mesa"));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public Mesa getMesa(int claveMesa){
		String sql ="select* from mesa where cve_mes='"+claveMesa+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Mesa p = new Mesa();
				p.setClaveMesa(rs.getInt("cve_mes"));
				p.setTipoMesa(rs.getString("tipo_mes"));
				p.setStatusMesa(rs.getString("status_mes"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarMesa(Mesa p){
		String sql = "insert into mesa values('"+p.getClaveMesa()+"','"+p.getTipoMesa()+"')";
		try {
			statement.executeUpdate(sql);
			return "Mesa registrada.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
