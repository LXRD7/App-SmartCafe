package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import api.ServiceProductoInventario;
import enumeraciones.TipoProductoInventario;
import enumeraciones.UnidadMedida;
import modelo.ProductoInventario;
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
	private Color colorFuente = Color.WHITE;

	private ServiceProductoInventario serviceProductoInventario;


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

	private JScrollPane scrollPane;
	private JTable tabla;
	private JTableHeader encabezado;
	private DefaultTableModel modelo;

	private boolean editando;

	List<ProductoInventario> productos;

	public PanelProductoInventario() {
		setOpaque(false);

		setLayout(null);
		setPreferredSize(new Dimension(1000,500));

		serviceProductoInventario = new ServiceProductoInventarioImpl();

		textoCodigoBarras = new JLabel("Codigo de Barras");
		textoCodigoBarras.setRequestFocusEnabled(false);
		textoCodigoBarras.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCodigoBarras.setForeground(colorFuente);
		textoCodigoBarras.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoCodigoBarras.setBounds(179, 154, 150, 35);
		add(textoCodigoBarras);

		cajaCodigoBarras = new JTextField();
		cajaCodigoBarras.setEditable(false);
		cajaCodigoBarras.setForeground(colorSecundario);
		cajaCodigoBarras.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaCodigoBarras.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaCodigoBarras.setBackground(colorPrincipal);
		cajaCodigoBarras.setBounds(339, 154, 160, 35);
		add(cajaCodigoBarras);

		textoNombre = new JLabel("Nombre");
		textoNombre.setRequestFocusEnabled(false);
		textoNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		textoNombre.setForeground(colorFuente);
		textoNombre.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoNombre.setBounds(179, 204, 150, 35);
		add(textoNombre);

		cajaNombre = new JTextField();
		cajaNombre.setEditable(false);
		cajaNombre.setForeground(colorSecundario);
		cajaNombre.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaNombre.setColumns(10);
		cajaNombre.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaNombre.setBackground(colorPrincipal);
		cajaNombre.setBounds(339, 204, 160, 35);
		add(cajaNombre);

		textoTipoProducto = new JLabel("Tipo");
		textoTipoProducto.setRequestFocusEnabled(false);
		textoTipoProducto.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTipoProducto.setForeground(colorFuente);
		textoTipoProducto.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoTipoProducto.setBounds(179, 254, 150, 35);
		add(textoTipoProducto);

		comboBoxTipoProducto = new JComboBox<TipoProductoInventario>();
		comboBoxTipoProducto.setEnabled(false);
		comboBoxTipoProducto.setRenderer(new DefaultListCellRenderer() {
			@Override
			public void paint(Graphics arg0) {
				setBackground(colorPrincipal);
				setForeground(colorSecundario);
				super.paint(arg0);
			}
		});
		comboBoxTipoProducto.setModel(new DefaultComboBoxModel<TipoProductoInventario>(TipoProductoInventario.values()));
		comboBoxTipoProducto.setForeground(colorSecundario);
		comboBoxTipoProducto.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		comboBoxTipoProducto.setFocusable(false);
		comboBoxTipoProducto.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxTipoProducto.setBackground(colorPrincipal);
		comboBoxTipoProducto.setBounds(339, 254, 160, 35);
		add(comboBoxTipoProducto);

		cajaMarca = new JTextField();
		cajaMarca.setEditable(false);
		cajaMarca.setForeground(colorSecundario);
		cajaMarca.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaMarca.setColumns(10);
		cajaMarca.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaMarca.setBackground(colorPrincipal);
		cajaMarca.setBounds(339, 304, 160, 35);
		add(cajaMarca);

		textoMarca = new JLabel("Marca");
		textoMarca.setRequestFocusEnabled(false);
		textoMarca.setHorizontalAlignment(SwingConstants.RIGHT);
		textoMarca.setForeground(colorFuente);
		textoMarca.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoMarca.setBounds(179, 304, 150, 35);
		add(textoMarca);

		textoContenido = new JLabel("Contenido");
		textoContenido.setRequestFocusEnabled(false);
		textoContenido.setHorizontalAlignment(SwingConstants.RIGHT);
		textoContenido.setForeground(colorFuente);
		textoContenido.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoContenido.setBounds(179, 354, 150, 35);
		add(textoContenido);

		cajaContenido = new JTextField();
		cajaContenido.setEditable(false);
		cajaContenido.setForeground(colorSecundario);
		cajaContenido.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaContenido.setColumns(10);
		cajaContenido.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaContenido.setBackground(colorPrincipal);
		cajaContenido.setBounds(339, 354, 160, 35);
		add(cajaContenido);

		textoUnidadMedida = new JLabel("Unidad de Medida");
		textoUnidadMedida.setRequestFocusEnabled(false);
		textoUnidadMedida.setHorizontalAlignment(SwingConstants.RIGHT);
		textoUnidadMedida.setForeground(colorFuente);
		textoUnidadMedida.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoUnidadMedida.setBounds(179, 404, 150, 35);
		add(textoUnidadMedida);

		comboBoxUnidadMedida = new JComboBox<UnidadMedida>();
		comboBoxUnidadMedida.setEnabled(false);
		comboBoxUnidadMedida.setRenderer(new DefaultListCellRenderer() {
			@Override
			public void paint(Graphics arg0) {
				setBackground(colorPrincipal);
				setForeground(colorSecundario);
				super.paint(arg0);
			}
		});
		comboBoxUnidadMedida.setModel(new DefaultComboBoxModel<UnidadMedida>(UnidadMedida.values()));
		comboBoxUnidadMedida.setForeground(colorSecundario);
		comboBoxUnidadMedida.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		comboBoxUnidadMedida.setFocusable(false);
		comboBoxUnidadMedida.setBorder(new LineBorder(colorSecundario, 1, true));
		comboBoxUnidadMedida.setBackground(colorPrincipal);
		comboBoxUnidadMedida.setBounds(339, 404, 160, 35);
		add(comboBoxUnidadMedida);

		textoPrecio = new JLabel("Precio");
		textoPrecio.setRequestFocusEnabled(false);
		textoPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		textoPrecio.setForeground(colorFuente);
		textoPrecio.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoPrecio.setBounds(179, 451, 150, 35);
		add(textoPrecio);

		cajaPrecio = new JTextField();
		cajaPrecio.setEditable(false);
		cajaPrecio.setForeground(colorSecundario);
		cajaPrecio.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaPrecio.setColumns(10);
		cajaPrecio.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaPrecio.setBackground(colorPrincipal);
		cajaPrecio.setBounds(339, 451, 160, 35);
		add(cajaPrecio);

		panelOpcionesGenerales = new PanelOpcionesGenerales();

		panelOpcionesGenerales.setBounds(511, 211, 135, 217);
		add(panelOpcionesGenerales);


		botonNuevo = panelOpcionesGenerales.getBotonNuevo();
		botonNuevo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editando=false;
				cajaCodigoBarras.setEditable(true);
				cajaCodigoBarras.setText("");
				cajaNombre.setEditable(true);
				cajaNombre.setText("");
				comboBoxTipoProducto.setEnabled(true);;
				comboBoxTipoProducto.setSelectedItem(comboBoxTipoProducto.getItemAt(0));
				cajaMarca.setEditable(true);
				cajaMarca.setText("");
				cajaContenido.setEditable(true);
				cajaContenido.setText("");
				comboBoxUnidadMedida.setEnabled(true);
				comboBoxUnidadMedida.setSelectedItem(comboBoxTipoProducto.getItemAt(0));
				cajaPrecio.setEditable(true);
				cajaPrecio.setText("");
			}
		});

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
				producto.setPrecio(Double.parseDouble(cajaPrecio.getText()));
				if(editando) {
					serviceProductoInventario.modificarProducto(producto);
					JOptionPane.showMessageDialog(null, "Producto Modificado");
					modelo.removeRow(tabla.getSelectedRow());
					modelo.fireTableDataChanged();
				}
				else {
					if(!serviceProductoInventario.existeProducto(producto.getCodigoBarras())) {
						serviceProductoInventario.registrarProducto(producto);
						modelo.addRow(new Object[] {producto.getCodigoBarras(),producto.getNombreProducto(),producto.getTipoProducto().toString(),producto.getMarca(),producto.getContenido(),producto.getUnidadMedida().toString()});
						JOptionPane.showMessageDialog(null, "Producto Registrado");
						modelo.fireTableDataChanged();
					}
					else
						JOptionPane.showMessageDialog(null, "El código de barras ingresado ya existe");
				}
			}
		});

		botonEditar = panelOpcionesGenerales.getBotonEditar();
		botonEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				editando=true;
				cajaCodigoBarras.setEditable(true);
				cajaNombre.setEditable(true);
				comboBoxTipoProducto.setEnabled(true);
				cajaMarca.setEditable(true);
				cajaContenido.setEditable(true);
				comboBoxUnidadMedida.setEnabled(true);
				cajaPrecio.setEditable(true);
			}
		});

		botonEliminar = panelOpcionesGenerales.getBotonEliminar();
		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String codigoBarras = cajaCodigoBarras.getText();
				if(serviceProductoInventario.existeProducto(codigoBarras)) {
					serviceProductoInventario.eliminarProducto(codigoBarras);
					JOptionPane.showMessageDialog(null, "Producto Eliminado");
					modelo.fireTableDataChanged();
				}
				else
					JOptionPane.showMessageDialog(null, "El producto no existe");

			}
		});

		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] columnas = new String[] {"CodigoBarra","Nombre","Tipo","Marca","Contenido","UnidadMedida","Precio"};

		modelo.setColumnIdentifiers(columnas);
		tabla = new JTable(modelo);
		tabla.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				int fila = tabla.rowAtPoint(e.getPoint());
				int columna = tabla.columnAtPoint(e.getPoint());
				if (fila > -1) {
					editando=false;
					ProductoInventario p = serviceProductoInventario.getProducto(modelo.getValueAt(fila, 0).toString());
					cajaCodigoBarras.setEditable(false);
					cajaCodigoBarras.setText(p.getCodigoBarras());
					cajaNombre.setEditable(false);
					cajaNombre.setText(p.getNombreProducto());
					comboBoxTipoProducto.setEnabled(false);;
					comboBoxTipoProducto.setSelectedItem(p.getTipoProducto());
					cajaMarca.setEditable(false);
					cajaMarca.setText(p.getMarca());
					cajaContenido.setEditable(false);
					cajaContenido.setText(p.getContenido()+"");
					comboBoxUnidadMedida.setEnabled(false);
					comboBoxUnidadMedida.setSelectedItem(p.getUnidadMedida());
					cajaPrecio.setEditable(false);
					cajaPrecio.setText(p.getPrecio()+"");
				}
			}
		});
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFont(new Font("Noto Sans", Font.PLAIN, 16));
		tabla.setForeground(colorSecundario);
		tabla.setRowHeight(30);

		encabezado = tabla.getTableHeader();
		encabezado.setBackground(colorPrincipal);
		encabezado.setForeground(colorSecundario);
		encabezado.setFont(new Font("Noto Sans", Font.BOLD, 16));

		productos = serviceProductoInventario.getProductos();
		for (ProductoInventario p : productos) {
			modelo.addRow(new Object[] {p.getCodigoBarras(),p.getNombreProducto(),p.getTipoProducto().toString(),p.getMarca(),p.getContenido(),p.getUnidadMedida().toString(),p.getPrecio()});
		}
		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(661, 154, 800, 332);
		add(scrollPane);
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
