package es.studium.adtema3practicahibernate;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HotelManager 
{
	private static SessionFactory getSessionFactory() 
	{
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Clientes.class).configure().buildSessionFactory();
		return sessionFactory;
	}
	
	public static void createClientes(Clientes u) 
	{
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(u);
		transObj.commit();
		sessionObj.close();
		System.out.println("Cliente " + u.getIdCliente() + " insertado correctamente");
	}
	
	public static void readClientes (Integer IdCliente) 
	{

		String c = "FROM Clientes WHERE idCliente =" + IdCliente;
		System.out.println(IdCliente);
		Session sessionObj = getSessionFactory().openSession();
		List<Clientes> results = sessionObj.createQuery(c).list();

		Iterator<Clientes> clientesiterator = results.iterator();
		while (clientesiterator.hasNext()) {
			Clientes cl4 = clientesiterator.next();
			System.out.println(cl4.getIdCliente() + " - " +
					cl4.getNombreCliente() + " - " + cl4.getApellidosCliente() + " - " 
					+ cl4.getEmailCliente() + " - " + cl4.getDniCliente() + " - " + cl4.getClaveCliente());
		}
		sessionObj.close();
	}
	public static void updateCliente(Integer Id, String apellido) 
	{
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes cl3 = (Clientes) sessionObj.load(Clientes.class, Id);
		/* Modificar apellido */
		cl3.setApellidosCliente(apellido);
		transObj.commit();
		sessionObj.close();
		System.out.println("Actualizado correctamente");
	}
	public static void deleteClientes(Integer Id) 
	{
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes clienteBD = (Clientes) sessionObj.load(Clientes.class, Id);
		sessionObj.delete(clienteBD);
		transObj.commit();
		sessionObj.close();
		System.out.println("Eliminado correctamente");
	}

}