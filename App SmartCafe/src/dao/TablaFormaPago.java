package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.FormaPago;
import modelo.ProductoInventario;

public class TablaFormaPago {
	private Connection conexion;
	private Statement statement;

	public TablaFormaPago(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaFormaPago");
			e.printStackTrace();
		}
	}

	public boolean existeProducto(int claveFormaPago){
		String sql ="select* from producto_inv where cve_fop='"+claveFormaPago+"'";
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

	public String modificarProducto(FormaPago p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE formapago SET tipopago_fop='"+p.getTipoFormaPago()+ "' WHERE cve_fop='"+p.getClaveFormaPago();	
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

	public int eliminarFormaPago(int claveFormaPago){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from formapago where cve_fop="+claveFormaPago;
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
	public List<FormaPago> getFormaPago(){
		String sql ="select * from forma_pag where cve_fop";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<FormaPago> lista = new ArrayList<FormaPago>();
			while (rs.next()) {
				FormaPago p = new FormaPago();
				p.setClaveFormaPago(rs.getInt("cve_fop"));
				p.setTipoFormaPago(rs.getString("nom_pro"));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public FormaPago getFormaPago(int claveFormaPago){
		String sql ="select* from formapago where cve_fop='"+claveFormaPago+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				FormaPago p = new FormaPago();
				p.setClaveFormaPago(rs.getInt("cve_fop"));
				p.setTipoFormaPago(rs.getString("nom_pro"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarFormaPago(FormaPago p){
		String sql = "insert into formapago values('"+p.getClaveFormaPago()+"','"+p.getTipoFormaPago()+"')";
		try {
			statement.executeUpdate(sql);
			return "Forma de Pago registrada.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
