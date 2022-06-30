package Datos;
import java.sql.*;
public class Container {
	public int nrocontainer;
	public String nombre;
	
Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;
	

	public String getNombre() {
		
		 return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setnroContainer(int nroContainer) {
		this.nrocontainer = nroContainer;
	}
	
	
	public int getnroContainer() {
		return nrocontainer ;
	}

	@Override
	public String toString() {
		return "container [nrocontainer=" + nrocontainer + ", nombre=" + nombre + "]";
	}
	public boolean crearConteiner(Container nuevo) {
		String sql ="INSERT INTO `container`( `nombre`,`nrocontainer`) VALUES (?,?)";
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1,nuevo.getNombre());
			stmt.setInt(2,nuevo.getnroContainer());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error "+ e);
			return false;
		}
		
	}
	
	public boolean modificarConteiner(Container nuevo) {
		String sql ="UPDATE container SET nombre='?', nrocontainer='?',`rol`='?' WHERE nrocontainer='?' ";
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setString(1,nuevo.getNombre());
			stmt.setInt(2,nuevo.getnroContainer());
			stmt.setInt(3,nuevo.getnroContainer());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error "+ e);
			return false;
		}
		
	}
	
	public boolean eliminarConteiner(Container nuevo) {
		
		String sql ="DELETE FROM `container` WHERE nrocontainer='?'"; 
		
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setInt(1,nuevo.getnroContainer());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
		
		
	}
	
	
	public boolean buscarPersona(Container nuevo) {
   	 
   	 
    	String sql ="SELECT * FROM `container` WHERE dni = '?' "; 
 		
 		String[] datos = new String[2];
 		
 		
 		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1,nuevo.getnroContainer());
			
			ResultSet result =  stmt.executeQuery();
			
			while(result.next()) {
				datos[0] = result.getString(1);
				datos[1] = result.getString(2);
				
				
			}
			System.out.println("nrocontainer: " + datos[0] + " nombre: " + datos[1] );
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
    	 
    	 
    	 
     }

}
