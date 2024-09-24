package DAO;

import Models.StockCard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StockCardDAO {
	private Connection connection;
	
	public StockCardDAO(Connection connection) {
        this.connection = connection;
    }
	
	public void saveStockCard(StockCard stockCard) throws SQLException {
        String query = "INSERT INTO stock (stockCode, stockName, stockType, Unit, Barcode, kdvType, Description, Date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, stockCard.getStockCode());
        stmt.setString(2, stockCard.getStockName());
        stmt.setInt(3, stockCard.getStockType());
        stmt.setString(4, stockCard.getUnit());
        stmt.setString(5, stockCard.getBarcode());
        stmt.setDouble(6, stockCard.getKdvType());
        stmt.setString(7, stockCard.getDescription());
        stmt.setDate(8, new java.sql.Date(stockCard.getDate().getTime()));
        stmt.executeUpdate();
    }
	
	public List<StockCard> getStockCards() throws SQLException{
		List<StockCard> stockCards = new ArrayList<>();
		String query = "SELECT * FROM stock";
		Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery(query);
        
        while (resultSet.next()) {
            StockCard stockCard = new StockCard();
            stockCard.setId(resultSet.getInt("id"));
            stockCard.setStockCode(resultSet.getString("stockCode"));
            stockCard.setStockName(resultSet.getString("stockName"));
            stockCard.setStockType(resultSet.getInt("stockType"));
            stockCard.setUnit(resultSet.getString("Unit"));
            stockCard.setBarcode(resultSet.getString("Barcode"));
            stockCard.setKdvType(resultSet.getDouble("kdvType"));
            stockCard.setDescription(resultSet.getString("Description"));
            stockCard.setDate(resultSet.getDate("Date"));
            stockCards.add(stockCard);
        }

        return stockCards;
	}
	
	public boolean deleteStockCard(String stockCode) throws SQLException {
		String query = "DELETE FROM stock WHERE stockCode = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, stockCode);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
		}
	}
	
	public StockCard searchStockCard(String stockCode) throws SQLException{
		String query = "SELECT * FROM stock WHERE stockCode = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, stockCode);
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if(resultSet.next()) {
        	StockCard stockCard = new StockCard();
            stockCard.setStockCode(resultSet.getString("stockCode"));
            stockCard.setStockName(resultSet.getString("stockName"));
            stockCard.setStockType(resultSet.getInt("stockType"));
            stockCard.setUnit(resultSet.getString("Unit"));
            stockCard.setBarcode(resultSet.getString("Barcode"));
            stockCard.setKdvType(resultSet.getInt("kdvType"));
            stockCard.setDescription(resultSet.getString("Description"));
            stockCard.setDate(resultSet.getDate("Date"));
            return stockCard;
        }
        return null;
	}
	
	public void updateStockCard(StockCard stockCard) throws SQLException {
	    String query = "UPDATE stock SET stockName = ?, stockType = ?, Unit = ?, Barcode = ?, kdvType = ?, Description = ? WHERE stockCode = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString(1, stockCard.getStockName());
	    preparedStatement.setInt(2, stockCard.getStockType());
	    preparedStatement.setString(3, stockCard.getUnit());
	    preparedStatement.setString(4, stockCard.getBarcode());
	    preparedStatement.setDouble(5, stockCard.getKdvType());
	    preparedStatement.setString(6, stockCard.getDescription());
	    preparedStatement.setString(7, stockCard.getStockCode());
	    preparedStatement.executeUpdate();
	}
}
