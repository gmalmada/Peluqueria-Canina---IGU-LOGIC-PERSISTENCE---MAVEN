package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 559, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Peluqueria Canina");
		lblNewLabel.setBounds(185, 5, 199, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 57, 301, 351);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCargaDatos = new JButton("Cargar datos");
		btnCargaDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //Conexion entre Principal y Car
				CargaDatos pantalla = new CargaDatos();//Nueva funcion del boton
				pantalla.setVisible(true); //Hacer visible la interfaz
				pantalla.setLocationRelativeTo(null); //Hacer que aparezca en medio de la pantalla
			}
		});
		btnCargaDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCargaDatos.setBounds(22, 24, 247, 58);
		panel_1.add(btnCargaDatos);
		
		JButton btnVerDatos = new JButton("Ver datos");
		btnVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerDatos pantalla = new VerDatos();//Nueva funcion del boton
				pantalla.setVisible(true); //Hacer visible la interfaz
				pantalla.setLocationRelativeTo(null); //Hacer que aparezca en medio de la pantalla
			}
		});
		btnVerDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnVerDatos.setBounds(22, 116, 247, 58);
		panel_1.add(btnVerDatos);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSalir.setBounds(22, 197, 247, 58);
		panel_1.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/WhatsApp Image 2026-01-08 at 00.52.35.jpeg")));
		lblNewLabel_1.setBounds(321, 84, 233, 243);
		panel.add(lblNewLabel_1);

	}
}
