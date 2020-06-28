package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class PanelMenuInventario extends JPanel {

	private static final long serialVersionUID = 2602178953576391994L;
	private JButton botonProductos;
	private JButton botonProveedores;
	private JButton botonResurtir;
	
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	public PanelMenuInventario() {
		setOpaque(false);

		botonProductos = new JButton("Productos");
		botonProductos.setBorder(new LineBorder(colorSecundario, 1, true));
		botonProductos.setForeground(colorSecundario);
		botonProductos.setBackground(colorPrincipal);
		botonProductos.setFont(new Font("Noto Sans", Font.BOLD, 18));

		botonProveedores = new JButton("Proveedores");
		botonProveedores.setBorder(new LineBorder(colorSecundario, 1, true));
		botonProveedores.setForeground(colorSecundario);
		botonProveedores.setBackground(colorPrincipal);
		botonProveedores.setFont(new Font("Noto Sans", Font.BOLD, 18));

		botonResurtir = new JButton("Resurtir");
		botonResurtir.setBorder(new LineBorder(colorSecundario, 1, true));
		botonResurtir.setForeground(colorSecundario);
		botonResurtir.setBackground(Color.GREEN);
		botonResurtir.setFont(new Font("Noto Sans", Font.BOLD, 18));
		setLayout(new GridLayout(3, 1, 5, 50));
		add(botonProductos);
		add(botonProveedores);
		add(botonResurtir);
	}

	public JButton getBotonProductos() {
		return botonProductos;
	}

	public JButton getBotonProveedores() {
		return botonProveedores;
	}

	public JButton getBotonResurtir() {
		return botonResurtir;
	}

	public Color getColorPrincipal() {
		return colorPrincipal;
	}

	public Color getColorSecundario() {
		return colorSecundario;
	}

	
}
