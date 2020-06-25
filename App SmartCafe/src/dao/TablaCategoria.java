package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.Categoria;
import modelo.ProductoInventario;

public class TablaCategoria {
	private Connection conection;
	private Statement statement;

	public TablaCategoria(Connection conection) {
		this.conection = conection;
		try {
			statement = conection.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaCategoria");
			e.toString();
		}
	}
	public boolean existeCategoria(int claveCategoria){
		String sql ="select* from categoria where cve_cat='"+claveCategoria+"'";
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
	public String modificarCategoria(Categoria p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE categoria SET cve_cat='"+p.getClaveCategoria()+"', nom_cat='"+p.getNombreCategoria();	
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e.toString());
			return e.toString();
		}
	}
	public int eliminarCategoria(int claveCategoria){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from categoria where cve_cat="+claveCategoria;
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

	public List<Categoria> getCategorias(){
		String sql ="select * from categoria where cve_cat";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<Categoria> lista = new ArrayList<Categoria>();
			while (rs.next()) {
				Categoria p = new Categoria();
				p.setClaveCategoria(rs.getInt("cve_cat"));
				p.setNombreCategoria(rs.getString("nom_cat"));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public Categoria getCategoria(int claveCategoria){
		String sql ="select* from categoria where cve_cat='"+claveCategoria+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Categoria p = new Categoria();
				p.setClaveCategoria(rs.getInt("cve_cat"));
				p.setNombreCategoria(rs.getString("nom_cat"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarCategoria(Categoria p){
		String sql = "insert into categoria values('"+p.getClaveCategoria()+"','"+p.getNombreCategoria()+"')";
		try {
			statement.executeUpdate(sql);
			return "Categoria registrada.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}


}