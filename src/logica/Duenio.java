package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Duenio {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int idDuenio;
	private String nombre;
	private String celDuenio;
	
	public Duenio() {
		super();
	}

	public Duenio(int idDuenio, String nombre, String celDuenio) {
		super();
		this.idDuenio = idDuenio;
		this.nombre = nombre;
		this.celDuenio = celDuenio;
	}

	public int getIdDuenio() {
		return idDuenio;
	}

	public void setIdDuenio(int idDuenio) {
		this.idDuenio = idDuenio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelDuenio() {
		return celDuenio;
	}

	public void setCelDuenio(String celDuenio) {
		this.celDuenio = celDuenio;
	}
	
}
