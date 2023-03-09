package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="FIJOS", catalog = "empresa_anotaciones")
public class Fijos extends Empleados implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//Clave primaria y foranea (dni del empleado)
	private String dni;
	private Empleados empleados;
	private int salarioBase, trienios;
	private float sueldo = (salarioBase+trienios)-(salarioBase+trienios)*porcentaRetencion;
	
	@Override
	public float calculoNomina() {
		return sueldo;
	}
	
	public Fijos() {
	}
	
	public Fijos(Empleados empleados) {
		this.empleados = empleados;
	}

	public Fijos(Empleados empleados, String dni, int salarioBase, int trienios, float sueldo) {
		this.empleados = empleados;
		this.salarioBase = salarioBase;
		this.trienios = trienios;
		this.sueldo = sueldo;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "empleado"))
	@Id
	@GeneratedValue(generator = "generator")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Empleados getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
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
