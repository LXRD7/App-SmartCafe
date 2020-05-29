package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.ProductoResurtir;

public class TablaProducto {
private Connection conection;
private Statement statement;
public TablaProducto(Connection conection) {
	this.conection = conection;
	try {
		statement = conection.createStatement();
	} catch (SQLException e) {
	e.toString();
	}
}
public boolean existe(String codigoBarras){
	String sql ="select* from producto where codbar_pro='"+codigoBarras+"'";
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
public String modificar(ProductoResurtir p){
	String sql2 ="SET FOREIGN_KEY_CHECKS=0";
	String sql3 ="SET FOREIGN_KEY_CHECKS=1";
String sql = "UPDATE producto SET nom_pro='"+p.getNombreProducto()+"', pre_pro='"+p.getPresentacion()+"', tipo_pro='"+p.getTipo()+"',contenido_pro="+p.getContenido()+",umedida_pro='"+p.getUnidadMedida()+"', marca_pro='"+p.getMarca()+"', utilidad="+p.getUtilidad()+",imagen_pro='"+p.getUrlImage()+"'"+ "WHERE codbar_pro="+p.getCodigoBarras();	
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
public String eliminar(String codigoBarras){
	String sql2 ="SET FOREIGN_KEY_CHECKS=0";
	String sql3 ="SET FOREIGN_KEY_CHECKS=1";
	String sql ="delete from producto where codbar_pro="+codigoBarras;
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
public List<ProductoResurtir> getProductos(){
	
	String sql ="select* from producto where codbar_pro";
	try{
	ResultSet rs = statement.executeQuery(sql);
	List<ProductoResurtir> lista = new ArrayList<ProductoResurtir>();
	while (rs.next()) {
		ProductoResurtir p = new ProductoResurtir();
		p.setCodigoBarras(rs.getString("codbar_pro"));
		p.setNombreProducto(rs.getString("nom_pro"));
		p.setTipo(rs.getString("tipo_pro"));
		p.setPresentacion(rs.getString("pre_pro"));
		p.setContenido(rs.getDouble("contenido_pro"));
		p.setUnidadMedida(rs.getString("umedida_pro"));
		p.setMarca(rs.getString("marca_pro"));
		p.setUtilidad(rs.getDouble("utilidad"));
		p.setUrlImage(rs.getString("imagen_pro"));
		lista.add(p);
	} 
	return lista;
	}catch(SQLException e){
		return null;
	}
}
public List<ProductoResurtir> getFiltro(String filtro){
//	SELECT* from producto where codbar_pro like 'perro%';
	String sql ="select* from producto where codbar_pro like '"+filtro+"%'";
	try{
	ResultSet rs = statement.executeQuery(sql);
	List<ProductoResurtir> lista = new ArrayList<ProductoResurtir>();
	while (rs.next()) {
		ProductoResurtir p = new ProductoResurtir();
		p.setCodigoBarras(rs.getString("codbar_pro"));
		p.setNombreProducto(rs.getString("nom_pro"));
		p.setTipo(rs.getString("tipo_pro"));
		p.setPresentacion(rs.getString("pre_pro"));
		p.setContenido(rs.getDouble("contenido_pro"));
		p.setUnidadMedida(rs.getString("umedida_pro"));
		p.setMarca(rs.getString("marca_pro"));
		p.setUtilidad(rs.getDouble("utilidad"));
		p.setUrlImage(rs.getString("imagen_pro"));
		lista.add(p);
		
	} 
	return lista;
	}catch(SQLException e){
		e.toString();
		return null;
	}
}
public ProductoResurtir getProducto(String codigoBarras){
	String sql ="select* from producto where codbar_pro='"+codigoBarras+"'";
	try{
	ResultSet rs = statement.executeQuery(sql);
	if (rs.next()) {
		ProductoResurtir p = new ProductoResurtir();
		p.setCodigoBarras(rs.getString("codbar_pro"));
		p.setNombreProducto(rs.getString("nom_pro"));
		p.setTipo(rs.getString("tipo_pro"));
		p.setPresentacion(rs.getString("pre_pro"));
		p.setContenido(rs.getDouble("contenido_pro"));
		p.setUnidadMedida(rs.getString("umedida_pro"));
		p.setMarca(rs.getString("marca_pro"));
		p.setUtilidad(rs.getDouble("utilidad"));
		p.setUrlImage(rs.getString("imagen_pro"));
		
		return p;
	} else {
return null;
	}
	}catch(SQLException e){
		e.toString();
		return null;
	}
}
public String guardar (ProductoResurtir p){
	System.out.println(p.getUrlImage());
	String sql = "insert into producto values('"+p.getCodigoBarras()+"','"+p.getNombreProducto()+"','"+p.getTipo()+"','"+p.getPresentacion()+"','"+p.getContenido()+"','"+p.getUnidadMedida()+"','"+p.getMarca()+"','"+p.getUtilidad()+"','"+p.getUrlImage()+"')";
try {
	statement.executeUpdate(sql);
	return "Producto registrado.";
} catch (Exception e) {
	System.out.println(e.toString());
	return e.toString();
}
}
}
