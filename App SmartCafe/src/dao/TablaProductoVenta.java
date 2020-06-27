package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.ProductoInventario;
import modelo.ProductoVenta;

public class TablaProductoVenta {
	private Connection conexion;
	private Statement statement;

	public TablaProductoVenta(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaProductoVenta");
			e.printStackTrace();
		}
	}

	public boolean existeProductoVenta(String codigoBarras){
		String sql ="select* from producto_ven where cve_pve='"+codigoBarras+"'";
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

	public String modificarProductoVenta(ProductoVenta p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE producto_ven SET nom_pve='"+p.getNombreProducto()+"', tipo_pve='"+p.getTipoProducto()+"',precio_pve='"+p.getPrecio()+"',contenido_pve='"+p.getContenido()+"',umedida_pve='"+p.getUnidadMedida()+ "' WHERE cve_pve='"+p.getCodigoBarras();	
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

	public int eliminarProductoVenta(String codigoBarras){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from producto_ven where cve_pve="+codigoBarras;
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

	public List<ProductoVenta> getProductosVenta(){
		String sql ="select * from producto_ven where cve_ven";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<ProductoVenta> lista = new ArrayList<ProductoVenta>();
			while (rs.next()) {
				ProductoVenta p = new ProductoVenta();
				p.setCodigoBarras(rs.getString("cve_pve"));
				p.setNombreProducto(rs.getString("nom_pve"));
				p.setTipoProducto(Conversor.convertirATipoProductoIventario(rs.getString("tipo_pve")));
				p.setPrecio(rs.getDouble("precio_pve"));
				p.setContenido(rs.getDouble("contenido_pve"));
				p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_pve")));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public ProductoVenta getProductoVenta(String codigoBarras){
		String sql ="select* from producto_ven where cve_pve='"+codigoBarras+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				ProductoVenta p = new ProductoVenta();
				p.setCodigoBarras(rs.getString("cve_pve"));
				p.setNombreProducto(rs.getString("nom_pve"));
				p.setTipoProducto(Conversor.convertirATipoProductoIventario(rs.getString("tipo_pve")));
				p.setPrecio(rs.getDouble("precio_pve"));
				p.setContenido(rs.getDouble("contenido_pve"));
				p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_pve")));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}
//hola
	public String registrarProductoVenta(ProductoVenta p){
		String sql = "insert into producto_ven values('"+p.getCodigoBarras()+"','"+p.getNombreProducto()+"','"+p.getTipoProducto()+"',precio_pve='"+p.getPrecio()+"','"+p.getContenido()+"','"+p.getUnidadMedida()+"')";
		try {
			statement.executeUpdate(sql);
			return "Producto Venta registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
