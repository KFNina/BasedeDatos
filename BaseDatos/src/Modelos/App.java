package Modelos;

import java.sql.Connection;

import DAO.Dao;

public class App {

	public static void main(String[] args) {
		Connection conex;
		
		Dao dao = new Dao();
		
		conex = dao.conectar();
		
		
	}

}
