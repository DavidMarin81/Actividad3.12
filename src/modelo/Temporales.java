package modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="TEMPORALES", catalog = "empresa_anotaciones")
public class Temporales extends Empleados implements Serializable {

	private static final long serialVersionUID = 1L;

	//Clave primaria y foranea (empleado dni)
	private String dni;
	private Empleados empleados;
	private Date fechaInicio, fechaFin;
	private float pagoDia, suplemento;
	
	//long diff = ChronoUnit.DAYS.between(fechaFin, fechaInicio);
	
	//float sueldo = pagoDia*(diff)-pagoDia*(diff)*porcentaRetencion+suplemento;
	float sueldo;
	
	@Override
	public float calculoNomina() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Temporales() {
	}
	
	public Temporales(Empleados empleados) {
		this.empleados = empleados;
	}

	public Temporales(Empleados empleados, Date fechaInicio, Date fechaFin, float pagoDia, float suplemento, float sueldo) {
		this.empleados = empleados;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.pagoDia = pagoDia;
		this.suplemento = suplemento;
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

	@Temporal(TemporalType.DATE)
	@Column(name="FECHAINICIO")
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="FECHAFIN")
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
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
