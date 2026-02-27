package logica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int numCliente;
	private String nombreMascota;
	private String raza;
	private String color;
	private String alergico;
	private String atEsp;
	private String Observaciones;
	@OneToOne
	private Duenio unDuenio;

	public Mascota() {
		super();
	}

	public Mascota(int numCliente, String nombreMascota, String raza, String color, String alergico, String atEsp,
			String observaciones, Duenio unDuenio) {
		super();
		this.numCliente = numCliente;
		this.nombreMascota = nombreMascota;
		this.raza = raza;
		this.color = color;
		this.alergico = alergico;
		this.atEsp = atEsp;
		Observaciones = observaciones;
		this.unDuenio = unDuenio;
	}

	public int getNumCliente() {
		return numCliente;
	}

	public void setNumCliente(int numCliente) {
		this.numCliente = numCliente;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAlergico() {
		return alergico;
	}

	public void setAlergico(String alergico) {
		this.alergico = alergico;
	}

	public String getAtEsp() {
		return atEsp;
	}

	public void setAtEsp(String atEsp) {
		this.atEsp = atEsp;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public Duenio getUnDuenio() {
		return unDuenio;
	}

	public void setUnDuenio(Duenio unDuenio) {
		this.unDuenio = unDuenio;
	}

}
