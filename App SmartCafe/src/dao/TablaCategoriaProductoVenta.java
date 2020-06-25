package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.CategoriaProductoVenta;
import modelo.ProductoInventario;

public class TablaCategoriaProductoVenta {
	private Connection conexion;
	private Statement statement;

	public TablaCategoriaProductoVenta(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaCategoriaProductoVenta");
			e.printStackTrace();
		}
	}

	public boolean existeCategoriaProductoVenta(int numProductoVenta){
		String sql ="select* from catproducto_ven where num_catpve='"+numProductoVenta+"'";
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

	public String modificarCategoriaProductoVenta(CategoriaProductoVenta p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE catproducto_ven SET num_catpve='"+p.getNumProductoVenta();	
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

	public int eliminarCategoriaProductoVenta(int numProductoVenta){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from catproducto_ven where num_catpve="+numProductoVenta;
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

	public List<CategoriaProductoVenta> getCategoriasProductoVenta(){
		String sql ="select * from catproducto_ven where num_catpve";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<CategoriaProductoVenta> lista = new ArrayList<CategoriaProductoVenta>();
			while (rs.next()) {
				CategoriaProductoVenta p = new CategoriaProductoVenta();
				p.setNumProductoVenta(rs.getInt("num_catpve"));
			
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public CategoriaProductoVenta getCategoriaProductoVenta(int numProductoVenta){
		String sql ="select* from catproducto_ven where num_catpve='"+numProductoVenta+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				CategoriaProductoVenta p = new CategoriaProductoVenta();
				p.setNumProductoVenta(rs.getInt("num_catpve"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarCategoriaProductoVenta(CategoriaProductoVenta p){
		String sql = "insert into catproducto_ven values('"+p.getNumProductoVenta()+"')";
		try {
			statement.executeUpdate(sql);
			return "CategoriaProductoVenta registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
