package vista;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

public class PanelOpcionesGenerales extends JPanel {
	private JButton botonNuevo;
	private JButton botonGuardar;
	private JButton botonEditar;
	private JButton botonEliminar;
	
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorFuente = Color.WHITE;

	public PanelOpcionesGenerales() {
		setOpaque(false);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		botonNuevo = new JButton("Añadir");
		botonNuevo.setBorder(null);
		botonNuevo.setFont(new Font("Noto Sans", Font.BOLD, 18));
		botonNuevo.setForeground(colorFuente);
		botonNuevo.setToolTipText("Añadir");
		botonNuevo.setIcon(new ImageIcon(PanelOpcionesGenerales.class.getResource("/recursos/iconos/anadir.png")));
		botonNuevo.setContentAreaFilled(false);
		add(botonNuevo);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.setBorder(null);
		botonGuardar.setFont(new Font("Noto Sans", Font.BOLD, 18));
		botonGuardar.setForeground(colorFuente);
		botonGuardar.setToolTipText("Guardar");
		botonGuardar.setContentAreaFilled(false);
		botonGuardar.setIcon(new ImageIcon(PanelOpcionesGenerales.class.getResource("/recursos/iconos/salvar.png")));
		add(botonGuardar);
		
		botonEditar = new JButton("Editar");
		botonEditar.setBorder(null);
		botonEditar.setFont(new Font("Noto Sans", Font.BOLD, 18));
		botonEditar.setForeground(colorFuente);
		botonEditar.setIcon(new ImageIcon(PanelOpcionesGenerales.class.getResource("/recursos/iconos/lapiz.png")));
		botonEditar.setToolTipText("Editar");
		botonEditar.setContentAreaFilled(false);
		add(botonEditar);
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBorder(null);
		botonEliminar.setFont(new Font("Noto Sans", Font.BOLD, 18));
		botonEliminar.setForeground(colorFuente);
		botonEliminar.setIcon(new ImageIcon(PanelOpcionesGenerales.class.getResource("/recursos/iconos/eliminar.png")));
		botonEliminar.setToolTipText("Eliminar");
		botonEliminar.setContentAreaFilled(false);
		add(botonEliminar);

	}

	public JButton getBotonNuevo() {
		return botonNuevo;
	}

	public JButton getBotonGuardar() {
		return botonGuardar;
	}

	public JButton getBotonEditar() {
		return botonEditar;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
	}
	
}
