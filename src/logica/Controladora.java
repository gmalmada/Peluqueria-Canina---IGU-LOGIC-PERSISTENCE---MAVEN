package logica;

import persistencia.ControladoraPersistencia;

public class Controladora {
	
	ControladoraPersistencia controlPersis = new ControladoraPersistencia();

	public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico,
			String atEsp, String nomDuenio, String celDuenio) {
		
		//Creamos Duenio y asignamos sus valores
		Duenio duenio = new Duenio();
		duenio.setNombre(nomDuenio);
		duenio.setCelDuenio(celDuenio);
		
		//Creamos Mascota y asignamos sus valores
		Mascota masco = new Mascota();
		masco.setNombreMascota(nombreMasco);
		masco.setRaza(raza);
		masco.setColor(color);
		masco.setAlergico(alergico);
		masco.setAtEsp(atEsp);
		masco.setObservaciones(observaciones);
		masco.setUnDuenio(duenio);
		
		controlPersis.guardar(duenio, masco);
	}

	
	
	
	
}
