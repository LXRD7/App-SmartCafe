package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import api.ServicePrecio;
import api.ServiceProductoInventario;
import enumeraciones.TipoProductoInventario;
import enumeraciones.UnidadMedida;
import modelo.Precio;
import modelo.ProductoInventario;
import services.ServicePrecioImpl;
import services.ServiceProductoInventarioImpl;

public class PanelProductoInventario extends JPanel {

	private static final long serialVersionUID = -882555650253395977L;
	
	private PanelOpcionesGenerales panelOpcionesGenerales;
	private JButton botonNuevo;
	private JButton botonGuardar;
	private JButton botonEditar;
	private JButton botonEliminar;
	
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);
	
	private ServiceProductoInventario serviceProductoInventario;
	private ServicePrecio servicePrecio;
	
	
	private JTextField cajaCodigoBarras;
	private JTextField cajaNombre;
	private JTextField cajaMarca;
	private JTextField cajaContenido;
	private JTextField cajaPrecio;
	private JComboBox<UnidadMedida> comboBoxUnidadMedida;
	private JComboBox<TipoProductoInventario> comboBoxTipoProducto;
	private JLabel textoCodigoBarras;
	private JLabel textoTipoProducto;
	private JLabel textoMarca;
	private JLabel textoUnidadMedida;
	private JLabel textoPrecio;
	private JLabel textoNombre;
	private JLabel textoContenido;
	private JTable table;
	
	List<ProductoInventario> productos;

	public PanelProductoInventario() {
		setOpaque(false);
		
		setLayout(null);
		setPreferredSize(new Dimension(1000,500));
		
		serviceProductoInventario = new ServiceProductoInventarioImpl();
		servicePrecio = new ServicePrecioImpl();
		
		textoCodigoBarras = new JLabel("Codigo de Barras");
		textoCodigoBarras.setRequestFocusEnabled(false);
		textoCodigoBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCodigoBarras.setForeground(new Color(75, 44, 14));
		textoCodigoBarras.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoCodigoBarras.setBounds(179, 154, 150, 35);
		add(textoCodigoBarras);
		
		cajaCodigoBarras = new JTextField();
		cajaCodigoBarras.setForeground(new Color(75, 44, 14));
		cajaCodigoBarras.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaCodigoBarras.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaCodigoBarras.setBackground(new Color(175, 193, 11));
		cajaCodigoBarras.setBounds(339, 154, 160, 35);
		add(cajaCodigoBarras);
		
		textoNombre = new JLabel("Nombre");
		textoNombre.setRequestFocusEnabled(false);
		textoNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textoNombre.setForeground(new Color(75, 44, 14));
		textoNombre.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoNombre.setBounds(179, 204, 150, 35);
		add(textoNombre);
		
		cajaNombre = new JTextField();
		cajaNombre.setForeground(new Color(75, 44, 14));
		cajaNombre.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaNombre.setColumns(10);
		cajaNombre.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaNombre.setBackground(new Color(175, 193, 11));
		cajaNombre.setBounds(339, 204, 160, 35);
		add(cajaNombre);
		
		textoTipoProducto = new JLabel("Tipo");
		textoTipoProducto.setRequestFocusEnabled(false);
		textoTipoProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTipoProducto.setForeground(new Color(75, 44, 14));
		textoTipoProducto.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoTipoProducto.setBounds(179, 254, 150, 35);
		add(textoTipoProducto);
		
		comboBoxTipoProducto = new JComboBox<TipoProductoInventario>();
		comboBoxTipoProducto.setModel(new DefaultComboBoxModel<TipoProductoInventario>(TipoProductoInventario.values()));
		comboBoxTipoProducto.setForeground(new Color(75, 44, 14));
		comboBoxTipoProducto.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		comboBoxTipoProducto.setFocusable(false);
		comboBoxTipoProducto.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxTipoProducto.setBackground(new Color(175, 193, 11));
		comboBoxTipoProducto.setBounds(339, 254, 160, 35);
		add(comboBoxTipoProducto);
		
		cajaMarca = new JTextField();
		cajaMarca.setForeground(new Color(75, 44, 14));
		cajaMarca.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaMarca.setColumns(10);
		cajaMarca.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaMarca.setBackground(new Color(175, 193, 11));
		cajaMarca.setBounds(339, 304, 160, 35);
		add(cajaMarca);
		
		textoMarca = new JLabel("Marca");
		textoMarca.setRequestFocusEnabled(false);
		textoMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		textoMarca.setForeground(new Color(75, 44, 14));
		textoMarca.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoMarca.setBounds(179, 304, 150, 35);
		add(textoMarca);
		
		textoContenido = new JLabel("Contenido");
		textoContenido.setRequestFocusEnabled(false);
		textoContenido.setHorizontalAlignment(SwingConstants.RIGHT);
		textoContenido.setForeground(new Color(75, 44, 14));
		textoContenido.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoContenido.setBounds(179, 354, 150, 35);
		add(textoContenido);
		
		cajaContenido = new JTextField();
		cajaContenido.setForeground(new Color(75, 44, 14));
		cajaContenido.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaContenido.setColumns(10);
		cajaContenido.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaContenido.setBackground(new Color(175, 193, 11));
		cajaContenido.setBounds(339, 354, 160, 35);
		add(cajaContenido);
		
		textoUnidadMedida = new JLabel("Unidad de Medida");
		textoUnidadMedida.setRequestFocusEnabled(false);
		textoUnidadMedida.setHorizontalAlignment(SwingConstants.RIGHT);
		textoUnidadMedida.setForeground(new Color(75, 44, 14));
		textoUnidadMedida.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoUnidadMedida.setBounds(179, 404, 150, 35);
		add(textoUnidadMedida);
		
		comboBoxUnidadMedida = new JComboBox<UnidadMedida>();
		comboBoxUnidadMedida.setModel(new DefaultComboBoxModel<UnidadMedida>(UnidadMedida.values()));
		comboBoxUnidadMedida.setForeground(new Color(75, 44, 14));
		comboBoxUnidadMedida.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		comboBoxUnidadMedida.setFocusable(false);
		comboBoxUnidadMedida.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxUnidadMedida.setBackground(new Color(175, 193, 11));
		comboBoxUnidadMedida.setBounds(339, 404, 160, 35);
		add(comboBoxUnidadMedida);
		
		textoPrecio = new JLabel("Precio");
		textoPrecio.setRequestFocusEnabled(false);
		textoPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textoPrecio.setForeground(new Color(75, 44, 14));
		textoPrecio.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoPrecio.setBounds(179, 451, 150, 35);
		add(textoPrecio);
		
		cajaPrecio = new JTextField();
		cajaPrecio.setForeground(new Color(75, 44, 14));
		cajaPrecio.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaPrecio.setColumns(10);
		cajaPrecio.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaPrecio.setBackground(new Color(175, 193, 11));
		cajaPrecio.setBounds(339, 451, 160, 35);
		add(cajaPrecio);
		
		panelOpcionesGenerales = new PanelOpcionesGenerales();
		
		panelOpcionesGenerales.setBounds(511, 211, 135, 217);
		add(panelOpcionesGenerales);
		
		
		botonNuevo = panelOpcionesGenerales.getBotonNuevo();
		
		botonGuardar = panelOpcionesGenerales.getBotonGuardar();
		botonGuardar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ProductoInventario producto = new ProductoInventario();
				producto.setCodigoBarras(cajaCodigoBarras.getText());
				producto.setNombreProducto(cajaNombre.getText());
				producto.setTipoProducto(comboBoxTipoProducto.getItemAt(comboBoxTipoProducto.getSelectedIndex()));
				producto.setMarca(cajaMarca.getText());
				producto.setContenido(Double.parseDouble(cajaContenido.getText()));
				producto.setUnidadMedida(comboBoxUnidadMedida.getItemAt(comboBoxTipoProducto.getSelectedIndex()));
				
				Precio precio = new Precio();
				precio.setFechaPrecio(LocalDate.now());
				precio.setPrecio(Double.parseDouble(cajaPrecio.getText()));
				precio.setCodigoBarras(cajaCodigoBarras.getText());
				servicePrecio.registrarPrecio(precio);
				if(!serviceProductoInventario.existeProducto(producto.getCodigoBarras()))
					serviceProductoInventario.registrarProducto(producto);
				else
					JOptionPane.showMessageDialog(null, "El código de barras ingresado ya existe");
			}
		});
		
		botonEditar = panelOpcionesGenerales.getBotonEditar();
		
		botonEliminar = panelOpcionesGenerales.getBotonEliminar();
		
