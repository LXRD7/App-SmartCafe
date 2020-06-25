package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conversores.Conversor;
import modelo.ProductoInventario;
import modelo.TicketProductoVenta;

public class TablaTicketProductoVenta {
	private Connection conexion;
	private Statement statement;

	public TablaTicketProductoVenta(Connection conexion) {
		this.conexion = conexion;
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			System.out.println("Error en TablaTicketProductoVenta");
			e.printStackTrace();
		}
	}

	public boolean existeTicketProductoVenta(int numeroTicket){
		String sql ="select* from ticproducto_ven where num_ticpve='"+numeroTicket+"'";
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

	public String modificarTicketProductoVenta(TicketProductoVenta p){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql = "UPDATE ticproducto_ven SET cant_ticpve='"+p.getCantidadTicket()+ "' WHERE num_ticpve='"+p.getNumeroTicket();	
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

	public int eliminarTicketProductoVenta (int numeroTicket){
		String sql2 ="SET FOREIGN_KEY_CHECKS=0";
		String sql3 ="SET FOREIGN_KEY_CHECKS=1";
		String sql ="delete from ticproducto_ven where num_ticpve="+numeroTicket;
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
	//TicketProductoVenta  ticproducto_ven  num_ticpve
	public List<TicketProductoVenta> getTicketsProductoVenta(){
		String sql ="select * from ticproducto_ven where num_ticpve";
		try{
			ResultSet rs = statement.executeQuery(sql);
			List<TicketProductoVenta> lista = new ArrayList<TicketProductoVenta>();
			while (rs.next()) {
				TicketProductoVenta p = new TicketProductoVenta();
				p.setNumeroTicket(rs.getInt("num_ticpve"));
				p.setCantidadTicket(rs.getInt("cant_ticpve"));

				lista.add(p);
			} 
			return lista;
		}catch(SQLException e){
			return null;
		}
	}

	public TicketProductoVenta getTicketProductoVenta(int numeroTicket){
		String sql ="select* from ticproducto_ven where num_ticpve='"+numeroTicket+"'";
		try{
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				TicketProductoVenta p = new TicketProductoVenta();
				p.setNumeroTicket(rs.getInt("num_ticpve"));
				p.setCantidadTicket(rs.getInt("cant_ticpve"));

				return p;
			} else {
				return null;
			}
		}catch(SQLException e){
			e.toString();
			return null;
		}
	}

	public String registrarTicketProductoVenta(TicketProductoVenta p){
		String sql = "insert into ticproducto_ven values('"+p.getNumeroTicket()+"','"+p.getCantidadTicket()+"')";
		try {
			statement.executeUpdate(sql);
			return "TicketProductoVenta registrado.";
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
}
