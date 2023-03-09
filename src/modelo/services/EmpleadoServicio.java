package modelo.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Empleados;
import modelo.Fijos;
import util.SessionFactoryUtil;

public class EmpleadoServicio implements IEmpleadoServicio {

	@Override
	public void crearEmpleado() {
		Transaction tx = null;
		SessionFactory factoria = SessionFactoryUtil.getSessionFactory();
		
		try(Session sesion = factoria.openSession();){
			tx = sesion.beginTransaction();
			Empleados empleado = new Fijos();
			
			empleado.setDni("36123123A");
			empleado.setNombre("Empleado Uno");
			empleado.setPorcentaRetencion(15);
			empleado.setTelefono("986789789");
			
			sesion.save(empleado);
			tx.commit();
			
		} catch(Exception ex) {
			System.out.println("Se ha producido una excepcion");
			if(tx != null) {
				tx.rollback();
			}
			throw ex;
		}
		
	}

	@Override
	public void eliminarEmpleado(String dni) {
		Transaction tx = null;
		SessionFactory factoria = SessionFactoryUtil.getSessionFactory();
		
		try(Session sesion = factoria.openSession();){
			tx = sesion.beginTransaction();
			
			Empleados empleado = sesion.load(Empleados.class, dni);
			sesion.delete(empleado);
			tx.commit();
			
		} catch(Exception ex) {
			System.out.println("Se ha producido una excepcion");
			if(tx != null) {
				tx.rollback();
			}
			throw ex;
		}
		
	}

}
