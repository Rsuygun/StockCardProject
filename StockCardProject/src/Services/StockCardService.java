package Services;

import DAO.StockCardDAO;
import Models.StockCard;

import java.sql.*;
import java.util.List;

public class StockCardService {
	private StockCardDAO stockCardDAO;
	
	public StockCardService(StockCardDAO stockCardDAO) {
        this.stockCardDAO = stockCardDAO;
    }
	
	public List<StockCard> getAllStockCards() throws SQLException {
        return stockCardDAO.getStockCards();
    }
	
	public void saveStockCard(StockCard stockCard) throws SQLException {
		StockCard existingStockCard = stockCardDAO.searchStockCard(stockCard.getStockCode());
		
		if(existingStockCard != null) {
			stockCardDAO.updateStockCard(stockCard);
		} else {
			stockCardDAO.saveStockCard(stockCard);
		}
	}
	
	public boolean deleteStockCard(String stockCode) throws SQLException{
		return stockCardDAO.deleteStockCard(stockCode);
	}
	
	public StockCard searchStockCard(String stockCode) throws SQLException{
		 return stockCardDAO.searchStockCard(stockCode);

	}
}
