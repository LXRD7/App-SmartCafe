package vista;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import dao.TablaProductoInventario;
import enumeraciones.TipoProducto;
import enumeraciones.UnidadMedida;

public class PanelCapturaProductoInventario extends JPanel {

	private static final long serialVersionUID = -882555650253395977L;
	private JPanel panelDatos;
	private JLabel textoNombre;
	private JComboBox<TipoProducto> comboBoxTipoProducto;
	private JTextField cajaNombre;
	private JLabel textoTipoProducto;
	private JComboBox<UnidadMedida> comboBoxUnidadMedida;
	private JLabel textoMarca;
	private JLabel textoCodigoBarras;
	private JLabel textoUnidadMedida;
	private JTextField cajaMarca;
	private JTextField cajaContenido;
	private JTextField cajaCodigoBarras;
	private JLabel textoContenido;
	private JTextField cajaPrecio;
	
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	public PanelCapturaProductoInventario() {
		setLayout(null);

		panelDatos = new JPanel();
		panelDatos.setBounds(0, 0, 860, 583);
		add(panelDatos);
		panelDatos.setLayout(null);

		textoCodigoBarras = new JLabel("Codigo de Barras");
		textoCodigoBarras.setForeground(colorSecundario);
		textoCodigoBarras.setBounds(250, 125, 150, 35);
		textoCodigoBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCodigoBarras.setRequestFocusEnabled(false);
		textoCodigoBarras.setFont(new Font("Droid Sans", Font.BOLD, 16));
		panelDatos.add(textoCodigoBarras);

		textoNombre = new JLabel("Nombre");
		textoNombre.setForeground(colorSecundario);
		textoNombre.setBounds(250, 175, 150, 35);
		textoNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textoNombre.setRequestFocusEnabled(false);
		textoNombre.setFont(new Font("Droid Sans", Font.BOLD, 16));
		panelDatos.add(textoNombre);

		textoTipoProducto = new JLabel("Tipo");
		textoTipoProducto.setForeground(colorSecundario);
		textoTipoProducto.setBounds(250, 225, 150, 35);
		textoTipoProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTipoProducto.setRequestFocusEnabled(false);
		textoTipoProducto.setFont(new Font("Droid Sans", Font.BOLD, 16));
		panelDatos.add(textoTipoProducto);

		textoMarca = new JLabel("Marca");
		textoMarca.setForeground(colorSecundario);
		textoMarca.setBounds(250, 275, 150, 35);
		textoMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		textoMarca.setRequestFocusEnabled(false);
		textoMarca.setFont(new Font("Droid Sans", Font.BOLD, 16));
		panelDatos.add(textoMarca);

		textoContenido = new JLabel("Contenido");
		textoContenido.setForeground(colorSecundario);
		textoContenido.setBounds(250, 325, 150, 35);
		textoContenido.setRequestFocusEnabled(false);
		textoContenido.setHorizontalAlignment(SwingConstants.RIGHT);
		textoContenido.setFont(new Font("Droid Sans", Font.BOLD, 16));
		panelDatos.add(textoContenido);

		textoUnidadMedida = new JLabel("Unidad de Medida");
		textoUnidadMedida.setForeground(colorSecundario);
		textoUnidadMedida.setRequestFocusEnabled(false);
		textoUnidadMedida.setHorizontalAlignment(SwingConstants.RIGHT);
		textoUnidadMedida.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoUnidadMedida.setBounds(250, 375, 150, 35);
		panelDatos.add(textoUnidadMedida);

		cajaCodigoBarras = new JTextField();
		cajaCodigoBarras.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaCodigoBarras.setForeground(colorSecundario);
		cajaCodigoBarras.setBackground(colorPrincipal);
		cajaCodigoBarras.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaCodigoBarras.setBounds(410, 125, 160, 35);
		panelDatos.add(cajaCodigoBarras);

		cajaNombre = new JTextField();
		cajaNombre.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaNombre.setForeground(colorSecundario);
		cajaNombre.setBackground(colorPrincipal);
		cajaNombre.setBounds(410, 175, 160, 35);
		panelDatos.add(cajaNombre);
		cajaNombre.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaNombre.setColumns(10);

		comboBoxTipoProducto = new JComboBox<>();
		comboBoxTipoProducto.setFocusable(false);
		comboBoxTipoProducto.setModel(new DefaultComboBoxModel<TipoProducto>(TipoProducto.values()));
		comboBoxTipoProducto.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxTipoProducto.setForeground(colorSecundario);
		comboBoxTipoProducto.setBackground(colorPrincipal);
		comboBoxTipoProducto.setBounds(410, 225, 160, 35);
		panelDatos.add(comboBoxTipoProducto);
		comboBoxTipoProducto.setFont(new Font("Droid Sans", Font.PLAIN, 16));

		cajaMarca = new JTextField();
		cajaMarca.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaMarca.setForeground(colorSecundario);
		cajaMarca.setBackground(colorPrincipal);
		cajaMarca.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaMarca.setColumns(10);
		cajaMarca.setBounds(410, 275, 160, 35);
		panelDatos.add(cajaMarca);

		cajaContenido = new JTextField();
		cajaContenido.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaContenido.setForeground(colorSecundario);
		cajaContenido.setBackground(colorPrincipal);
		cajaContenido.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaContenido.setColumns(10);
		cajaContenido.setBounds(410, 325, 160, 35);
		panelDatos.add(cajaContenido);

		comboBoxUnidadMedida = new JComboBox<>();
		comboBoxUnidadMedida.setFocusable(false);
		comboBoxUnidadMedida.setModel(new DefaultComboBoxModel<UnidadMedida>(UnidadMedida.values()));
		comboBoxUnidadMedida.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxUnidadMedida.setForeground(colorSecundario);
		comboBoxUnidadMedida.setBackground(colorPrincipal);
		comboBoxUnidadMedida.setBounds(410, 375, 160, 35);
		panelDatos.add(comboBoxUnidadMedida);
		comboBoxUnidadMedida.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		
		JLabel textoPrecio = new JLabel("Precio");
		textoPrecio.setRequestFocusEnabled(false);
		textoPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textoPrecio.setForeground(new Color(75, 44, 14));
		textoPrecio.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoPrecio.setBounds(250, 422, 150, 35);
		panelDatos.add(textoPrecio);
		
		cajaPrecio = new JTextField();
		cajaPrecio.setForeground(new Color(75, 44, 14));
		cajaPrecio.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaPrecio.setColumns(10);
		cajaPrecio.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaPrecio.setBackground(new Color(175, 193, 11));
		cajaPrecio.setBounds(410, 422, 160, 35);
		panelDatos.add(cajaPrecio);
	}

	public JComboBox<TipoProducto> getComboBoxTipoProducto() {
		return comboBoxTipoProducto;
	}

	public JTextField getCajaNombre() {
		return cajaNombre;
	}

	public JComboBox<UnidadMedida> getComboBoxUnidadMedida() {
		return comboBoxUnidadMedida;
	}

	public JTextField getCajaMarca() {
		return cajaMarca;
	}

	public JTextField getCajaContenido() {
		return cajaContenido;
	}

	public JTextField getCajaCodigoBarras() {
		return cajaCodigoBarras;
	}

	public JTextField getCajaPrecio() {
		return cajaPrecio;
	}
	
}
