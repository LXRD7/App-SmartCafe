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
	private JPanel panelOpcionesGenerales;
	private JButton getBotonNuevo;
	private JButton getBotonGuardar;
	private JButton getBotonEditar;
	private JButton getBotonEliminar;
	private JTable table;

	public PanelProveedorInventario() {
		setOpaque(false);

		setPreferredSize(new Dimension(1000, 500));
		setLayout(null);
		
		textoClave = new JLabel("Clave ");
		textoClave.setHorizontalAlignment(SwingConstants.RIGHT);
		textoClave.setForeground(new Color(0, 0, 0));
		textoClave.setFont(new Font("Dialog", Font.BOLD, 16));
		textoClave.setMaximumSize(new Dimension(106, 16));
		textoClave.setMinimumSize(new Dimension(106, 16));
		textoClave.setPreferredSize(new Dimension(106, 16));
		textoClave.setBounds(178, 154, 150, 35);
		add(textoClave);
		
		cajaClave = new JTextField();
		cajaClave.setBorder(new LineBorder(new Color(0, 0, 0)));
		cajaClave.setBounds(332, 155, 160, 35);
		add(cajaClave);
		cajaClave.setColumns(10);
		
		textoRazonSocial = new JLabel("Razón Social");
		textoRazonSocial.setFont(new Font("Dialog", Font.BOLD, 16));
		textoRazonSocial.setHorizontalAlignment(SwingConstants.RIGHT);
		textoRazonSocial.setPreferredSize(new Dimension(106, 16));
		textoRazonSocial.setMinimumSize(new Dimension(106, 16));
		textoRazonSocial.setMaximumSize(new Dimension(106, 16));
		textoRazonSocial.setBounds(178, 201, 150, 35);
		add(textoRazonSocial);
		
		cajaRazonSocial = new JTextField();
		cajaRazonSocial.setBorder(new LineBorder(new Color(0, 0, 0)));
		cajaRazonSocial.setBounds(332, 202, 160, 35);
		add(cajaRazonSocial);
		cajaRazonSocial.setColumns(10);
		
		textoCalle = new JLabel("Calle");
		textoCalle.setFont(new Font("Dialog", Font.BOLD, 16));
		textoCalle.setHorizontalAlignment(SwingConstants.RIGHT);
		textoCalle.setBounds(178, 242, 150, 35);
		add(textoCalle);
		
		cajaCalle = new JTextField();
		cajaCalle.setBorder(new LineBorder(new Color(0, 0, 0)));
		cajaCalle.setBounds(332, 243, 160, 35);
		add(cajaCalle);
		cajaCalle.setColumns(10);
		
		textoTelefono = new JLabel("Telefono");
		textoTelefono.setFont(new Font("Dialog", Font.BOLD, 16));
		textoTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		textoTelefono.setBounds(178, 289, 150, 35);
		add(textoTelefono);
		
		cajaTelefono = new JTextField();
		cajaTelefono.setBorder(new LineBorder(new Color(0, 0, 0)));
		cajaTelefono.setBounds(332, 290, 160, 35);
		add(cajaTelefono);
		cajaTelefono.setColumns(10);
		
		textoEmail = new JLabel("Email");
		textoEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		textoEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		textoEmail.setBounds(178, 336, 150, 35);
		add(textoEmail);
		
		cajaEmail = new JTextField();
		cajaEmail.setBorder(new LineBorder(new Color(0, 0, 0)));
		cajaEmail.setBounds(332, 337, 160, 35);
		add(cajaEmail);
		cajaEmail.setColumns(10);
		
		panelOpcionesGenerales = new JPanel();
		panelOpcionesGenerales.setBounds(535, 157, 135, 216);
		add(panelOpcionesGenerales);
		panelOpcionesGenerales.setLayout(new GridLayout(0, 1, 0, 0));
		
		getBotonNuevo = new JButton("Añadir");
		getBotonNuevo.setFont(new Font("Dialog", Font.BOLD, 18));
		getBotonNuevo.setIcon(new ImageIcon(PanelProveedorInventario.class.getResource("/recursos/iconos/anadir.png")));
		getBotonNuevo.setToolTipText("Añadir");
		panelOpcionesGenerales.add(getBotonNuevo);
		
		getBotonGuardar = new JButton("Guardar");
		getBotonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serviceProveedor = new ServiceProveedorImpl();
				Proveedor proveedor = new Proveedor();
				proveedor.setClaveProveedor(Integer.parseInt(cajaClave.getText()));
				proveedor.setRazonSocial(cajaRazonSocial.getText());
				proveedor.setCalle(cajaCalle.getText());
				proveedor.setTelefono(Integer.parseInt(cajaTelefono.getText()));
				proveedor.setEmail(cajaEmail.getText());
				
				if(!serviceProveedor.existeProveedor(proveedor.getClaveProveedor()))
					serviceProveedor.registrarProveedor(proveedor);
				else
					JOptionPane.showMessageDialog(null, "La clave del proveedor ingresada ya existe");
			}	
			
		});
		getBotonGuardar.setFont(new Font("Dialog", Font.BOLD, 18));
		getBotonGuardar.setIcon(new ImageIcon(PanelProveedorInventario.class.getResource("/recursos/iconos/salvar.png")));
		getBotonGuardar.setToolTipText("Guardar");
		panelOpcionesGenerales.add(getBotonGuardar);
		
		getBotonEditar = new JButton("Editar");
		getBotonEditar.setIcon(new ImageIcon(PanelProveedorInventario.class.getResource("/recursos/iconos/lapiz.png")));
		getBotonEditar.setFont(new Font("Dialog", Font.BOLD, 18));
		getBotonEditar.setToolTipText("Editar");
		panelOpcionesGenerales.add(getBotonEditar);
		
		getBotonEliminar = new JButton("Eliminar");
		getBotonEliminar.setIcon(new ImageIcon(PanelProveedorInventario.class.getResource("/recursos/iconos/eliminar.png")));
		getBotonEliminar.setFont(new Font("Dialog", Font.BOLD, 18));
		getBotonEliminar.setToolTipText("Eliminar");
		panelOpcionesGenerales.add(getBotonEliminar);
		
		table = new JTable();
		table.setGridColor(new Color(255, 255, 255));
		table.setBackground(new Color(240, 248, 255));
		table.setBounds(687, 388, 307, -258);
		add(table);
		
	}
}
