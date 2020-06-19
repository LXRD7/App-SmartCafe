package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelMenuInventario extends JPanel {

	private static final long serialVersionUID = 2602178953576391994L;
	private JButton botonRegistrar;
	private JButton botonModificar;
	private JButton botonBuscar;
	private JButton botonEliminar;
	private JButton botonResurtir;
	
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	public PanelMenuInventario() {
		setLayout(new GridLayout(5, 1, 0, 0));

		botonRegistrar = new JButton("Registrar");
		botonRegistrar.setBorder(new LineBorder(colorSecundario, 1, true));
		botonRegistrar.setForeground(colorSecundario);
		botonRegistrar.setBackground(colorPrincipal);
		botonRegistrar.setFont(new Font("Noto Sans", Font.BOLD, 18));
		add(botonRegistrar);

		botonBuscar = new JButton("Buscar");
		botonBuscar.setBorder(new LineBorder(colorSecundario, 1, true));
		botonBuscar.setForeground(colorSecundario);
		botonBuscar.setBackground(colorPrincipal);
		botonBuscar.setFont(new Font("Noto Sans", Font.BOLD, 18));
		botonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(botonBuscar);

		botonModificar = new JButton("Modificar");
		botonModificar.setBorder(new LineBorder(colorSecundario, 1, true));
		botonModificar.setForeground(colorSecundario);
		botonModificar.setBackground(colorPrincipal);
		botonModificar.setFont(new Font("Noto Sans", Font.BOLD, 18));
		add(botonModificar);

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBorder(new LineBorder(colorSecundario, 1, true));
		botonEliminar.setForeground(colorSecundario);
		botonEliminar.setBackground(colorPrincipal);
		botonEliminar.setFont(new Font("Noto Sans", Font.BOLD, 18));
		add(botonEliminar);

		botonResurtir = new JButton("Resurtir");
		botonResurtir.setBorder(new LineBorder(colorSecundario, 1, true));
		botonResurtir.setForeground(colorSecundario);
		botonResurtir.setBackground(Color.GREEN);
		botonResurtir.setFont(new Font("Noto Sans", Font.BOLD, 18));
		add(botonResurtir);	
	}

	public JButton getBotonRegistrar() {
		return botonRegistrar;
	}

	public JButton getBotonModificar() {
		return botonModificar;
	}

	public JButton getBotonBuscar() {
		return botonBuscar;
	}

	public JButton getBotonEliminar() {
		return botonEliminar;
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
