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

public class PanelCatalogo extends JPanel {

	private JButton botonProductos;
	private JButton botonRecetas;
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	private PanelMenuCatalogo panelMenuCatalogo;

	private PanelProductoCatalogo panelProductoCatalogo;


	public PanelCatalogo() {
		setOpaque(false);
		
		panelMenuCatalogo = new PanelMenuCatalogo();
		panelMenuCatalogo.setOpaque(false);
		
		panelProductoCatalogo= new PanelProductoCatalogo();
		panelProductoCatalogo.setOpaque(false);
		
		setLayout(new BorderLayout(0, 0));

		botonProductos = panelMenuCatalogo.getBotonProductos();
		botonProductos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				add(panelMenuCatalogo,BorderLayout.WEST);
				add(panelProductoCatalogo,BorderLayout.CENTER);
				setVisible(true);
				revalidate();
				repaint();
			}
		});
		botonProductos.doClick();

		setVisible(true);
	}
	
	public static Image escalarImagen(Image original,int x ,int y) {
		ImageIcon escalada = new ImageIcon(original.getScaledInstance(x, y, Image.SCALE_SMOOTH));
		return escalada.getImage();
	}
	
	@Override
	public void paint(Graphics g) {
		Image fondo = new ImageIcon(PanelCatalogo.class.getResource("/recursos/fondoPanelCatalogo.png")).getImage();
		g.drawImage(escalarImagen(fondo, this.getWidth(), this.getHeight()), 0, 0,this);
		super.paint(g);
	}

}
