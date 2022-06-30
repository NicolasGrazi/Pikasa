package Datos;
import java.sql.*;
public class Persona {
	private String nombre;
	private String apellido;
	private int dni;
	
Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
public boolean crearPersona(Persona usuario) {
		
		String sql ="INSERT INTO `persona`(`dni`, `nombre`, `apellido`) VALUES (?,?,?)"; 
	
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setInt(1,usuario.getDni());
			stmt.setString(2,usuario.getNombre());
			stmt.setString(3,usuario.getApellido());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
		
			
		
	}


	public boolean eliminarPersona(Persona usuario) {
		
		String sql ="DELETE FROM `persona` WHERE dni='?'"; 
	
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setInt(1,usuario.getDni());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
	}

	
     public boolean modificarPersona(Persona usuario) {
		
		String sql ="UPDATE container SET dni='?', nombre='?', apellido='?' WHERE dni='?' "; 
	
		try {
			stmt = conexion.prepareStatement(sql);
			
			stmt.setInt(1,usuario.getDni());
			stmt.setString(2,usuario.getNombre());
			stmt.setString(3,usuario.getApellido());
			stmt.setInt(4,usuario.getDni());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
		
			
		
	}

     public boolean buscarPersona(Persona usuario) {
    	 
    	 
    	String sql ="SELECT * FROM `persona` WHERE dni = '?' "; 
 		
 		String[] datos = new String[3];
 		
 		
 		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setInt(1,usuario.getDni());
			
			ResultSet result =  stmt.executeQuery();
			
			while(result.next()) {
				datos[0] = result.getString(1);
				datos[1] = result.getString(2);
				datos[2] = result.getString(3);
				
			}
			System.out.println("dni: " + datos[0] + " nombre: " + datos[1]+ " apellido: "+ datos[2] );
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
    	 
    	 
    	 
     }

	
}
