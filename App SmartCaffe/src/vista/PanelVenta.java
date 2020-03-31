package vista;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;

public class PanelVenta extends JPanel {
	private JPanel panelTipoProducto;
	private JPanel panelInformacion;

	/**
	 * Create the panel.
	 */
	public PanelVenta() {
		setLayout(new GridLayout(1, 3, 0, 0));
		
		panelTipoProducto = new JPanel();
		panelTipoProducto.setBorder(new TitledBorder(null, "Tipo Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panelTipoProducto);
		
		JPanel panelProducto = new JPanel();
		add(panelProducto);
		
		panelInformacion = new JPanel();
		add(panelInformacion);

	}

}
