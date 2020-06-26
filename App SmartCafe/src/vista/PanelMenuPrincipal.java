package vista;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class PanelMenuPrincipal extends JPanel {

	private static final long serialVersionUID = 3131541433088801847L;
	private JButton botonVentas;
	private JButton botonCatalogo;
	private JButton botonInventario;
	
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	public PanelMenuPrincipal() {
		setLayout(new GridLayout(0, 3, 50, 0));
		
		botonVentas = new JButton("Ventas");
		botonVentas.setForeground(colorSecundario);
		botonVentas.setBackground(colorPrincipal);
		botonVentas.setFont(new Font("Droid Sans", Font.BOLD, 20));
		add(botonVentas);
		
		botonCatalogo = new JButton("Catalogo");
		botonCatalogo.setForeground(colorSecundario);
		botonCatalogo.setBackground(colorPrincipal);
		botonCatalogo.setFont(new Font("Droid Sans", Font.BOLD, 20));
		add(botonCatalogo);
		
		botonInventario = new JButton("Inventario");
		botonInventario.setForeground(colorSecundario);
		botonInventario.setBackground(colorPrincipal);
		botonInventario.setFont(new Font("Droid Sans", Font.BOLD, 20));
		add(botonInventario);
	}

	public JButton getBotonVentas() {
		return botonVentas;
	}

	public void setBotonVentas(JButton botonVentas) {
		this.botonVentas = botonVentas;
	}

	public JButton getBotonCatalogo() {
		return botonCatalogo;
	}

	public void setBotonCatalogo(JButton botonCatalogo) {
		this.botonCatalogo = botonCatalogo;
	}

	public JButton getBotonInventario() {
		return botonInventario;
	}

	public void setBotonInventario(JButton botonInventario) {
		this.botonInventario = botonInventario;
	}

}
