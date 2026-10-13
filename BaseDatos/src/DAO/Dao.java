package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	String user = "root";
	String psw = "admin";
	String path = "jdbc:mysql://localhost:3306/primeradatabase";
	
	public Connection conectar() {
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(path, user, psw);
			System.out.println("Se conecto");
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return conexion;
	}
	
	public void agregar() {
		Connection conexion = null;
		
		try {
			conexion = conectar();
			String sql = "INSERT INTO `primeradatabase`.`data`(`idData`,`Nombre_Data`,`DNI_Data`) VALUES(3,'Lautaro','48737246');";
			Statement stat = conexion.createStatement();
			int filas = stat .executeUpdate(sql);
			System.out.println(filas);
			
		}catch() {
			
		}
		
	}
	
}
