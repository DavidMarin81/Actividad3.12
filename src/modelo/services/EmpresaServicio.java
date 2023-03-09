package modelo.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Empleados;
import modelo.Empresa;
import modelo.Fijos;
import util.SessionFactoryUtil;

public class EmpresaServicio implements IEmpresaServicio{

	@Override
	public void crearEmpresa() {
		Transaction tx = null;
		SessionFactory factoria = SessionFactoryUtil.getSessionFactory();
		
		try(Session sesion = factoria.openSession();){
			tx = sesion.beginTransaction();
			Empresa empresa = new Empresa();
			empresa.setCif("b12345678");
			empresa.setNombre("Empresa 01");
			empresa.setDireccion("Calle de la Empresa 01");
			empresa.setTelefono("678123123");
			
			sesion.save(empresa);
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
	public List<Empleados> mostrarEmpleados() {
		SessionFactory factoria = SessionFactoryUtil.getSessionFactory();
		Session sesion = factoria.openSession();
		
		@SuppressWarnings("unchecked")
		List<Empleados> empleados = sesion.createQuery("select d from Empleados d").list();
		
		for (Empleados emps : empleados) {
			System.out.println(emps);
		}
		
		sesion.close();
		
		return empleados;
		
		
	}

}
