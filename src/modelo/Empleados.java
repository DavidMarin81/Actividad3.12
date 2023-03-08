package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLEADO")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Empleados implements Serializable{
	//Clave primaria
	private String dni;
	
	private String nombre;
	
	private String telefono;
	
	protected float porcentaRetencion;
	
	public abstract float calculoNomina();
	
	private Temporales temporal;
	
	//Para revisar en clase
	//Primera opcion
	@OneToOne
	@PrimaryKeyJoinColumn
	//Segunda opcion
	//@JoinColumn(name="DNI_FK", referencedColumnName = "dni")
	public Temporales getTemporal() {
		return temporal;
	}

	public void setTemporal(Temporales temporal) {
		this.temporal = temporal;
	}
	
	private Fijos fijos;
	
	//Para revisar en clase
		//Primera opcion
		@OneToOne
		@PrimaryKeyJoinColumn
		//Segunda opcion
		//@JoinColumn(name="DNI_FK", referencedColumnName = "dni")
	public Fijos getFijos() {
		return fijos;
	}

	public void setFijos(Fijos fijos) {
		this.fijos = fijos;
	}
	

	//Clave foranea
	private String cif;
	
	private static final long serialVersionUID = 1L;
	
	public Empleados() {
	}

	public Empleados(String dni, String nombre, String telefono, float porcentaRetencion, String cif) {
		this.dni = dni;
		this.nombre = nombre;
		this.telefono = telefono;
		this.porcentaRetencion = porcentaRetencion;
		this.cif = cif;
	}

	@Id
	@Column(name="DNI")
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	//@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CIF")
	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	@Override
	public String toString() {
		return "Empleados [dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", porcentaRetencion="
				+ porcentaRetencion + ", cif=" + cif + "]";
	}

}
