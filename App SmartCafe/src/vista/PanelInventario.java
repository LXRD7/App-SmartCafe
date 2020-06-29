package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
		setOpaque(false);
		panelMenuInventario = new PanelMenuInventario();
		panelMenuInventario.setOpaque(false);
		
		panelProductoInventario = new PanelProductoInventario();
		panelProductoInventario.setOpaque(false);
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
	
	public static Image escalarImagen(Image original,int x ,int y) {
		ImageIcon escalada = new ImageIcon(original.getScaledInstance(x, y, Image.SCALE_SMOOTH));
		return escalada.getImage();
	}
	
	@Override
	public void paint(Graphics g) {
		Image fondo = new ImageIcon(PanelInventario.class.getResource("/recursos/ventas.png")).getImage();
		g.drawImage(escalarImagen(fondo, this.getWidth(), this.getHeight()), 0, 0,this);
		super.paint(g);
	}
}
