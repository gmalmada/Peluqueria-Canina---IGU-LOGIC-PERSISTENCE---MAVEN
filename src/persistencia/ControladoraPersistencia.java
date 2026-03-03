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

	public Mascota traerMascota(int numCli) {
		
		return mascoJpa.findMascota(numCli);
	}

	public void modificarMascota(Mascota masco) {
		
		try {
			mascoJpa.edit(masco);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Duenio traerDuenio(int idDuenio) {
		
		return duenioJpa.findDuenio(idDuenio);
	}

	public void modificarDuenio(Duenio dueno) {
		try {
			duenioJpa.edit(dueno);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
