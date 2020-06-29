package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		panelMenuCatalogo = new PanelMenuCatalogo();

		panelProductoCatalogo= new PanelProductoCatalogo();
		
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

}
