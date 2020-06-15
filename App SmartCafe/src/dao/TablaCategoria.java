package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Categoria;

public class TablaCategoria {
	private Connection conection;
	private Statement statement;
	
	public TablaCategoria(Connection conection) {
		this.conection = conection;
		try {
			statement = conection.createStatement();
		} catch (SQLException e) {
			e.toString();
		}
	}
	public boolean existe(String clave){
		String sql ="select* from producto where cve_cat='"+clave+"'";
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
	public String modificar(Categoria p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE producto SET cve_cat='"+p.getClaveCategoria()+"', nom_cat='"+p.getNombreCategoria();	
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
}
