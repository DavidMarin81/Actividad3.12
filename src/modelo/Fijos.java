package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="FIJOS")
public class Fijos extends Empleados implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Clave primaria y foranea (dni del empleado)
	private String dni;
	private int salarioBase, trienios;
	private float sueldo = (salarioBase+trienios)-(salarioBase+trienios)*porcentaRetencion;
	
	@Override
	public float calculoNomina() {
		return sueldo;
	}
	
	public Fijos() {
		
	}

	public Fijos(String dni, int salarioBase, int trienios, float sueldo) {
		super();
		this.dni = dni;
		this.salarioBase = salarioBase;
		this.trienios = trienios;
		this.sueldo = sueldo;
	}

	@Id
	@Column(name="DNI")
	//Revisar en clase
	//Primera opcion -> sin poner nada
	//Segunda opcion
	@OneToOne(mappedBy = "dni")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name="SALARIOBASE")
	public int getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(int salarioBase) {
		this.salarioBase = salarioBase;
	}

	@Column(name="TRIENIOS")
	public int getTrienios() {
		return trienios;
	}

	public void setTrienios(int trienios) {
		this.trienios = trienios;
	}

	@Column(name="SUELDO")
	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return "Fijos [dni=" + dni + ", salarioBase=" + salarioBase + ", trienios=" + trienios + ", sueldo=" + sueldo
				+ "]";
	}
	
}
