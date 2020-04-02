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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

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
		panelCategoria.setBackground(Color.LIGHT_GRAY);
		panelCategoria.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Tipo Producto", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(panelCategoria);
		panelCategoria.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cafés");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton.setIcon(new ImageIcon(PanelProductos.class.getResource("/recursos/512_black_18_44087.png")));
		rdbtnNewRadioButton.setBounds(26, 23, 141, 37);
		panelCategoria.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Pasteles");
		rdbtnNewRadioButton_2.setIcon(new ImageIcon(PanelProductos.class.getResource("/recursos/cake.png")));
		rdbtnNewRadioButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_2.setBounds(26, 72, 139, 37);
		panelCategoria.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Licuados");
		rdbtnNewRadioButton_1.setIcon(new ImageIcon(PanelProductos.class.getResource("/recursos/malteada(1).png")));
		rdbtnNewRadioButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnNewRadioButton_1.setBounds(26, 121, 141, 37);
		panelCategoria.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnT = new JRadioButton("Té");
		rdbtnT.setIcon(new ImageIcon(PanelProductos.class.getResource("/recursos/relajante.png")));
		rdbtnT.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnT.setBounds(26, 174, 141, 37);
		panelCategoria.add(rdbtnT);
		
		panelProducto = new JPanel();
		add(panelProducto);
		
		panelCarrito = new JPanel();
		add(panelCarrito);
		
		JScrollPane scrollPane = new JScrollPane();
		panelCarrito.add(scrollPane);

	}
}
