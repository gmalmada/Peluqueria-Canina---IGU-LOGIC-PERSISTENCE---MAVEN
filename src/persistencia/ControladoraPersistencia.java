package persistencia;

import java.util.List;

import logica.Duenio;
import logica.Mascota;

public class ControladoraPersistencia {
	
	DuenioJpaController duenioJpa = new DuenioJpaController();
	MascotaJpaController mascoJpa = new MascotaJpaController();
	
	public List<Mascota> traerMascotas(){
		return mascoJpa.findMascotaEntities();
	}
	
	public void guardar(Duenio duenio, Mascota masco) { //Aca adentro usamos los metodos del JpaController
		
		duenioJpa.create(duenio); //Crear el Duenio en la BDD
		mascoJpa.create(masco); //Crear la Mascota en la BDD
		
	}

	public void borrarMascota(int numCliente) {
		try {
			mascoJpa.destroy(numCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
