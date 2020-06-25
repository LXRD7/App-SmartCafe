package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.ProductoInventario;
import modelo.TicketMesa;

public class TablaTicketMesa {
	private Connection conexion;
	private Statement statement;

	public TablaTicketMesa(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaTicketMesa");
			e.printStackTrace();
		}
	}

	public boolean existeTickeMesa(int numTicketMesa){
		String sql ="select* from  ticket_mesa where num_tm='"+numTicketMesa+"'";
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

	public String modificarTicketMesa(TicketMesa p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE ticket_mesa SET num_tm='"+p.getNumTicketMesa();	
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

	public int eliminarTicketMesa(int numTicketMesa){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from  ticket_mesa where num_tm="+numTicketMesa;
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

	public List<TicketMesa> getTickets(){
		String sql ="select * from  ticket_mesa where num_tm";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<TicketMesa> lista = new ArrayList<TicketMesa>();
			while (rs.next()) {
				TicketMesa p = new TicketMesa();
				p.setNumTicketMesa(rs.getInt("num_tm"));
				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public TicketMesa getTicket(int numTicketMesa){
		String sql ="select* from  ticket_mesa where num_tm='"+numTicketMesa+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				TicketMesa p = new TicketMesa();
				p.setNumTicketMesa(rs.getInt("num_tm"));
				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarTicketMesa(TicketMesa p){
		String sql = "insert into ticket_mesa values('"+p.getNumTicketMesa()+"')";
		try {
			statement.executeUpdate(sql);
			return "TicketMesa registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
