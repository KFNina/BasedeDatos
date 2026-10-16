package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	String user = "root";

	String psw = "admin";

	String ruta = "jdbc:mysql://localhost:3306/BaseDeGatos";
	
	String sqlUp = "UPDATE `basedegatos`.`persona`SET`DNI` = '' ,`Nombre` = '' WHERE `idPersona` = ";
	
	String sqlDel = "DELETE FROM `basedegatos`.`persona`";
	
	String sqlDelFiltro = "DELETE FROM `basedegatos`.`persona`WHERE IdPersonas = ";
	
	String sqlIn = "INSERT INTO `basedegatos`.`persona`(`idPersona`,`DNI`,`Nombre`)VALUES(3,'48737246','Lautaro');";
	
	public Connection conectar() {
		
		Connection conexion = null;
		
		try {
			conexion = DriverManager.getConnection(ruta, user, psw);
			System.out.println("Se conecto");
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
		return conexion;
	}
	
	public void agregarUnPersonaje() {
		Connection conexion = null;
		
		try {
			conexion = conectar();
			Statement stat = conexion.createStatement();
			int filas = stat .executeUpdate(sqlIn);
			System.out.println(filas);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}
	
	public void eliminarConFiltro(String id) {
		Connection conexion = null;
		
		try {
			conexion = conectar();
			Statement stat = conexion.createStatement();
			sqlDelFiltro =  "DELETE FROM `basedegatos`.`persona`WHERE IdPersona = " + id;
			int filas = stat .executeUpdate(sqlDelFiltro);
			System.out.println(filas);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conexion.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void eliminarSinFiltro() {
		Connection conexion = null;
		
		try {
			conexion = conectar();
			Statement stat = conexion.createStatement();
			int filas = stat .executeUpdate(sqlDel);
			System.out.println(filas);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				conexion.close();
			}catch(SQLException e){
				e.printStackTrace();
			}	
		}
	}
	
	public void actualizar() {
		Connection conexion = null;
		
		try {
			conexion = conectar();
			Statement stat = conexion.createStatement();
			int filas = stat .executeUpdate(sqlDel);
			System.out.println(filas);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
	}
}
