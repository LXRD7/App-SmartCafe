package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import api.ServiceProveedor;
import modelo.ProductoInventario;
import modelo.Proveedor;
import services.ServiceProveedorImpl;

public class PanelProveedorInventario extends JPanel {
	
	private ServiceProveedor serviceProveedor;

	private JTextField cajaClave;
	private JTextField cajaRazonSocial;
	private JTextField cajaCalle;
	private JTextField cajaTelefono;
	private JTextField cajaEmail;
	private JLabel textoEmail;
	private JLabel textoTelefono;
	private JLabel textoCalle;
	private JLabel textoRazonSocial;
	private JLabel textoClave;

	private PanelOpcionesGenerales panelOpcionesGenerales;
	private JButton botonNuevo;
	private JButton botonGuardar;
	private JButton botonEditar;
	private JButton botonEliminar;

	private JScrollPane scrollPane;
	private JTable tabla;
	private JTableHeader encabezado;
	private DefaultTableModel modelo;

	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);
	private Color colorFuente = Color.WHITE;

	private boolean editando;
	
	List<Proveedor> proveedores;

	public PanelProveedorInventario() {
		setOpaque(false);

		setPreferredSize(new Dimension(1000, 500));
		setLayout(null);

		textoClave = new JLabel("Clave ");
		textoClave.setHorizontalAlignment(SwingConstants.RIGHT);
		textoClave.setMinimumSize(new Dimension(106, 16));
		textoClave.setPreferredSize(new Dimension(106, 16));
		textoClave.setForeground(colorFuente);
		textoClave.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoClave.setBounds(178, 154, 150, 35);
		add(textoClave);

		cajaClave = new JTextField();
		cajaClave.setForeground(colorSecundario);
		cajaClave.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaClave.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaClave.setBackground(new Color(175, 193, 11));
		cajaClave.setBounds(332, 155, 160, 35);
		add(cajaClave);

		cajaClave.setColumns(10);

		textoRazonSocial = new JLabel("Razón Social");
		textoRazonSocial.setForeground(colorFuente);
		textoRazonSocial.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoRazonSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		textoRazonSocial.setPreferredSize(new Dimension(106, 16));
		textoRazonSocial.setMinimumSize(new Dimension(106, 16));
		textoRazonSocial.setMaximumSize(new Dimension(106, 16));
		textoRazonSocial.setBounds(178, 202, 150, 35);
		add(textoRazonSocial);

		cajaRazonSocial = new JTextField();
		cajaRazonSocial.setForeground(colorSecundario);
		cajaRazonSocial.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaRazonSocial.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaRazonSocial.setBackground(new Color(175, 193, 11));
		cajaRazonSocial.setBounds(332, 202, 160, 35);
		add(cajaRazonSocial);
		cajaRazonSocial.setColumns(10);

		textoCalle = new JLabel("Calle");
		textoCalle.setForeground(colorFuente);
		textoCalle.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCalle.setBounds(178, 249, 150, 35);
		add(textoCalle);

		cajaCalle = new JTextField();
		cajaCalle.setForeground(colorSecundario);
		cajaCalle.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaCalle.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaCalle.setBackground(new Color(175, 193, 11));
		cajaCalle.setBounds(332, 249, 160, 35);
		add(cajaCalle);
		cajaCalle.setColumns(10);

		textoTelefono = new JLabel("Telefono");
		textoTelefono.setForeground(colorFuente);
		textoTelefono.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTelefono.setBounds(178, 296, 150, 35);
		add(textoTelefono);

		cajaTelefono = new JTextField();
		cajaTelefono.setForeground(colorSecundario);
		cajaTelefono.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaTelefono.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaTelefono.setBackground(new Color(175, 193, 11));
		cajaTelefono.setBounds(332, 296, 160, 35);
		add(cajaTelefono);
		cajaTelefono.setColumns(10);

		textoEmail = new JLabel("Email");
		textoEmail.setForeground(colorFuente);
		textoEmail.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		textoEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		textoEmail.setBounds(178, 342, 150, 35);
		add(textoEmail);

		cajaEmail = new JTextField();
		cajaEmail.setForeground(colorSecundario);
		cajaEmail.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaEmail.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaEmail.setBackground(new Color(175, 193, 11));
		cajaEmail.setBounds(332, 343, 160, 35);
		add(cajaEmail);
		cajaEmail.setColumns(10);

		panelOpcionesGenerales = new PanelOpcionesGenerales();


		panelOpcionesGenerales.setBounds(529, 154, 135, 217);
		add(panelOpcionesGenerales);
		botonNuevo = panelOpcionesGenerales.getBotonNuevo();
		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editando=false;
				cajaClave.setEditable(true);
				cajaClave.setText("");
				cajaRazonSocial.setEditable(true);
				cajaRazonSocial.setText("");
				cajaCalle.setEditable(true);
				cajaCalle.setText("");
				cajaTelefono.setEditable(true);
				cajaTelefono.setText("");
				cajaEmail.setEditable(true);
				cajaEmail.setText("");
			}
		});

		botonGuardar = panelOpcionesGenerales.getBotonGuardar();
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serviceProveedor = new ServiceProveedorImpl();
				Proveedor proveedor = new Proveedor();
				proveedor.setClaveProveedor(Integer.parseInt(cajaClave.getText()));
				proveedor.setRazonSocial(cajaRazonSocial.getText());
				proveedor.setCalle(cajaCalle.getText());
				proveedor.setTelefono(cajaTelefono.getText());
				proveedor.setEmail(cajaEmail.getText());

				if(!serviceProveedor.existeProveedor(proveedor.getClaveProveedor()))
					serviceProveedor.registrarProveedor(proveedor);
				else
					JOptionPane.showMessageDialog(null, "La clave del proveedor ingresada ya existe");
			}	

		});

		botonEditar = panelOpcionesGenerales.getBotonEditar();

		botonEliminar = panelOpcionesGenerales.getBotonEliminar();




		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] columnas = new String[] {"ClaveProveedor","RazonSocial","Calle","Telefono","Email"};
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
					Proveedor p = serviceProveedor.getProveedor(Integer.parseInt(modelo.getValueAt(fila, 0).toString()));
					cajaClave.setEditable(false);
					cajaClave.setText(p.getClaveProveedor()+"");
					cajaRazonSocial.setEditable(false);
					cajaRazonSocial.setText(p.getRazonSocial());
					cajaCalle.setEditable(false);
					cajaCalle.setText(p.getCalle());
					cajaTelefono.setEditable(false);
					cajaTelefono.setText(p.getTelefono()+"");
					cajaEmail.setEditable(false);
					cajaEmail.setText(p.getEmail());
				}
			}
		});
		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setFont(new Font("Noto Sans", Font.PLAIN, 16));
		tabla.setForeground(colorSecundario);
		tabla.setRowHeight(30);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setGridColor(new Color(255, 255, 255));
		tabla.setBackground(new Color(240, 248, 255));
		tabla.setBounds(687, 388, 307, -258);
		add(tabla);
		
		encabezado = tabla.getTableHeader();
		encabezado.setBackground(colorPrincipal);
		encabezado.setForeground(colorSecundario);
		encabezado.setFont(new Font("Noto Sans", Font.BOLD, 16));

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
}
