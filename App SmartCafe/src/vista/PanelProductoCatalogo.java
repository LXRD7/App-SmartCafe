package vista;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

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

	
	public PanelProductoCatalogo() {
		setLayout(null);
		setPreferredSize(new Dimension(1000, 500));
		
		textoClave = new JLabel("Clave ");
		textoClave.setFont(new Font("Dialog", Font.BOLD, 16));
		textoClave.setHorizontalAlignment(SwingConstants.RIGHT);
		textoClave.setBounds(321, 82, 150, 35);
		add(textoClave);
		
		cajaClave = new JTextField();
		cajaClave.setBounds(480, 83, 160, 35);
		add(cajaClave);
		cajaClave.setColumns(10);
		
		textoNombre = new JLabel("Nombre");
		textoNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		textoNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textoNombre.setBounds(321, 129, 150, 35);
		add(textoNombre);
		
		cajaNombre = new JTextField();
		cajaNombre.setBounds(480, 130, 160, 35);
		add(cajaNombre);
		cajaNombre.setColumns(10);
		
		textoTipo = new JLabel("Tipo");
		textoTipo.setFont(new Font("Dialog", Font.BOLD, 16));
		textoTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTipo.setBounds(321, 179, 150, 35);
		add(textoTipo);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(480, 180, 160, 35);
		add(comboBoxTipo);
		
		textoPrecio = new JLabel("Precio");
		textoPrecio.setFont(new Font("Dialog", Font.BOLD, 16));
		textoPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textoPrecio.setBounds(321, 236, 150, 35);
		add(textoPrecio);
		
		cajaPrecio = new JTextField();
		cajaPrecio.setBounds(480, 237, 160, 35);
		add(cajaPrecio);
		cajaPrecio.setColumns(10);
		
		textoContenido = new JLabel("Contenido");
		textoContenido.setFont(new Font("Dialog", Font.BOLD, 16));
		textoContenido.setHorizontalAlignment(SwingConstants.RIGHT);
		textoContenido.setBounds(321, 284, 150, 35);
		add(textoContenido);
		
		cajaContenido = new JTextField();
		cajaContenido.setBounds(480, 284, 160, 35);
		add(cajaContenido);
		cajaContenido.setColumns(10);
		
		textoUnidadMedida = new JLabel("Unidad de Medida");
		textoUnidadMedida.setFont(new Font("Dialog", Font.BOLD, 16));
		textoUnidadMedida.setHorizontalAlignment(SwingConstants.RIGHT);
		textoUnidadMedida.setBounds(321, 336, 150, 35);
		add(textoUnidadMedida);
		
		comboBoxUnidadMedida = new JComboBox();
		comboBoxUnidadMedida.setBounds(480, 337, 160, 35);
		add(comboBoxUnidadMedida);
		
		textoImagen = new JLabel("Imagen");
		textoImagen.setFont(new Font("Dialog", Font.BOLD, 16));
		textoImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		textoImagen.setBounds(321, 383, 150, 35);
		add(textoImagen);
		
		JFileChooser fc =new JFileChooser();
		
	}
}
