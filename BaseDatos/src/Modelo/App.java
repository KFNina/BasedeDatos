package Modelo;

import Clases.Persona;
import DAO.Dao;

public class App {

	public static void main(String[] args) {
		Dao dao = new Dao();
		
		
		for(String a: dao.consultas()) {
			System.out.println(a);
		}
		
	}
	

}
