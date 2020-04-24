package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import dao.BaseDatos;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	private JLabel logoEncabezado;
	private JLabel fondoEncabezado;
	
	BaseDatos baseDatos;
	Connection conexion;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		
		conectarDB();
		setTitle("App Cafetería");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 358);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new EmptyBorder(0, 0, 0, 0));
		menuBar.setBorderPainted(false);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Control de Inventario");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Almacén");
		menuBar.add(mnNewMenu_1);
		
		JMenu mnNewMenu_2 = new JMenu("Control ");
		menuBar.add(mnNewMenu_2);
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
		
		PanelCapturaProducto panelCapturaProducto = new PanelCapturaProducto();
		contentPane.add(panelCapturaProducto,BorderLayout.CENTER);
		setVisible(true);

	}
	
	public void conectarDB() {
		String contraseña = JOptionPane.showInputDialog("Contraseña de la BD");
		baseDatos = new BaseDatos("smartcafe", "root", contraseña);
		baseDatos.setDriver("com.mysql.jdbc.Driver");
		baseDatos.setProtocolo("jdbc:mysql://localhost:3306/");
		
		conexion = baseDatos.getConexion();
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
