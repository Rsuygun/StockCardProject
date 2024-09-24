package Models;

import java.util.Date;

public class StockCard {
	private int id;
	private String stockCode;
	private String stockName;
	private int stockType;
	private String Unit;
	private String Barcode;
	private double kdvType;
	private String Description;
	private Date Date;
	
	public StockCard() {
		
	}
	
	public StockCard(String stockCode, String stockName, Integer stockType, String Unit, String Barcode, Double kdvType, String Description, Date Date) {
		this.stockCode = stockCode;
        this.stockName = stockName;
        this.stockType = stockType;
        this.Unit = Unit;
        this.Barcode = Barcode;
        this.kdvType = kdvType;
        this.Description = Description;
        this.Date = Date;

	}
	
	//ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	//StockCode
	public String getStockCode() {
		return stockCode;
	}
	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}
	
	//StockName
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	//StockType
	public Integer getStockType() {
		return stockType;
	}
	public void setStockType(Integer stockType) {
		this.stockType = stockType;
	}
	
	//Unit
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String Unit) {
		this.Unit = Unit;
	}
	
	//Barcode
	public String getBarcode() {
		return Barcode;
	}
	public void setBarcode(String Barcode) {
		this.Barcode = Barcode;
	}
	
	//kdvTpye
	public double getKdvType() {
		return kdvType;
	}
	public void setKdvType(double kdvType) {
		this.kdvType = kdvType;
	}
	
	//Description
	public String getDescription() {
		return Description;
	}
	public void setDescription(String Description) {
		this.Description = Description;
	}
	
	//Date
	public Date getDate() {
		return Date;
	}
	public void setDate(Date Date) {
		this.Date = Date;
	}
}
