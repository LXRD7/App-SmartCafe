package vista;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel {
	private JButton botonAceptar;
	private JButton botonSalir;
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	public PanelOpciones() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		botonAceptar = new JButton("Aceptar");
		botonAceptar.setForeground(colorSecundario);
		botonAceptar.setBackground(colorPrincipal);
		add(botonAceptar);
		
		botonSalir = new JButton("Salir");
		botonSalir.setForeground(colorSecundario);
		botonSalir.setBackground(colorPrincipal);
		add(botonSalir);

	}

	public JButton getBotonAceptar() {
		return botonAceptar;
	}

	public JButton getBotonSalir() {
		return botonSalir;
	}
	
	

}
