package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADO", catalog = "empresa_anotaciones")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Empleados implements Serializable{
	//Clave primaria
	private String dni;
	private Empresa empresa;
	private String nombre;
	private String telefono;
	protected float porcentaRetencion;
	private Fijos fijos;
	private Temporales temporales;
	
	public abstract float calculoNomina();
	
	private static final long serialVersionUID = 1L;
	
	public Empleados() {
	}
	
	public Empleados(String dni) {
		this.dni = dni;
	}

	public Empleados(String dni, String nombre, String telefono, float porcentaRetencion) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.porcentaRetencion = porcentaRetencion;
	}

	@Id
	@Column(name="DNI", unique = true, nullable = false)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CIF")
	public Empresa getEmpresa() {
		return this.empresa;
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name="NOMBRE")
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name="TELEFONO")
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name="PORCENTARETENCION")
	public float getPorcentaRetencion() {
		return porcentaRetencion;
	}

	public void setPorcentaRetencion(float porcentaRetencion) {
		this.porcentaRetencion = porcentaRetencion;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "empleados")
	public Fijos getFijos() {
		return fijos;
	}

	public void setFijos(Fijos fijos) {
		this.fijos = fijos;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "empleados")
	public Temporales getTemporales() {
		return temporales;
	}

	public void setTemporales(Temporales temporales) {
		this.temporales = temporales;
	}

	@Override
	public String toString() {
		return "Empleados [dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", porcentaRetencion="
				+ porcentaRetencion + "]";
	}

}
