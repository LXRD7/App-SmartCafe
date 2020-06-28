package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.ProductoInventario;
import modelo.Proveedor;

public class TablaProveedor {
	private Connection conexion;
	private Statement statement;

	public TablaProveedor(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaProveedor");
			e.printStackTrace();
		}
	}

	public boolean existeProveedor(int claveProveedor){
		String sql ="select* from proveedor where cve_prov='"+claveProveedor+"'";
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

	public String modificarProveedor(Proveedor p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE proveedor SET razonsoc_prov='"+p.getRazonSocial()+"', calle_prov='"+p.getCalle()+"', tel_prov='"+p.getTelefono()+"',email_prov='"+p.getEmail()+ "' WHERE cve_prov='"+p.getClaveProveedor();	
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

	public int eliminarProveedor(int claveProveedor){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from proveedor where cve_prov="+claveProveedor;
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

	public List<Proveedor> getProveedores(){
		String sql ="select * from proveedor where cve_prov";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<Proveedor> lista = new ArrayList<Proveedor>();
			while (rs.next()) {
				Proveedor p = new Proveedor();
				p.setClaveProveedor(rs.getInt("cve_prov"));
				p.setRazonSocial(rs.getString("razonsoc_prov"));
				p.setCalle(rs.getString("calle_prov"));
				p.setTelefono(rs.getString("tel_prov"));
				p.setEmail(rs.getString("email_prov"));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public Proveedor getProveedor(int claveProveedor){
		String sql ="select* from proveedor where cve_prov='"+claveProveedor+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Proveedor p = new Proveedor();
				p.setClaveProveedor(rs.getInt("cve_prov"));
				p.setRazonSocial(rs.getString("razonsoc_prov"));
				p.setCalle(rs.getString("calle_prov"));
				p.setTelefono(rs.getString("tel_prov"));
				p.setEmail(rs.getString("email_prov"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarProveedor(Proveedor p){
		String sql = "insert into proveedor values('"+p.getClaveProveedor()+"','"+p.getRazonSocial()+"','"+p.getCalle()+"','"+p.getTelefono()+"','"+p.getEmail()+"')";
		try {
			statement.executeUpdate(sql);
			return "Proveedor registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
