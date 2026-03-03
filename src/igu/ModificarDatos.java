package igu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import logica.Controladora;
import logica.Mascota;

public class ModificarDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JTextField txtColor;
	private JTextField txtNomDuenio;
	private JTextField txtCelDuenio;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	Controladora control = new Controladora();
	int numCliente;
	Mascota masco;
	private JTextArea txtObservaciones;
	private JComboBox cmbAlergico;
	private JComboBox cmbAtEsp;
	
	public ModificarDatos(int numCliente) {
		
		this.numCliente = numCliente;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 851, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 11, 815, 488);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCargaDeDatos = new JLabel("Modificación de datos");
		lblCargaDeDatos.setBounds(324, 11, 167, 31);
		lblCargaDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblCargaDeDatos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ModificarDatos.class.getResource("/imagenes/WhatsApp Image 2026-01-08 at 00.52.35.jpeg")));
		lblNewLabel.setBounds(525, 56, 224, 237);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 64, 62, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Raza:");
		lblNewLabel_1_1.setBounds(10, 106, 46, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Color:");
		lblNewLabel_1_2.setBounds(10, 149, 46, 14);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Alérgico:");
		lblNewLabel_1_3.setBounds(10, 187, 83, 14);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("At. especial:");
		lblNewLabel_1_4.setBounds(10, 229, 140, 14);
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Nombre dueño:");
		lblNewLabel_1_5.setBounds(10, 279, 140, 14);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Cel. dueño:");
		lblNewLabel_1_6.setBounds(10, 304, 140, 14);
		panel.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Observaciones:");
		lblNewLabel_1_7.setBounds(10, 335, 140, 14);
		panel.add(lblNewLabel_1_7);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(66, 61, 407, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(66, 103, 407, 20);
		panel.add(txtRaza);
		
		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(66, 146, 407, 20);
		panel.add(txtColor);
		
		txtNomDuenio = new JTextField();
		txtNomDuenio.setColumns(10);
		txtNomDuenio.setBounds(102, 276, 371, 20);
		panel.add(txtNomDuenio);
		
		txtCelDuenio = new JTextField();
		txtCelDuenio.setColumns(10);
		txtCelDuenio.setBounds(102, 304, 371, 20);
		panel.add(txtCelDuenio);
		
		txtObservaciones = new JTextArea();
		txtObservaciones.setBounds(102, 335, 369, 118);
		panel.add(txtObservaciones);
		
		cmbAlergico = new JComboBox();
		cmbAlergico.setModel(new DefaultComboBoxModel(new String[] {"-", "SI", "NO"}));
		cmbAlergico.setBounds(181, 183, 292, 22);
		panel.add(cmbAlergico);
		
		cmbAtEsp = new JComboBox();
		cmbAtEsp.setModel(new DefaultComboBoxModel(new String[] {"-", "SI", "NO"}));
		cmbAtEsp.setBounds(180, 225, 293, 22);
		panel.add(cmbAtEsp);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setIcon(null);
		btnLimpiar.setBackground(new Color(255, 255, 255));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtRaza.setText("");
				txtColor.setText("");
				txtNomDuenio.setText("");
				txtCelDuenio.setText("");
				txtObservaciones.setText("");
				cmbAlergico.setSelectedIndex(0);
				cmbAtEsp.setSelectedIndex(0);
			}
		});
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimpiar.setBounds(578, 331, 124, 41);
		panel.add(btnLimpiar);
		
		JButton btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setBackground(new Color(255, 255, 255));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreMasco = txtNombre.getText();
				String raza = txtRaza.getText();
				String color = txtColor.getText();
				String observaciones = txtObservaciones.getText();
				String alergico = (String) cmbAlergico.getSelectedItem(); //Se añade el casteo a String (String)
				String atEsp = (String) cmbAtEsp.getSelectedItem();
				
				String nomDuenio = txtNomDuenio.getText();
				String celDuenio = txtCelDuenio.getText();
				
				control.modificarMascota(masco, nombreMasco, raza, color, observaciones, alergico, atEsp, nomDuenio, celDuenio);
				
				//Mostrar mensaje
				mostrarMensaje("Edicion exitosa.", "Info", "Edicion correcta");
				
				//Mostrar tabla con datos actualizados
				VerDatos pantalla = new VerDatos();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
				
				//Cerrar la ventana al terminar de modificar
				dispose();
				

			} 
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGuardar.setBounds(525, 405, 224, 41);
		panel.add(btnGuardar);
		
		cargarDatos(numCliente);
	}

	private void cargarDatos(int numCli) {
		this.masco = control.traerMascota(numCli);
		
		txtNombre.setText(masco.getNombreMascota());
		txtRaza.setText(masco.getRaza());
		txtColor.setText(masco.getColor());
		txtNomDuenio.setText(masco.getUnDuenio().getNombre());
		txtCelDuenio.setText(masco.getUnDuenio().getCelDuenio());
		txtObservaciones.setText(masco.getObservaciones());
		
		if(masco.getAlergico().equals("SI")) {
			cmbAlergico.setSelectedIndex(1); // 1 = Primero opcion. 0 es el guion.
		}else {
			if(masco.getAlergico().equals("NO")) {
			cmbAlergico.setSelectedIndex(2);
			}
		}
		
		if(masco.getAtEsp().equals("SI")) {
			cmbAtEsp.setSelectedIndex(1);
		}else {
			if(masco.getAtEsp().equals("NO")) {
			cmbAtEsp.setSelectedIndex(2);
			}
		}	
	}
	
	public void mostrarMensaje(String mensaje, String tipo, String titulo) {
		JOptionPane optionPane = new JOptionPane(mensaje);
		if(tipo.equals("Info")) { //Elegimos distintos tipos de error
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			if(tipo.equals("Error")) {
				optionPane.setMessageType(JOptionPane.ERROR_MESSAGE);
			}
		}
		JDialog dialog = optionPane.createDialog(titulo);
		dialog.setAlwaysOnTop(true);
		dialog.setVisible(true);
		
	}
}
