package Interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Clases.Persona;
import DAO.Dao;

import DAO.Dao;

public class PanelActualizar extends JPanel {
	
	Dao c = new Dao();
	private JTable table = new JTable();
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelActualizar(JFrame marco) {
		setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(161, 5, 175, 236);
		add(scrollBar);
		Object[] columnas = new Object[]{"nombre","locura"};
		DefaultTableModel modelo = new DefaultTableModel(columnas,0);
		
		table.setModel(modelo);
		for(String p : c.consultas()) {
			modelo.addRow(new Object[] {});
		}
	}

}
