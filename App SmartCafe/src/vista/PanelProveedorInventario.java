package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import api.ServiceProveedor;
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

	private JTable table;

	private Color colorPrincipal = new Color(175, 193, 11);
	private Color colorSecundario = new Color(75, 44, 14);

	public PanelProveedorInventario() {
		setOpaque(false);

		setPreferredSize(new Dimension(1000, 500));
		setLayout(null);

		textoClave = new JLabel("Clave ");
		textoClave.setHorizontalAlignment(SwingConstants.RIGHT);
		textoClave.setMinimumSize(new Dimension(106, 16));
		textoClave.setPreferredSize(new Dimension(106, 16));
		textoClave.setForeground(new Color(75, 44, 14));
		textoClave.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoClave.setBounds(178, 154, 150, 35);
		add(textoClave);

		cajaClave = new JTextField();
		cajaClave.setForeground(new Color(75, 44, 14));
		cajaClave.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaClave.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaClave.setBackground(new Color(175, 193, 11));
		cajaClave.setBounds(332, 155, 160, 35);
		add(cajaClave);

		cajaClave.setColumns(10);

		textoRazonSocial = new JLabel("Razón Social");
		textoRazonSocial.setForeground(new Color(75, 44, 14));
		textoRazonSocial.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoRazonSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		textoRazonSocial.setPreferredSize(new Dimension(106, 16));
		textoRazonSocial.setMinimumSize(new Dimension(106, 16));
		textoRazonSocial.setMaximumSize(new Dimension(106, 16));
		textoRazonSocial.setBounds(178, 201, 150, 35);
		add(textoRazonSocial);

		cajaRazonSocial = new JTextField();
		cajaRazonSocial.setForeground(new Color(75, 44, 14));
		cajaRazonSocial.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaRazonSocial.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaRazonSocial.setBackground(new Color(175, 193, 11));
		cajaRazonSocial.setBounds(332, 202, 160, 35);
		add(cajaRazonSocial);
		cajaRazonSocial.setColumns(10);

		textoCalle = new JLabel("Calle");
		textoCalle.setForeground(new Color(75, 44, 14));
		textoCalle.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCalle.setBounds(178, 242, 150, 35);
		add(textoCalle);

		cajaCalle = new JTextField();
		cajaCalle.setForeground(new Color(75, 44, 14));
		cajaCalle.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaCalle.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaCalle.setBackground(new Color(175, 193, 11));
		cajaCalle.setBounds(332, 243, 160, 35);
		add(cajaCalle);
		cajaCalle.setColumns(10);

		textoTelefono = new JLabel("Telefono");
		textoTelefono.setForeground(new Color(75, 44, 14));
		textoTelefono.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTelefono.setBounds(178, 289, 150, 35);
		add(textoTelefono);

		cajaTelefono = new JTextField();
		cajaTelefono.setForeground(new Color(75, 44, 14));
		cajaTelefono.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaTelefono.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaTelefono.setBackground(new Color(175, 193, 11));
		cajaTelefono.setBounds(332, 290, 160, 35);
		add(cajaTelefono);
		cajaTelefono.setColumns(10);

		textoEmail = new JLabel("Email");
		textoEmail.setForeground(new Color(75, 44, 14));
		textoEmail.setFont(new Font("Droid Sans", Font.BOLD, 16));
		textoEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		textoEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		textoEmail.setBounds(178, 336, 150, 35);
		add(textoEmail);

		cajaEmail = new JTextField();
		cajaEmail.setForeground(new Color(75, 44, 14));
		cajaEmail.setFont(new Font("Droid Sans", Font.PLAIN, 16));
		cajaEmail.setBorder(new LineBorder(colorSecundario, 1, true));
		cajaEmail.setBackground(new Color(175, 193, 11));
		cajaEmail.setBounds(332, 337, 160, 35);
		add(cajaEmail);
		cajaEmail.setColumns(10);

		panelOpcionesGenerales = new PanelOpcionesGenerales();
		panelOpcionesGenerales.setBounds(529, 154, 135, 217);
		add(panelOpcionesGenerales);
		botonNuevo = panelOpcionesGenerales.getBotonNuevo();

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

		table = new JTable();
		table.setGridColor(new Color(255, 255, 255));
		table.setBackground(new Color(240, 248, 255));
		table.setBounds(687, 388, 307, -258);
		add(table);

	}
}
