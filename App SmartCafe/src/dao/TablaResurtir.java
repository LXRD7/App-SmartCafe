package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.ProductoInventario;
import modelo.Resurtir;

public class TablaResurtir {
	private Connection conexion;
	private Statement statement;
	
	public TablaResurtir(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaResurtir");
			e.printStackTrace();
		}
	}

	public boolean existeResurtir(int numResurtir){
		String sql ="select* from resurtir where num_res='"+numResurtir+"'";
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

	public String modificarResurtir(Resurtir r){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE resurtir SET fecha_res='"+java.sql.Date.valueOf(r.getFechaResurtir())+"', ppu_res='"+r.getPrecioUnidad()+"', fcaducidad_res='"+java.sql.Date.valueOf(r.getFechaCaducidad())+"',lote_res='"+r.getLote()+"',baja_res='"+r.getBaja()+ "' WHERE num_res='"+r.getNumResurtir();	
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

	public int eliminarResurtir(int numResurtir){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from resurtir where num_res="+numResurtir;
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

	public List<Resurtir> getResurtidos(){
		String sql ="select * from resurtir where num_res";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<Resurtir> lista = new ArrayList<Resurtir>();
			while (rs.next()) {
				Resurtir r = new Resurtir();
				r.setNumResurtir(rs.getInt("num_res"));
				r.setFechaResurtir(Conversor.convertirAFecha(rs.getDate("fecha_res")));
				r.setPrecioUnidad(rs.getInt("ppu_res"));
				r.setFechaCaducidad(Conversor.convertirAFecha(rs.getDate("fcaducidad_res")));
				r.setLote(rs.getInt("lote_res"));
				r.setBaja(rs.getInt("baja_res"));
				lista.add(r);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public Resurtir getResurtir(int numResurtir){
		String sql ="select* from resurtir where num_res='"+numResurtir+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Resurtir r = new Resurtir();
				r.setNumResurtir(rs.getInt("num_res"));
				r.setFechaResurtir(Conversor.convertirAFecha(rs.getDate("fecha_res")));
				r.setPrecioUnidad(rs.getInt("ppu_res"));
				r.setFechaCaducidad(Conversor.convertirAFecha(rs.getDate("fcaducidad_res")));
				r.setLote(rs.getInt("lote_res"));
				r.setBaja(rs.getInt("baja_res"));
				return r;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarResurtir(Resurtir r){
		String sql = "insert into resurtir values(null"+",'"+r.getFechaResurtir()+"',"+r.getPrecioUnidad()+",'"+r.getFechaCaducidad()+"',"+r.getLote()+","+r.getBaja()+",'"+r.getCodigoBarras()+"',"+r.getClaveProveedor()+")";
		try {
			statement.executeUpdate(sql);
			return "Resurtir registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
