package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInventario extends JPanel {

	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);
	private Image fondo;
	private PanelMenuInventario panelMenuInventario;
	private JButton botonProductos;
	private JButton botonProveedores;
	private JButton botonResurtir;

	private PanelProductoInventario panelProductoInventario;

	public PanelInventario() {
		
		
		panelMenuInventario = new PanelMenuInventario();
		panelProductoInventario = new PanelProductoInventario();
		setLayout(new BorderLayout(0, 0));

		botonProductos = panelMenuInventario.getBotonProductos();
		botonProductos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				add(panelProductoInventario,BorderLayout.CENTER);
				setVisible(true);
				revalidate();
			}
		});
		//		botonProductos.doClick();
		add(panelMenuInventario,BorderLayout.WEST);
		
		setVisible(true);
		
	}
	
}
