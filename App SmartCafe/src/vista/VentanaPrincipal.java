package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import api.ServiceProductoInventario;
import dao.BaseDatos;
import dao.FuenteDatos;
import dao.TablaProductoInventario;
import enumeraciones.TipoProducto;
import enumeraciones.UnidadMedida;
import modelo.Precio;
import modelo.ProductoInventario;
import services.ServiceProductoInventarioImpl;

import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Component;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 4196183864480321960L;
	
	private ServiceProductoInventario serviceProductoInventario;
	
	private JPanel contentPane;
	
	private PanelMenuPrincipal panelMenuPrincipal;
	private PanelMenuInventario panelMenuInventario;
	private PanelCapturaProductoInventario panelCapturaProductoInventario;
	
	private JLabel logoEncabezado;
	private JLabel fondoEncabezado;
	
	private JButton botonVentas;
	private JButton botonCatalogo;
	private JButton botonInventario;
	
	private JButton botonRegistrar;
	private JButton botonModificar;
	private JButton botonBuscar;
	private JButton botonEliminar;
	private JButton botonResurtir;
	
	private JComboBox<TipoProducto> comboBoxTipoProducto;
	private JTextField cajaNombre;
	private JComboBox<UnidadMedida> comboBoxUnidadMedida;
	private JTextField cajaMarca;
	private JTextField cajaContenido;
	private JTextField cajaCodigoBarras;
	private JTextField cajaPrecio;
	
	private JButton botonAceptar;
	private JButton botonSalir;
	
	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);
	
	BaseDatos baseDatos;
	Connection conexion;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/recursos/frappe.png")));
		setBackground(UIManager.getColor("Button.darkShadow"));
		
		conectarDB();
		setTitle("App Cafetería");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 358);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelEncabezado = new JPanel();
		contentPane.add(panelEncabezado, BorderLayout.NORTH);
		GridBagLayout gbl_panelEncabezado = new GridBagLayout();
		gbl_panelEncabezado.columnWidths = new int[]{685, 0};
		gbl_panelEncabezado.rowHeights = new int[]{150, 0};
		gbl_panelEncabezado.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelEncabezado.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelEncabezado.setLayout(gbl_panelEncabezado);
		
		logoEncabezado = new JLabel("");
		logoEncabezado.setAlignmentY(Component.TOP_ALIGNMENT);
		logoEncabezado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/logo.png")));
		GridBagConstraints gbc_logoEncabezado = new GridBagConstraints();
		gbc_logoEncabezado.fill = GridBagConstraints.BOTH;
		gbc_logoEncabezado.gridx = 0;
		gbc_logoEncabezado.gridy = 0;
		panelEncabezado.add(logoEncabezado, gbc_logoEncabezado);
		
		fondoEncabezado = new JLabel("");
		fondoEncabezado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/recursos/FondoBarraSuperior.png")));
		GridBagConstraints gbc_fondoEncabezado = new GridBagConstraints();
		gbc_fondoEncabezado.anchor = GridBagConstraints.NORTH;
		gbc_fondoEncabezado.fill = GridBagConstraints.HORIZONTAL;
		gbc_fondoEncabezado.gridx = 0;
		gbc_fondoEncabezado.gridy = 0;
		panelEncabezado.add(fondoEncabezado, gbc_fondoEncabezado);
		
		panelMenuPrincipal = new PanelMenuPrincipal();
		panelMenuPrincipal.getBotonVentas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonVentas = panelMenuPrincipal.getBotonVentas();
		botonVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonCatalogo = panelMenuPrincipal.getBotonCatalogo();
		botonCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		botonInventario = panelMenuPrincipal.getBotonInventario();
		botonInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelMenuInventario = new PanelMenuInventario();
				botonRegistrar = panelMenuInventario.getBotonRegistrar();
				botonRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						panelCapturaProductoInventario = new PanelCapturaProductoInventario();
						cajaCodigoBarras = panelCapturaProductoInventario.getCajaCodigoBarras();
						cajaNombre = panelCapturaProductoInventario.getCajaNombre();
						comboBoxTipoProducto = panelCapturaProductoInventario.getComboBoxTipoProducto();
						comboBoxUnidadMedida = panelCapturaProductoInventario.getComboBoxUnidadMedida();
						cajaMarca = panelCapturaProductoInventario.getCajaMarca();
						cajaContenido = panelCapturaProductoInventario.getCajaContenido();
						cajaPrecio = panelCapturaProductoInventario.getCajaPrecio();
						contentPane.add(panelCapturaProductoInventario,BorderLayout.CENTER);
						PanelOpciones panelOpciones = new PanelOpciones();
						botonAceptar = panelOpciones.getBotonAceptar();
						botonAceptar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								ProductoInventario p = new ProductoInventario();
								p.setCodigoBarras(cajaCodigoBarras.getText());
								p.setNombreProducto(cajaNombre.getText());
								p.setTipoProducto(comboBoxTipoProducto.getItemAt(comboBoxTipoProducto.getSelectedIndex()));
								p.setMarca(cajaMarca.getText());
								p.setContenido(Double.parseDouble(cajaContenido.getText()));
								p.setUnidadMedida(comboBoxUnidadMedida.getItemAt(comboBoxUnidadMedida.getSelectedIndex()));

								serviceProductoInventario = new ServiceProductoInventarioImpl();
								serviceProductoInventario.registrar(p);
								JOptionPane.showMessageDialog(null, "Producto Registrado");
							}
						});
						botonSalir = panelOpciones.getBotonSalir();
						contentPane.add(panelOpciones,BorderLayout.EAST);
						setVisible(true);
					}
				});
				botonModificar = panelMenuInventario.getBotonModificar();
				botonBuscar = panelMenuInventario.getBotonBuscar();
				botonEliminar = panelMenuInventario.getBotonEliminar();
				botonResurtir = panelMenuInventario.getBotonResurtir();
				contentPane.add(panelMenuInventario,BorderLayout.WEST);
				setVisible(true);
			}
		});
		contentPane.add(panelMenuPrincipal,BorderLayout.SOUTH);
		setVisible(true);

	}
	
	public void conectarDB() {
//		String contraseña = JOptionPane.showInputDialog("Contraseña de la BD");
		baseDatos = new BaseDatos("smartcafe", "root", "serrato33");
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost:3306/");
		
		conexion = baseDatos.getConexion();
	}
}
