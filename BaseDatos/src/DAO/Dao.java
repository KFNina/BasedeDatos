package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Clases.Persona;

public class Dao {
	String user = "root";

	String psw = "admin";

	String ruta = "jdbc:mysql://localhost:3306/basedegatos";
		
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
	
	public void agregarPersonaPorParametro(Persona p) {
		Connection conexion = null;
		
		String sql =  "INSERT INTO `basedegatos`.`persona`(`idPersona`,`DNI`,`Nombre`)VALUES(?,?,?);";
		
		try {
			conexion = conectar();
			PreparedStatement stat = conexion.prepareStatement(sql);
			stat.setInt(1, p.getId());
			stat.setString(2, p.getNombre());//En este get no empieza con 0 ya q este es distino y empieza por 1
			stat.setString(3, p.getDni());//
			int filas = stat.executeUpdate();
			
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
	
	
	
	public void eliminarConFiltro(String dni) {
		Connection conexion = null;
		
		try {
			conexion = conectar();
			Statement stat = conexion.createStatement();
			sqlDelFiltro =  "DELETE FROM `basedegatos`.`persona`WHERE dni = " + dni;
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
	
	public ArrayList<String> consultas() {
		Connection conexion = null;
		String sql = "SELECT nombre FROM Persona";
		ArrayList<String> solucion = new ArrayList<>();
		
		try {
			conexion = conectar();
			Statement stat = conexion.createStatement();
			ResultSet sr = stat.executeQuery(sql);
			while(sr.next()) {
				String nombre = sr.getString("nombre");
				
				solucion.add(nombre);
			}
			
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
		
		return solucion;
		
	}
}
