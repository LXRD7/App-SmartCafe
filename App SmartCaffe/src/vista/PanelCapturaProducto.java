package vista;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modelo.TablaProducto;

public class PanelCapturaProducto extends JPanel {
	private JPanel panelDatos;
	private JPanel panelImagen;
	private JTextField cajaNombre;
	private JLabel textoTipoProducto;
	private JComboBox<String> comboBoxTipoProducto;
	private JTextField cajaContenido;
	private JLabel textoContenido;
	private JComboBox<String> comboBoxUMedida;
	private JLabel textoUMedida;
	private JLabel textoNombre;
	
	private TablaProducto tablaProducto;

	/**
	 * Create the panel.
	 */
	public PanelCapturaProducto() {
		setLayout(new GridLayout(1, 2, 0, 0));
		
		panelDatos = new JPanel();
		add(panelDatos);
		panelDatos.setLayout(null);
		
		textoNombre = new JLabel("Nombre");
		textoNombre.setRequestFocusEnabled(false);
		textoNombre.setFont(new Font("Dialog", Font.BOLD, 16));
		textoNombre.setBounds(43, 69, 130, 34);
		panelDatos.add(textoNombre);
		
		cajaNombre = new JTextField();
		cajaNombre.setFont(new Font("Dialog", Font.PLAIN, 16));
		cajaNombre.setBounds(191, 69, 161, 34);
		panelDatos.add(cajaNombre);
		cajaNombre.setColumns(10);
		
		textoTipoProducto = new JLabel("Tipo Producto");
		textoTipoProducto.setRequestFocusEnabled(false);
		textoTipoProducto.setFont(new Font("Dialog", Font.BOLD, 16));
		textoTipoProducto.setBounds(43, 115, 130, 34);
		panelDatos.add(textoTipoProducto);
		
		comboBoxTipoProducto = new JComboBox<>();
		comboBoxTipoProducto.setFont(new Font("Dialog", Font.BOLD, 16));
		comboBoxTipoProducto.setBounds(191, 115, 161, 34);
		panelDatos.add(comboBoxTipoProducto);
		
		cajaContenido = new JTextField();
		cajaContenido.setFont(new Font("Dialog", Font.PLAIN, 16));
		cajaContenido.setColumns(10);
		cajaContenido.setBounds(191, 161, 161, 34);
		panelDatos.add(cajaContenido);
		
		textoContenido = new JLabel("Contenido");
		textoContenido.setRequestFocusEnabled(false);
		textoContenido.setFont(new Font("Dialog", Font.BOLD, 16));
		textoContenido.setBounds(43, 161, 130, 34);
		panelDatos.add(textoContenido);
		
		comboBoxUMedida = new JComboBox<>();
		comboBoxUMedida.setFont(new Font("Dialog", Font.BOLD, 16));
		comboBoxUMedida.setBounds(191, 207, 161, 34);
		panelDatos.add(comboBoxUMedida);
		
		textoUMedida = new JLabel("Unidad Medida");
		textoUMedida.setRequestFocusEnabled(false);
		textoUMedida.setFont(new Font("Dialog", Font.BOLD, 16));
		textoUMedida.setBounds(43, 207, 130, 34);
		panelDatos.add(textoUMedida);
		
		panelImagen = new JPanel();
		add(panelImagen);
		panelImagen.setLayout(null);
	}
	
	private void conectarTabla(Connection conexion) {
		tablaProducto = new TablaProducto(conexion);
	}
}
