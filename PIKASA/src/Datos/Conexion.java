package Datos;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

	Connection con ;
	
	public Connection conectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pikasa","root","");
			JOptionPane.showMessageDialog(null, "se conecto");
		} catch (Exception e) {
	
			JOptionPane.showMessageDialog(null, "error al conectarse");
		}
		return con; 	
	}
}