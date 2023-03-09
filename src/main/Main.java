package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Empresa;
import util.SessionFactoryUtil;

public class Main {
	
	private static SessionFactory sessionFactory = null;
	private static Session session = null;
	private static Transaction tx = null;

	public static void main(String[] args) {
		comprobarConexion();
		
	
	}
	
	private static void crearEmpresa() {
		System.out.println("Crear Empresa");
		try {
			Empresa empresa = new Empresa();
			empresa.setCif("12345678");
			empresa.setNombre("Empresa 01");
			empresa.setDireccion("Direccion Empresa 01");
			
			try {
				session.save(empresa);
			} catch(Exception ex) {
				System.out.println("No se ha creado la empresa");
			}
			
			System.out.println("Se ha creado la empresa");
		} catch (Exception ex) {
			System.out.println("Se ha producido una excepcion");
		}
		
	}

	public static void comprobarConexion() {
		SessionFactory factoria = SessionFactoryUtil.getSessionFactory();
		try (Session sesion = factoria.openSession();){
			System.out.println("Se ha establecido la conexion");
			
		}catch(Exception ex) {
			System.out.println("Se ha producido una excepcion");
		}
	}

}
