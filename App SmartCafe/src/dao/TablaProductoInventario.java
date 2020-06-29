package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.ProductoInventario;

public class TablaProductoInventario {
	private Connection conexion;
	private Statement statement;

	public TablaProductoInventario(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaProductoInventario");
			e.printStackTrace();
		}
	}

	public boolean existeProducto(String codigoBarras){
		String sql ="select * from producto_inv where cve_pin='"+codigoBarras+"'";
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

	public String modificarProducto(ProductoInventario p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE producto_inv SET nom_pin='"+p.getNombreProducto()+"', tipo_pin='"+p.getTipoProducto()+"', marca_pin='"+p.getMarca()+"',contenido_pin='"+p.getContenido()+"',umedida_pin='"+p.getUnidadMedida()+ "' WHERE cve_pin='"+p.getCodigoBarras();	
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

	public int eliminarProducto(String codigoBarras){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from producto_inv where cve_pin="+codigoBarras;
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

	public List<ProductoInventario> getProductos(){
		String sql ="select * from producto_inv";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<ProductoInventario> lista = new ArrayList<>();
			while (rs.next()) {
				ProductoInventario p = new ProductoInventario();
				p.setCodigoBarras(rs.getString("cve_pin"));
				p.setNombreProducto(rs.getString("nom_pin"));
				p.setTipoProducto(Conversor.convertirATipoProductoIventario(rs.getString("tipo_pin")));
				p.setMarca(rs.getString("marca_pin"));
				p.setContenido(rs.getDouble("contenido_pin"));
				p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_pin")));
				lista.add(p);
			}
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public ProductoInventario getProducto(String codigoBarras){
		String sql ="select* from producto_inv where cve_pin='"+codigoBarras+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				ProductoInventario p = new ProductoInventario();
				p.setCodigoBarras(rs.getString("cve_pin"));
				p.setNombreProducto(rs.getString("nom_pin"));
				p.setTipoProducto(Conversor.convertirATipoProductoIventario(rs.getString("tipo_pin")));
				p.setMarca(rs.getString("marca_pin"));
				p.setContenido(rs.getDouble("contenido_pin"));
				p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_pin")));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarProducto(ProductoInventario p){
		String sql = "insert into producto_inv values('"+p.getCodigoBarras()+"','"+p.getNombreProducto()+"','"+p.getTipoProducto()+"','"+p.getMarca()+"','"+p.getContenido()+"','"+p.getUnidadMedida()+"')";
		try {
			statement.executeUpdate(sql);
			return "Producto registrado en el Inventario.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
