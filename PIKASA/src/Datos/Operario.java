package Datos;
import java.sql.*;
public class Operario extends Persona{

	private int nro;
	private String contraseña;

Conexion con = new Conexion();
	
	Connection conexion = con.conectar();
	
	PreparedStatement stmt;

	public int getNro() {
		return nro;
	}
	public String getcontraseña() {
		return contraseña;
	}
	
	public void setNro(int nro) {
		this.nro = nro;
	}
	
	public void setcontraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public boolean sesion (Operario control) {
		String sql ="SELECT * FROM `operario` WHERE contraseña = '?' and usuario = '?'"; 
		try {
			stmt = conexion.prepareStatement(sql);
			stmt.setString(1,control.getcontraseña());
			stmt.setInt(2,control.getDni());
		    stmt.executeUpdate();
			return true;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error ");
			return false;
		}
	}

}
