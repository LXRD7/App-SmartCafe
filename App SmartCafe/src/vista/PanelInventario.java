package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInventario extends JPanel {

	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	private PanelMenuInventario panelMenuInventario;
	private JButton botonProductos;
	private JButton botonProveedores;
	private JButton botonResurtir;

	private PanelProductoInventario panelProductoInventario;
	private PanelProveedorInventario panelProveedorInventario;

	public PanelInventario() {

		panelMenuInventario = new PanelMenuInventario();
		
		panelProductoInventario = new PanelProductoInventario();
		panelProveedorInventario = new PanelProveedorInventario();
		
		setLayout(new BorderLayout(0, 0));

		botonProductos = panelMenuInventario.getBotonProductos();
		botonProductos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(panelMenuInventario,BorderLayout.WEST);
				add(panelProductoInventario,BorderLayout.CENTER);
				setVisible(true);
				revalidate();
				repaint();
			}
		});
		botonProductos.doClick();
		
		botonProveedores = panelMenuInventario.getBotonProveedores();
		botonProveedores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				removeAll();
				add(panelMenuInventario,BorderLayout.WEST);
				add(panelProveedorInventario,BorderLayout.CENTER);
				setVisible(true);
				revalidate();
				repaint();
			}
		});
		
		add(panelMenuInventario,BorderLayout.WEST);

		setVisible(true);

	}
	
}
