package es.studium.adtema3practicahibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal 
{
	static String nombre;
	static String apellidos;
	static String email;
	static String dni;
	static String claveCliente;


	//VARIABLE 
	static Integer leerId;
	static Integer eliminaCliente;


	public static void main(String[] args) throws IOException 
	{

		try 
		
		{		
			// CREAR USUARIO
			
			System.out.println( "Inserte los siguientes datos para crear un usuario");
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			System.out.println("Nombre: ");
			nombre = br.readLine();
			System.out.println("Apellidos: ");
			apellidos = br.readLine();
			System.out.println("Email: ");
			email = br.readLine();
			System.out.println("DNI: ");
			dni = br.readLine();
			System.out.println("Clave del cliente: ");
			claveCliente = br.readLine(); 
			Clientes cl1 = new Clientes (nombre, apellidos, email, dni, claveCliente);
			HotelManager.createClientes(cl1);

			
			// LEER USUARIO
			System.out.println( "Ahora vamos a leer los datos de un cliente");
			System.out.println( "Escribe el ID del cliente: ");
			int leeCliente;
			leeCliente = Integer.parseInt(br.readLine());
			HotelManager.readClientes(leeCliente);

			// LEER USUARIO PARA CAMBIAR APELLIDO
			
			System.out.println( "Vamos a leer la información de un usuario según su ID y a cambiar su apellido");
			System.out.println("Inserte el ID del usuario:");
			int leeClienteDos;
			leeClienteDos = Integer.parseInt(br.readLine());
			HotelManager.readClientes(leeClienteDos);

			// CAMBIAR EL APELLIDO 
			
			System.out.println("Inserte el nuevo apellido");
			String apellidoDos;
			apellidoDos = br.readLine();
			HotelManager.updateCliente(leeClienteDos, apellidoDos);

			
			// ELIMINAR USUARIO
			
			System.out.println("Vamos a eliminar un usuario según su ID ");
			System.out.println("Escribe el ID del usuario a eliminar: ");
			int idAEliminar;
			idAEliminar = Integer.parseInt(br.readLine());
			HotelManager.deleteClientes(idAEliminar);
		}
		catch (NumberFormatException n) 
		{
			System.out.println("Error en los datos");
		}
	}
}

