package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import api.ServiceProductoVenta;
import enumeraciones.TipoProductoVenta;
import enumeraciones.UnidadMedida;
import modelo.ProductoVenta;
import services.ServiceProductoVentaImpl;

public class PanelProductoCatalogo extends JPanel {

	private JLabel textoImagen;
	private JLabel textoUnidadMedida;
	private JLabel textoContenido;
	private JLabel textoPrecio;
	private JLabel textoTipo;
	private JLabel textoNombre;
	private JLabel textoCodigoBarras;
	private JTextField cajaCodigoBarras;
	private JTextField cajaNombre;
	private JTextField cajaPrecio;
	private JTextField cajaContenido;
	private JComboBox<TipoProductoVenta> comboBoxTipo;
	private JComboBox<UnidadMedida> comboBoxUnidadMedida;

	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);
	private Color colorFuente = Color.WHITE;

	private ServiceProductoVenta serviceProductoVenta;

	private PanelOpcionesGenerales panelOpcionesGenerales;
	private JButton botonNuevo;
	private JButton botonGuardar;
	private JButton botonEditar;
	private JButton botonEliminar;
	private JTextField cajaImagen;
	private JButton botonSeleccionar;

	public PanelProductoCatalogo() {
		setLayout(null);
		setPreferredSize(new Dimension(1000, 500));

		textoCodigoBarras = new JLabel("Codigo de Barras");
		textoCodigoBarras.setForeground(colorFuente);
		textoCodigoBarras.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoCodigoBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCodigoBarras.setBounds(321, 82, 150, 35);
		add(textoCodigoBarras);

		cajaCodigoBarras = new JTextField();
		cajaCodigoBarras.setForeground(colorSecundario);
		cajaCodigoBarras.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaCodigoBarras.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaCodigoBarras.setBackground(new Color(175, 193, 11));
		cajaCodigoBarras.setBounds(480, 83, 160, 35);
		add(cajaCodigoBarras);
		cajaCodigoBarras.setColumns(10);

		textoNombre = new JLabel("Nombre");
		textoNombre.setForeground(colorFuente);
		textoNombre.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textoNombre.setBounds(321, 129, 150, 35);
		add(textoNombre);

		cajaNombre = new JTextField();
		cajaNombre.setForeground(colorSecundario);
		cajaNombre.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaNombre.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaNombre.setBackground(new Color(175, 193, 11));
		cajaNombre.setBounds(480, 130, 160, 35);
		add(cajaNombre);
		cajaNombre.setColumns(10);

		textoTipo = new JLabel("Tipo");
		textoTipo.setForeground(colorFuente);
		textoTipo.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTipo.setBounds(321, 179, 150, 35);
		add(textoTipo);

		comboBoxTipo = new JComboBox<TipoProductoVenta>();
		comboBoxTipo.setModel(new DefaultComboBoxModel<TipoProductoVenta>(TipoProductoVenta.values()));
		comboBoxTipo.setForeground(colorSecundario);
		comboBoxTipo.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		comboBoxTipo.setFocusable(false);
		comboBoxTipo.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxTipo.setBackground(new Color(175, 193, 11));
		comboBoxTipo.setBounds(480, 180, 160, 35);
		add(comboBoxTipo);

		textoPrecio = new JLabel("Precio");
		textoPrecio.setForeground(colorFuente);
		textoPrecio.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textoPrecio.setBounds(321, 236, 150, 35);
		add(textoPrecio);

		cajaPrecio = new JTextField();
		cajaPrecio.setForeground(colorSecundario);
		cajaPrecio.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaPrecio.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaPrecio.setBackground(new Color(175, 193, 11));
		cajaPrecio.setBounds(480, 237, 160, 35);
		add(cajaPrecio);
		cajaPrecio.setColumns(10);

		textoContenido = new JLabel("Contenido");
		textoContenido.setForeground(colorFuente);
		textoContenido.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoContenido.setHorizontalAlignment(SwingConstants.RIGHT);
		textoContenido.setBounds(321, 284, 150, 35);
		add(textoContenido);

		cajaContenido = new JTextField();
		cajaContenido.setForeground(colorSecundario);
		cajaContenido.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaContenido.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaContenido.setBackground(new Color(175, 193, 11));
		cajaContenido.setBounds(480, 284, 160, 35);
		add(cajaContenido);
		cajaContenido.setColumns(10);

		textoUnidadMedida = new JLabel("Unidad de Medida");
		textoUnidadMedida.setForeground(colorFuente);
		textoUnidadMedida.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoUnidadMedida.setHorizontalAlignment(SwingConstants.RIGHT);
		textoUnidadMedida.setBounds(321, 336, 150, 35);
		add(textoUnidadMedida);

		comboBoxUnidadMedida = new JComboBox();
		comboBoxUnidadMedida.setModel(new DefaultComboBoxModel<UnidadMedida>(UnidadMedida.values()));
		comboBoxUnidadMedida.setForeground(colorSecundario);
		comboBoxUnidadMedida.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		comboBoxUnidadMedida.setFocusable(false);
		comboBoxUnidadMedida.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxUnidadMedida.setBackground(new Color(175, 193, 11));
		comboBoxUnidadMedida.setBounds(480, 337, 160, 35);
		add(comboBoxUnidadMedida);

		textoImagen = new JLabel("Imagen");
		textoImagen.setForeground(colorFuente);
		textoImagen.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoImagen.setHorizontalAlignment(SwingConstants.RIGHT);
		textoImagen.setBounds(321, 383, 150, 35);
		add(textoImagen);

		cajaImagen = new JTextField();
		cajaImagen.setForeground(colorSecundario);
		cajaImagen.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaImagen.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaImagen.setBackground(new Color(175, 193, 11));
		cajaImagen.setBounds(480, 384, 160, 35);
		add(cajaImagen);
		cajaImagen.setColumns(10);

		botonSeleccionar = new JButton("Seleccionar");
		botonSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jf=new JFileChooser();
				jf.showOpenDialog(jf);
				File archivo=jf.getSelectedFile();
				if(archivo!=null) {
					cajaImagen.setText(archivo.getAbsolutePath());
				}
			}
		});
		botonSeleccionar.setBounds(648, 389, 106, 25);
		add(botonSeleccionar);


		panelOpcionesGenerales = new PanelOpcionesGenerales();
		panelOpcionesGenerales.setBounds(680, 115, 135, 217);
		add(panelOpcionesGenerales);

		botonGuardar = panelOpcionesGenerales.getBotonGuardar();
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serviceProductoVenta = new ServiceProductoVentaImpl();
				ProductoVenta venta = new ProductoVenta();
				venta.setCodigoBarras(cajaCodigoBarras.getText());
				venta.setNombreProducto(cajaNombre.getText());
				venta.setTipoProductoVenta(comboBoxTipo.getItemAt(comboBoxTipo.getSelectedIndex()));
				venta.setPrecio(Integer.parseInt(cajaPrecio.getText()));
				venta.setContenido(Integer.parseInt(cajaContenido.getText()));
				venta.setUnidadMedida(comboBoxUnidadMedida.getItemAt(comboBoxTipo.getSelectedIndex()));


				if(!serviceProductoVenta.existeProductoVenta(venta.getCodigoBarras()))
					serviceProductoVenta.registrarProductoVenta(venta);
				else
					JOptionPane.showMessageDialog(null, "La clave del producto ingresada ya existe");
			}	

		});

	}
	private static String dialogo(String entrada, boolean[][] matriz)
			throws IOException {
		JFileChooser ventana = new JFileChooser(entrada);
		ventana.setDialogTitle("Guardar");
		ventana.setFileFilter(new FileNameExtensionFilter("Texto (txt)","txt"));
		if (ventana.showDialog(null,"Guardar") == JFileChooser.APPROVE_OPTION) {
			File archivo = ventana.getSelectedFile();
			FileWriter archivo_escribe=new FileWriter(archivo);
			archivo_escribe.write('c');
			archivo_escribe.close();
		}
		return entrada;
	}
}
