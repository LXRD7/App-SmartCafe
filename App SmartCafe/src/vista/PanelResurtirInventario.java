package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

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

import com.toedter.calendar.JDateChooser;

import api.ServiceResurtir;
import modelo.Proveedor;
import modelo.Resurtir;
import services.ServiceProveedorImpl;
import services.ServiceResurtirImpl;

public class PanelResurtirInventario extends JPanel {

	private ServiceResurtir serviceResurtir;

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

	private JTextField cajaNumeroResurtir;
	private JTextField cajaPrecioUnidad;
	private JTextField cajaLote;
	private JTextField cajaBaja;
	private JLabel textoPrecioUnidad;
	private JLabel textoFechaCaducidad;
	private JLabel textoBaja;
	private JLabel textoLote;
	private JLabel textoNumeroResurtir;
	private JDateChooser dateChooserFechaCaducidad;

	List<Resurtir> resurtidos;


	public PanelResurtirInventario() {
		setPreferredSize(new Dimension(1000, 500));
		setLayout(null);

		serviceResurtir = new ServiceResurtirImpl();

		textoNumeroResurtir = new JLabel("Número Resurtir");
		textoNumeroResurtir.setHorizontalAlignment(SwingConstants.RIGHT);
		textoNumeroResurtir.setMinimumSize(new Dimension(106, 16));
		textoNumeroResurtir.setPreferredSize(new Dimension(106, 16));
		textoNumeroResurtir.setForeground(colorFuente);
		textoNumeroResurtir.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoNumeroResurtir.setBounds(184, 137, 150, 35);
		add(textoNumeroResurtir);

		cajaNumeroResurtir = new JTextField();
		cajaNumeroResurtir.setForeground(colorSecundario);
		cajaNumeroResurtir.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaNumeroResurtir.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaNumeroResurtir.setBackground(new Color(175, 193, 11));
		cajaNumeroResurtir.setBounds(346, 142, 160, 35);
		add(cajaNumeroResurtir);
		cajaNumeroResurtir.setColumns(10);

		textoPrecioUnidad = new JLabel("Precio Unidad");
		textoPrecioUnidad.setHorizontalAlignment(SwingConstants.RIGHT);
		textoPrecioUnidad.setMinimumSize(new Dimension(106, 16));
		textoPrecioUnidad.setPreferredSize(new Dimension(106, 16));
		textoPrecioUnidad.setForeground(colorFuente);
		textoPrecioUnidad.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoPrecioUnidad.setBounds(184, 180, 150, 35);
		add(textoPrecioUnidad);

		cajaPrecioUnidad = new JTextField();
		cajaPrecioUnidad.setForeground(colorSecundario);
		cajaPrecioUnidad.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaPrecioUnidad.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaPrecioUnidad.setBackground(new Color(175, 193, 11));
		cajaPrecioUnidad.setBounds(346, 185, 160, 35);
		add(cajaPrecioUnidad);
		cajaPrecioUnidad.setColumns(10);

		textoFechaCaducidad = new JLabel("Fecha Caducidad");
		textoFechaCaducidad.setHorizontalAlignment(SwingConstants.RIGHT);
		textoFechaCaducidad.setMinimumSize(new Dimension(106, 16));
		textoFechaCaducidad.setPreferredSize(new Dimension(106, 16));
		textoFechaCaducidad.setForeground(colorFuente);
		textoFechaCaducidad.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoFechaCaducidad.setBounds(184, 227, 150, 35);
		add(textoFechaCaducidad);

		dateChooserFechaCaducidad = new JDateChooser();
		dateChooserFechaCaducidad.setForeground(colorSecundario);
		dateChooserFechaCaducidad.setDateFormatString("yyyy-dd-MM");
		dateChooserFechaCaducidad.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		dateChooserFechaCaducidad.setBorder(new LineBorder(colorSecundario,1,true));
		dateChooserFechaCaducidad.setBackground(new Color(175,193,11));
		dateChooserFechaCaducidad.setBounds(346, 231, 160, 35);
		add(dateChooserFechaCaducidad);

		textoLote = new JLabel("Lote");
		textoLote.setHorizontalAlignment(SwingConstants.RIGHT);
		textoLote.setMinimumSize(new Dimension(106, 16));
		textoLote.setPreferredSize(new Dimension(106, 16));
		textoLote.setForeground(colorFuente);
		textoLote.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoLote.setBounds(184, 273, 150, 35);
		add(textoLote);

		cajaLote = new JTextField();
		cajaLote.setForeground(colorSecundario);
		cajaLote.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaLote.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaLote.setBackground(new Color(175, 193, 11));
		cajaLote.setBounds(346, 278, 160, 35);
		add(cajaLote);
		cajaLote.setColumns(10);

		textoBaja = new JLabel("Baja");
		textoBaja.setHorizontalAlignment(SwingConstants.RIGHT);
		textoBaja.setMinimumSize(new Dimension(106, 16));
		textoBaja.setPreferredSize(new Dimension(106, 16));
		textoBaja.setForeground(colorFuente);
		textoBaja.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoBaja.setBounds(184, 315, 150, 35);
		add(textoBaja);

		cajaBaja = new JTextField();
		cajaBaja.setForeground(colorSecundario);
		cajaBaja.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaBaja.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaBaja.setBackground(new Color(175, 193, 11));
		cajaBaja.setBounds(346, 320, 160, 35);
		add(cajaBaja);
		cajaBaja.setColumns(10);

		panelOpcionesGenerales = new PanelOpcionesGenerales();
		panelOpcionesGenerales.setBounds(525, 140, 135, 217);
		add(panelOpcionesGenerales);

		botonNuevo = panelOpcionesGenerales.getBotonNuevo();
		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editando=false;
				cajaNumeroResurtir.setEditable(true);
				cajaNumeroResurtir.setText("");
				cajaPrecioUnidad.setEditable(true);
				cajaPrecioUnidad.setText("");
				dateChooserFechaCaducidad.setFocusable(true);
				dateChooserFechaCaducidad.setDate(null);
				cajaLote.setEditable(true);
				cajaLote.setText("");
				cajaBaja.setEditable(true);
				cajaBaja.setText("");
			}
		});

		botonGuardar = panelOpcionesGenerales.getBotonGuardar();
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				serviceResurtir = new ServiceResurtirImpl();
				Resurtir resurtir = new Resurtir();
				resurtir.setNumResurtir(Integer.parseInt(cajaNumeroResurtir.getText()));
				resurtir.setFechaResurtir(LocalDate.now());
				resurtir.setPrecioUnidad(Integer.parseInt(cajaPrecioUnidad.getText()));

				int año=dateChooserFechaCaducidad.getCalendar().get(Calendar.YEAR);
				int mes=dateChooserFechaCaducidad.getCalendar().get(Calendar.DAY_OF_MONTH);
				int dia=dateChooserFechaCaducidad.getCalendar().get(Calendar.MARCH);
				String fecha=año+"-"+mes+"-"+dia+"-";
				
				resurtir.setFechaCaducidad(LocalDate.parse(fecha));
				resurtir.setLote(Integer.parseInt(cajaLote.getText()));
				resurtir.setBaja(Integer.parseInt(cajaBaja.getText()));

				if(editando) {
					serviceResurtir.modificarResurtir(resurtir);
					JOptionPane.showMessageDialog(null, "Resurtido Modificado");
					modelo.removeRow(tabla.getSelectedRow());
					modelo.addRow(new Object[] {resurtir.getNumResurtir(),resurtir.getFechaResurtir(),resurtir.getPrecioUnidad(),resurtir.getFechaCaducidad(),resurtir.getLote(),resurtir.getBaja()});
					modelo.fireTableDataChanged();
				}
				else {
					if(!serviceResurtir.existeResurtir(resurtir.getNumResurtir())) {
						serviceResurtir.registrarResurtir(resurtir);
						modelo.addRow(new Object[] {resurtir.getNumResurtir(),resurtir.getFechaResurtir(),resurtir.getPrecioUnidad(),resurtir.getFechaCaducidad(),resurtir.getLote(),resurtir.getBaja()});
						JOptionPane.showMessageDialog(null, "Resurtido Registrado.");
						modelo.fireTableDataChanged();
					}
					else
						JOptionPane.showMessageDialog(null, "El número de resurtido ingresado ya existe");
				}
			}
		});

		botonEditar = panelOpcionesGenerales.getBotonEditar();
		botonEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				editando=true;
				cajaNumeroResurtir.setEditable(true);
				cajaPrecioUnidad.setEditable(true);
				dateChooserFechaCaducidad.setFocusable(true);
				cajaLote.setEditable(true);
				cajaBaja.setEditable(true);
			}
		});

		botonEliminar = panelOpcionesGenerales.getBotonEliminar();
		botonEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int numResurtir = Integer.parseInt(cajaNumeroResurtir.getText());
				if(serviceResurtir.existeResurtir(numResurtir) && tabla.getSelectedRow() != -1) {
					serviceResurtir.eliminarResurtir(numResurtir);
					JOptionPane.showMessageDialog(null, "Resurtido Eliminado.");
					modelo.removeRow(tabla.getSelectedRow());
				}
				else
					JOptionPane.showMessageDialog(null, "El Resurtido no existe");

			}
		});

		modelo = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		String[] columnas = new String[] {"NumeroResurtido","FechaResurtir","PrecioUnidad","FechaCaducidad","Lote","Baja"};
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
					Resurtir p = serviceResurtir.getResurtir(Integer.parseInt(modelo.getValueAt(fila, 0).toString()));
					cajaNumeroResurtir.setEditable(false);
					cajaNumeroResurtir.setText(p.getNumResurtir()+"");
					//Falta poder editar el campo FechaResurtir
					//
					cajaPrecioUnidad.setEditable(false);
					cajaPrecioUnidad.setText(p.getPrecioUnidad()+"");
					dateChooserFechaCaducidad.setFocusable(false);
					//					dateChooserFechaCaducidad.setToolTipText(p.getFechaCaducidad());
					cajaLote.setEditable(false);
					cajaLote.setText(p.getLote()+"");
					cajaBaja.setEditable(false);
					cajaBaja.setText(p.getBaja()+"");

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

		encabezado = tabla.getTableHeader();
		encabezado.setBackground(colorPrincipal);
		encabezado.setForeground(colorSecundario);
		encabezado.setFont(new Font("Noto Sans", Font.BOLD, 16));

		resurtidos = serviceResurtir.getResurtidos();
		for (Resurtir p : resurtidos) {
			modelo.addRow(new Object[] {p.getNumResurtir(),p.getFechaResurtir(),p.getPrecioUnidad(),p.getFechaCaducidad(),p.getLote(),p.getBaja()});
		}

		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(670, 140, 800, 332);
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
