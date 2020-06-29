package vista;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import enumeraciones.TipoProducto;
import enumeraciones.UnidadMedida;

public class PanelProductoCatalogo extends JPanel {
	private JLabel textoImagen;
	private JLabel textoUnidadMedida;
	private JLabel textoContenido;
	private JLabel textoPrecio;
	private JLabel textoTipo;
	private JLabel textoNombre;
	private JLabel textoClave;
	private JTextField cajaClave;
	private JTextField cajaNombre;
	private JTextField cajaPrecio;
	private JTextField cajaContenido;
	private JComboBox comboBoxTipo;
	private JComboBox comboBoxUnidadMedida;

	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);
	
	public PanelProductoCatalogo() {
		setLayout(null);
		setPreferredSize(new Dimension(1000, 500));
		
		textoClave = new JLabel("Clave ");
		textoClave.setForeground(new Color(75, 44, 14));
		textoClave.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoClave.setHorizontalAlignment(SwingConstants.RIGHT);
		textoClave.setBounds(321, 82, 150, 35);
		add(textoClave);
		
		cajaClave = new JTextField();
		cajaClave.setForeground(new Color(75, 44, 14));
		cajaClave.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaClave.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaClave.setBackground(new Color(175, 193, 11));
		cajaClave.setBounds(480, 83, 160, 35);
		add(cajaClave);
		cajaClave.setColumns(10);
		
		textoNombre = new JLabel("Nombre");
		textoNombre.setForeground(new Color(75, 44, 14));
		textoNombre.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textoNombre.setBounds(321, 129, 150, 35);
		add(textoNombre);
		
		cajaNombre = new JTextField();
		cajaNombre.setForeground(new Color(75, 44, 14));
		cajaNombre.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaNombre.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaNombre.setBackground(new Color(175, 193, 11));
		cajaNombre.setBounds(480, 130, 160, 35);
		add(cajaNombre);
		cajaNombre.setColumns(10);
		
		textoTipo = new JLabel("Tipo");
		textoTipo.setForeground(new Color(75, 44, 14));
		textoTipo.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTipo.setBounds(321, 179, 150, 35);
		add(textoTipo);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(TipoProducto.values()));
		comboBoxTipo.setForeground(new Color(75, 44, 14));
		comboBoxTipo.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		comboBoxTipo.setFocusable(false);
		comboBoxTipo.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxTipo.setBackground(new Color(175, 193, 11));
		comboBoxTipo.setBounds(480, 180, 160, 35);
		add(comboBoxTipo);
		
		textoPrecio = new JLabel("Precio");
		textoPrecio.setForeground(new Color(75, 44, 14));
		textoPrecio.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textoPrecio.setBounds(321, 236, 150, 35);
		add(textoPrecio);
		
		cajaPrecio = new JTextField();
		cajaPrecio.setForeground(new Color(75, 44, 14));
		cajaPrecio.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaPrecio.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaPrecio.setBackground(new Color(175, 193, 11));
		cajaPrecio.setBounds(480, 237, 160, 35);
		add(cajaPrecio);
		cajaPrecio.setColumns(10);
		
		textoContenido = new JLabel("Contenido");
		textoContenido.setForeground(new Color(75, 44, 14));
		textoContenido.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoContenido.setHorizontalAlignment(SwingConstants.RIGHT);
		textoContenido.setBounds(321, 284, 150, 35);
		add(textoContenido);
		
		cajaContenido = new JTextField();
		cajaContenido.setForeground(new Color(75, 44, 14));
		cajaContenido.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaContenido.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaContenido.setBackground(new Color(175, 193, 11));
		cajaContenido.setBounds(480, 284, 160, 35);
		add(cajaContenido);
		cajaContenido.setColumns(10);
		
		textoUnidadMedida = new JLabel("Unidad de Medida");
		textoUnidadMedida.setForeground(new Color(75, 44, 14));
		textoUnidadMedida.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoUnidadMedida.setHorizontalAlignment(SwingConstants.RIGHT);
		textoUnidadMedida.setBounds(321, 336, 150, 35);
		add(textoUnidadMedida);
		
		comboBoxUnidadMedida = new JComboBox();
		comboBoxUnidadMedida.setModel(new DefaultComboBoxModel(UnidadMedida.values()));
		comboBoxUnidadMedida.setForeground(new Color(75, 44, 14));
		comboBoxUnidadMedida.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		comboBoxUnidadMedida.setFocusable(false);
		comboBoxUnidadMedida.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxUnidadMedida.setBackground(new Color(175, 193, 11));
		comboBoxUnidadMedida.setBounds(480, 337, 160, 35);
		add(comboBoxUnidadMedida);
		
		textoImagen = new JLabel("Imagen");
		textoImagen.setForeground(new Color(75, 44, 14));
		textoImagen.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		textoImagen.setBounds(321, 383, 150, 35);
		add(textoImagen);
		
		JFileChooser fc =new JFileChooser();
		
	}
}
