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
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

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
	}
}
