package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Controladora;
import logica.Mascota;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class VerDatos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaMascotas;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	Controladora control = new Controladora();
	
	public VerDatos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cargarTabla();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1085, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1069, 653);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblVisualizacinDeDatos = new JLabel("Visualización de datos");
		lblVisualizacinDeDatos.setBounds(387, 0, 260, 56);
		lblVisualizacinDeDatos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblVisualizacinDeDatos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(44, 67, 773, 577);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 52, 590, 486);
		panel_1.add(scrollPane);
		
		tablaMascotas = new JTable();
		scrollPane.setViewportView(tablaMascotas);
		
		JLabel lblDatosDeMascotas = new JLabel("Datos de mascotas");
		lblDatosDeMascotas.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDatosDeMascotas.setBounds(0, 21, 209, 31);
		panel_1.add(lblDatosDeMascotas);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(600, 155, 135, 72);
		panel_1.add(btnEditar);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tablaMascotas.getRowCount() > 0) {//Controlar que la lista no este vacia (Si es mayor a 0 es porque hay filas y no esta vacia)
					if(tablaMascotas.getSelectedRow() != -1) { //Controlar si eligio una fila (-1 significa nada seleccionado)
						int numCliente = Integer.parseInt(String.valueOf(tablaMascotas.getValueAt(tablaMascotas.getSelectedRow(), 0))); //Explicacion abajo
						//Traer y asignar en num de cliente el valor de la tabla mascotas que este en la columna 0 de la fila seleccionada 
						
						//Borrar mascota
						control.borrarMascota(numCliente);
						
						//Aviso de borrado exitoso (Uso metodo mostrarMensaje creado abajo)
						mostrarMensaje("Mascota eliminada exitosamente.", "Info", "Borrado de mascota");
						cargarTabla(); //Mostrar la tabla actualizada
					}else {
						mostrarMensaje("No seleccionó ninguna mascota", "Error", "Error al eliminar");
					}
				}else {
					mostrarMensaje("No hay nada en la tabla", "Error", "Error al eliminar");
				}
			}
		});
		
		
		
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEliminar.setBounds(600, 49, 135, 72);
		panel_1.add(btnEliminar);

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

	protected void cargarTabla() {
		//Definir modelo que tendrá la tabla
		DefaultTableModel modeloTabla = new DefaultTableModel() { 
			@Override //Importante en metodos (Como isCellEditable) que son metodos ya existentes
			public boolean isCellEditable(int row, int column) {//Hacer que las filas y columnas no sean editables. Es un metodo
				return false;
			}
		};
		
		//Establecemos nombres de las columnas
		String titulos[] = {"Num", "Nombre", "Color", "Raza", "Alérgico", "At. Esp.", "Duenio", "Cel"};
		modeloTabla.setColumnIdentifiers(titulos);//Colocar en la tabla los identificadores armados aqui arriba
		
		//Carga de datos desde BDD
		List<Mascota> listaMascotas = control.traerMascotas();
		
		//Recorrer la lista y mostrar los elementos en la tabla. Preguntando con un if
		if(listaMascotas != null) {
			for(Mascota masco : listaMascotas) {
				Object[] objeto = {masco.getNumCliente(), masco.getNombreMascota(), masco.getColor(), masco.getRaza(),
						masco.getAlergico(), masco.getAtEsp(), masco.getUnDuenio().getNombre(), masco.getUnDuenio().getCelDuenio()};
				//El vector debe ser de tipo Object porque contiene String y numeros, distintos tipos de datos mezclados
				modeloTabla.addRow(objeto);
			}
			
			//Asignar todo a la tabla de la interfaz
			tablaMascotas.setModel(modeloTabla);
		}
		
	}
}
