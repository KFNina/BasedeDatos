package Modelo;

import DAO.Dao;

public class App {

	public static void main(String[] args) {
		Dao dao = new Dao();
		
		dao.eliminarConFiltro("3");	
		
	}

}
