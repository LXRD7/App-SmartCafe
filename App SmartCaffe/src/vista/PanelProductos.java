package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;

public class PanelProductos extends JPanel {
	private JPanel panelCategoria;
	private JPanel panelProducto;
	private JPanel panelCarrito;

	/**
	 * Create the panel.
	 */
	public PanelProductos() {
		setLayout(new GridLayout(1, 3, 0, 0));
		
		panelCategoria = new JPanel();
		panelCategoria.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Tipo Producto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panelCategoria);
		panelCategoria.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Bebidas");
		rdbtnNewRadioButton.setBounds(26, 23, 80, 23);
		panelCategoria.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Postres");
		rdbtnNewRadioButton_2.setBounds(28, 104, 78, 23);
		panelCategoria.add(rdbtnNewRadioButton_2);
		
		panelProducto = new JPanel();
		add(panelProducto);
		
		panelCarrito = new JPanel();
		add(panelCarrito);
		
		JScrollPane scrollPane = new JScrollPane();
		panelCarrito.add(scrollPane);

	}

}
