package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;

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
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		panelCategoria.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		panelCategoria.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		panelCategoria.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		panelCategoria.add(rdbtnNewRadioButton_1);
		
		panelProducto = new JPanel();
		add(panelProducto);
		
		panelCarrito = new JPanel();
		add(panelCarrito);
		
		JScrollPane scrollPane = new JScrollPane();
		panelCarrito.add(scrollPane);

	}

}
