package vista;

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import api.ServiceResurtir;
import modelo.Resurtir;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

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
	List<Resurtir> resurtidos;
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
	
	public PanelResurtirInventario() {
		setPreferredSize(new Dimension(1000, 500));
		setLayout(null);
		
		textoNumeroResurtir = new JLabel("Número Resurtir");
		textoNumeroResurtir.setBounds(184, 137, 61, 16);
		add(textoNumeroResurtir);
		
		cajaNumeroResurtir = new JTextField();
		cajaNumeroResurtir.setBounds(270, 132, 130, 26);
		add(cajaNumeroResurtir);
		cajaNumeroResurtir.setColumns(10);
		
		textoPrecioUnidad = new JLabel("Precio Unidad");
		textoPrecioUnidad.setBounds(184, 180, 61, 16);
		add(textoPrecioUnidad);
		
		cajaPrecioUnidad = new JTextField();
		cajaPrecioUnidad.setBounds(270, 175, 130, 26);
		add(cajaPrecioUnidad);
		cajaPrecioUnidad.setColumns(10);
		
		textoFechaCaducidad = new JLabel("Fecha Caducidad");
		textoFechaCaducidad.setBounds(184, 227, 61, 16);
		add(textoFechaCaducidad);
		
		dateChooserFechaCaducidad = new JDateChooser();
		dateChooserFechaCaducidad.setBounds(305, 217, 95, 26);
		add(dateChooserFechaCaducidad);
		
		textoLote = new JLabel("Lote");
		textoLote.setBounds(184, 273, 61, 16);
		add(textoLote);
		
		cajaLote = new JTextField();
		cajaLote.setBounds(270, 268, 130, 26);
		add(cajaLote);
		cajaLote.setColumns(10);
		
		textoBaja = new JLabel("Baja");
		textoBaja.setBounds(184, 315, 61, 16);
		add(textoBaja);
		
		cajaBaja = new JTextField();
		cajaBaja.setBounds(270, 310, 130, 26);
		add(cajaBaja);
		cajaBaja.setColumns(10);

	}
}
