package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TEMPORALES")
public class Temporales extends Empleados implements Serializable {

	private static final long serialVersionUID = 1L;

	//Clave primaria y foranea (empleado dni)
	private String dni;
	private LocalDate fechaInicio, fechaFin;
	private float pagoDia, suplemento;
	
	long diff = ChronoUnit.DAYS.between(fechaFin, fechaInicio);
	
	float sueldo = pagoDia*(diff)-pagoDia*(diff)*porcentaRetencion+suplemento;
	
	@Override
	public float calculoNomina() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Temporales() {
		
	}

	public Temporales(String dni, LocalDate fechaInicio, LocalDate fechaFin, float pagoDia, float suplemento, float sueldo) {
		super();
		this.dni = dni;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.pagoDia = pagoDia;
		this.suplemento = suplemento;
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

	//@Temporal(TemporalType.DATE)
	@Column(name="FECHAINICIO")
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	//@Temporal(TemporalType.DATE)
	@Column(name="FECHAFIN")
	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name="PAGODIA")
	public float getPagoDia() {
		return pagoDia;
	}

	public void setPagoDia(float pagoDia) {
		this.pagoDia = pagoDia;
	}

	@Column(name="SUPLEMENTO")
	public float getSuplemento() {
		return suplemento;
	}

	public void setSuplemento(float suplemento) {
		this.suplemento = suplemento;
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
		return "Temporales [dni=" + dni + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", pagoDia="
				+ pagoDia + ", suplemento=" + suplemento + ", sueldo=" + sueldo + "]";
	}
	
}
