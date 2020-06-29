package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelMenuCatalogo extends JPanel {
	private JButton botonProductos;
	private JButton botonRecetas;
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	/**
	 * Create the panel.
	 */
	public PanelMenuCatalogo() {
		setOpaque(false);
		setLayout(new GridLayout(2, 1, 5, 50));
		
		botonProductos = new JButton("Productos");
		botonProductos.setForeground(colorSecundario);
		botonProductos.setBackground(colorPrincipal);
		botonProductos.setBorder(new LineBorder(new Color(0, 0, 0)));
		botonProductos.setFont(new Font("Dialog", Font.BOLD, 18));
		add(botonProductos);
		
		botonRecetas = new JButton("Recetas");
		botonRecetas.setForeground(colorSecundario);
		botonRecetas.setBackground(colorPrincipal);
		botonRecetas.setBorder(new LineBorder(new Color(0, 0, 0)));
		botonRecetas.setFont(new Font("Dialog", Font.BOLD, 18));
		add(botonRecetas);

	}
	public JButton getBotonProductos() {
		return botonProductos;
	}
	
	public JButton getBotonRecetas() {
		return botonRecetas;
	}
	public Color getColorPrincipal() {
		return colorPrincipal;
	}

	public Color getColorSecundario() {
		return colorSecundario;
	}
}
