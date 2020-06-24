package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public String modificarResurtir(Resurtir p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE resurtir SET fecha_res='"+p.getFechaResurtir()+"', ppu_res='"+p.getPrecioUnidad()+"', fcaducidad_res='"+p.getFechaCaducidad()+"',lote_res='"+p.getLote()+"',baja_res='"+p.getBaja()+ "' WHERE num_res='"+p.getNumResurtir();	
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
				Resurtir p = new Resurtir();
				p.setNumResurtir(rs.getInt("num_res"));
				p.setFechaResurtir(Conversor.convertirAFecha(rs.getString("fecha_res")));
				p.setPrecioUnidad(rs.getInt("ppu_res"));
				p.setFechaCaducidad(Conversor.convertirAFecha(rs.getString("fcaducidad_res")));
				p.setLote(rs.getInt("lote_res"));
				p.setBaja(rs.getInt("baja_res"));
				lista.add(p);
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
				Resurtir p = new Resurtir();
				p.setNumResurtir(rs.getInt("num_res"));
				p.setFechaResurtir(Conversor.convertirAFecha(rs.getString("fecha_res")));
				p.setPrecioUnidad(rs.getInt("ppu_res"));
				p.setFechaCaducidad(Conversor.convertirAFecha(rs.getString("fcaducidad_res")));
				p.setLote(rs.getInt("lote_res"));
				p.setBaja(rs.getInt("baja_res"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarResurtir(Resurtir p){
		String sql = "insert into resurtir values('"+p.getNumResurtir()+"','"+p.getFechaResurtir()+"','"+p.getPrecioUnidad()+"','"+p.getFechaCaducidad()+"','"+p.getLote()+"','"+p.getBaja()+"')";
		try {
			statement.executeUpdate(sql);
			return "Resurtir registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
