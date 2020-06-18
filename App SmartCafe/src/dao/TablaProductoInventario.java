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
private Connection conection;
private Statement statement;
public TablaProductoInventario(Connection conection) {
	this.conection = conection;
	try {
		statement = conection.createStatement();
	} catch (SQLException e) {
	e.toString();
	}
}
public boolean existeProductoInventario(String codigoBarras){
	String sql ="select* from producto_inv where cve_pin='"+codigoBarras+"'";
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
public String modificarProductoInventario(ProductoInventario p){
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(e.toString());
		return e.toString();
	}
}
public String eliminarProductoInventario(String codigoBarras){
	String sql2 ="SET FOREIGN_KEY_CHECKS=0";
	String sql3 ="SET FOREIGN_KEY_CHECKS=1";
	String sql ="delete from producto_inv where cve_pin="+codigoBarras;
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
public List<ProductoInventario> getProductosInventario(){
	
	String sql ="select * from producto_inv where cve_pin";
	try{
	ResultSet rs = statement.executeQuery(sql);
	List<ProductoInventario> lista = new ArrayList<ProductoInventario>();
	while (rs.next()) {
		ProductoInventario p = new ProductoInventario();
		p.setCodigoBarras(rs.getString("cve_pro"));
		p.setNombreProducto(rs.getString("nom_pro"));
		p.setTipoProducto(Conversor.convertirATipoProductoIventario(rs.getString("tipo_pro")));
		p.setMarca(rs.getString("pre_pro"));
		p.setContenido(rs.getDouble("contenido_pro"));
		p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_pro")));
		lista.add(p);
	} 
	return lista;
	}catch(SQLException e){
		return null;
	}
}
public List<ProductoInventario> getFiltro(String filtro){
	String sql ="select* from producto_inv where cve_pin like '"+filtro+"%'";
	try{
	ResultSet rs = statement.executeQuery(sql);
	List<ProductoInventario> lista = new ArrayList<ProductoInventario>();
	while (rs.next()) {
		ProductoInventario p = new ProductoInventario();
		p.setCodigoBarras(rs.getString("cve_pro"));
		p.setNombreProducto(rs.getString("nom_pro"));
		p.setTipoProducto(Conversor.convertirATipoProductoIventario(rs.getString("tipo_pro")));
		p.setMarca(rs.getString("pre_pro"));
		p.setContenido(rs.getDouble("contenido_pro"));
		p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_pro")));
		lista.add(p);
		
	} 
	return lista;
	}catch(SQLException e){
		e.toString();
		return null;
	}
}
public ProductoInventario getProductoInventario(String codigoBarras){
	String sql ="select* from producto_inv where cve_pin='"+codigoBarras+"'";
	try{
	ResultSet rs = statement.executeQuery(sql);
	if (rs.next()) {
		ProductoInventario p = new ProductoInventario();
		p.setCodigoBarras(rs.getString("cve_pro"));
		p.setNombreProducto(rs.getString("nom_pro"));
		p.setTipoProducto(Conversor.convertirATipoProductoIventario(rs.getString("tipo_pro")));
		p.setMarca(rs.getString("pre_pro"));
		p.setContenido(rs.getDouble("contenido_pro"));
		p.setUnidadMedida(Conversor.convertirAUnidadMedida(rs.getString("umedida_pro")));
		return p;
	} else {
return null;
	}
	}catch(SQLException e){
		e.toString();
		return null;
	}
}
public String registrarProductoInventario(ProductoInventario p){
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
