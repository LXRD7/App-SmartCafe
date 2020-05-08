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
	private JRadioButton comboBoxCafes;
	private JRadioButton comboBoxPasteles;
	private JRadioButton comboBoxLicuados;
	private JRadioButton comboBoxTe;

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
		
		comboBoxCafes = new JRadioButton("Cafés");
		comboBoxCafes.setHorizontalAlignment(SwingConstants.LEFT);
		comboBoxCafes.setIcon(new ImageIcon(PanelProductos.class.getResource("/recursos/512_black_18_44087.png")));
		comboBoxCafes.setBounds(26, 23, 141, 37);
		panelCategoria.add(comboBoxCafes);
		
		comboBoxPasteles = new JRadioButton("Pasteles");
		comboBoxPasteles.setIcon(new ImageIcon(PanelProductos.class.getResource("/recursos/cake.png")));
		comboBoxPasteles.setHorizontalAlignment(SwingConstants.LEFT);
		comboBoxPasteles.setBounds(26, 72, 139, 37);
		panelCategoria.add(comboBoxPasteles);
		
		comboBoxLicuados = new JRadioButton("Licuados");
		comboBoxLicuados.setIcon(new ImageIcon(PanelProductos.class.getResource("/recursos/malteada(1).png")));
		comboBoxLicuados.setHorizontalAlignment(SwingConstants.LEFT);
		comboBoxLicuados.setBounds(26, 121, 141, 37);
		panelCategoria.add(comboBoxLicuados);
		
		comboBoxTe = new JRadioButton("Té");
		comboBoxTe.setIcon(new ImageIcon(PanelProductos.class.getResource("/recursos/relajante.png")));
		comboBoxTe.setHorizontalAlignment(SwingConstants.LEFT);
		comboBoxTe.setBounds(26, 174, 141, 37);
		panelCategoria.add(comboBoxTe);
		
		panelProducto = new JPanel();
		add(panelProducto);
		
		panelCarrito = new JPanel();
		add(panelCarrito);
		
		JScrollPane scrollPane = new JScrollPane();
		panelCarrito.add(scrollPane);

	}
}
