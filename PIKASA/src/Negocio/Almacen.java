package Negocio;

import java.sql.DriverManager;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Datos.*;
import IU.Interfaz;

public class Almacen {
	
	
	LinkedList<Producto> productosCreados = new LinkedList<Producto>();
	
	LinkedList<Container> containers = new LinkedList<Container>();
	
	
	
	public static void main(String[] args) 
	{
		try {Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection conector = DriverManager.getConnection("jdbc:mysql://localhost:3306/pikasa","root","");
		
		if(conector!=null) {
			System.out.println("Se pudo conectar ");
			//JOptionPane.showMessageDialog(null, "ALOHAAAAA");
		}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Hubo un error al conectar la base de datos");
		}
		// TODO Auto-generated method stub
		Interfaz i1 = new Interfaz();
		i1.Login();
		
		
		
	}
	
	
	public void addProductos(Producto producto) 
	{
		Producto a = new Producto();
		a.crearProducto(producto);
						
	}
	
	public void addContainer(Container container) 
	{
		containers.add(container);
	}

	
	public int contarProductos() {
		return productosCreados.size();
	}

	@Override
	public String toString() {
		return "Lista productos:\n" + productosCreados;
	}
	

	
	public Container buscadorContainer (String nombreContainer) {
		Container conts=new Container();
		int total=containers.size();
		
		while (total!=-1) 
		{
			if(!containers.get(total).getNombre().equalsIgnoreCase(nombreContainer)) {
				if(total == 0) {
					System.out.print("producto no encontrado ");
				 
				 }
				total--;
				
			}else {
				
				conts=containers.get(total);
				total=-1;
			}
			
		
		}
		
		return conts;
		
	}
	
	public Producto buscadorProductos (String nombreProducto) {
		Producto product=new Producto();
		int total=containers.size();
		
		while (total!= -1) 
		{
			if(!productosCreados.get(total).getNombre().equalsIgnoreCase(nombreProducto)) {
				if(total == 0) {
					System.out.print("producto no encontrado ");
				 }
				total--;
				
			}else {
				
				product=productosCreados.get(total);
				total=-1;
			}
			
			}
		
		return product;
		
	}
	
	
	public void borrarProducto(String nombreProducto) {
		Producto product=new Producto();
		int total=containers.size();
		while (total != -1) 
		{
			if(!productosCreados.get(total).getNombre().equalsIgnoreCase(nombreProducto)) {
				if(total == 0) {
					System.out.print("producto no encontrado ");
				 }
				total--;
				
			}else {
				productosCreados.remove(total);
				System.out.print("producto Eliminado ");
				total= -1;
			}

			
			}
		
		
		
	}
} 