//		DefaultTableModel modelo = new DefaultTableModel();
//		String[] columnas = new String[] {"CodigoBarra","Nombre","Tipo","Marca","Precio","Contenido","UnidadMedida"};
//		
//		modelo.setColumnIdentifiers(columnas);
//		table = new JTable(modelo);
//		
//		productos = serviceProductoInventario.getProductos();
//		for (ProductoInventario p : productos) {
//			System.out.println(p.getCodigoBarras());
//			System.out.println(servicePrecio);
//			modelo.addRow(new Object[] {p.getCodigoBarras(),p.getNombreProducto(),p.getTipoProducto().toString(),p.getMarca(),servicePrecio.getPrecio(p.getCodigoBarras()),p.getContenido(),p.getUnidadMedida().toString()});
//		}
//		
//		table.setBounds(661, 154, 372, 332);
//		
//		add(table);
	}


	public JButton getBotonNuevo() {
		return panelOpcionesGenerales.getBotonNuevo();
	}

	public JButton getBotonGuardar() {
		return panelOpcionesGenerales.getBotonGuardar();
	}

	public JButton getBotonEditar() {
		return panelOpcionesGenerales.getBotonEditar();
	}

	public JButton getBotonEliminar() {
		return panelOpcionesGenerales.getBotonEliminar();
	}

	public JComboBox<TipoProductoInventario> getComboBoxTipoProducto() {
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
