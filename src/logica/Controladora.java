package logica;


import persistencia.ControladoraPersistencia;

public class Controladora { //Se encarga de llamar a la persistencia, que conecta con la BDD
	
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

	public java.util.List<Mascota> traerMascotas() {
		
		return controlPersis.traerMascotas();
	}

	public void borrarMascota(int numCliente) {
		
		controlPersis.borrarMascota(numCliente);
	}

	public Mascota traerMascota(int numCli) {
		return controlPersis.traerMascota(numCli);
	}

	public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones,
			String alergico, String atEsp, String nomDuenio, String celDuenio) {
		
		//Paso a la mascota actual los nuevos datos modificados
		masco.setNombreMascota(nombreMasco);
		masco.setRaza(raza);
		masco.setColor(color);
		masco.setObservaciones(observaciones);
		masco.setAlergico(alergico);
		masco.setAtEsp(atEsp);
		
		//Modifico la mascota
		controlPersis.modificarMascota(masco);
		
		//Seteo valores del duenio
		Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getIdDuenio());
		dueno.setCelDuenio(celDuenio);
		dueno.setNombre(nomDuenio);
		
		//Llamar a modificar duenio
		this.modificarDuenio(dueno);
		
		
	}

	private void modificarDuenio(Duenio dueno) {
		controlPersis.modificarDuenio(dueno);
		
	}

	private Duenio buscarDuenio(int idDuenio) {
		
		return controlPersis.traerDuenio(idDuenio);
	}

}
