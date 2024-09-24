package Main;

import java.sql.Connection;

import DAO.DatabaseConnection;
import DAO.StockCardDAO;
import Services.StockCardService;
import View.StockCardListGUI;

public class Main {
	public static void main(String[] args) {
		try {			
			Connection connection = DatabaseConnection.getConnection();
			StockCardDAO stockCardDAO = new StockCardDAO(connection);
			
			StockCardService stockCardService = new StockCardService(stockCardDAO);
			new StockCardListGUI(stockCardService);
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}
}
