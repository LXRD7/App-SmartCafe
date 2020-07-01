package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.ProductoInventario;
import modelo.Ticket;

public class TablaTicket {
	private Connection conexion;
	private Statement statement;

	public TablaTicket(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en la TablaTicket");
			e.printStackTrace();
		}
	}

	public boolean existeTicket(int claveTicket){
		String sql ="select* from ticket where cve_tic='"+claveTicket+"'";
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

	public String modificarTicket(Ticket p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE ticket SET fecha_tic='"+p.getFecha()+"', descripcion_tic='"+p.getDescripcion()+"', total_tic='"+p.getTotal()+ "' WHERE cve_tic='"+p.getClaveTicket();	
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

	public int eliminarTicket(int claveTicket){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from ticket where cve_tic="+claveTicket;
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

	public List<Ticket> getTickets(){
		String sql ="select * from ticket where cve_tic";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<Ticket> lista = new ArrayList<Ticket>();
			while (rs.next()) {
				Ticket p = new Ticket();
				p.setClaveTicket(rs.getInt("cve_tic"));
				p.setFecha(Conversor.convertirAFecha(rs.getDate("fecha_tic")));
				p.setDescripcion(rs.getString("descripcion_tic"));
				p.setTotal(rs.getInt("total_tic"));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public Ticket getTicket(int claveTicket){
		String sql ="select* from ticket where cve_tic='"+claveTicket+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Ticket p = new Ticket();
				p.setClaveTicket(rs.getInt("cve_tic"));
				p.setFecha(Conversor.convertirAFecha(rs.getDate("fecha_tic")));
				p.setDescripcion(rs.getString("descripcion_tic"));
				p.setTotal(rs.getInt("total_tic"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarTicket(Ticket p){
		String sql = "insert into ticket values('"+p.getClaveTicket()+"','"+p.getFecha()+"','"+p.getDescripcion()+"','"+p.getTotal()+"')";
		try {
			statement.executeUpdate(sql);
			return "Ticket registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
