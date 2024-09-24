package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Models.StockCard;
import Services.StockCardService;
import DAO.*;
import java.awt.Color;
import java.util.Date;

public class StockCardGUI extends JFrame{

	private JFrame frame;
	private JTextField textStockCode;
	private JLabel lblStockName;
	private JTextField textStockName;
	private JLabel lblStockType;
	private JLabel lblBarcode;
	private JLabel lblKdvType;
	private JLabel lblDesc;
	private JLabel lblDate;
	private JTextField textBarcode;
	private JComboBox<Integer> comboBoxStockType;
    private JComboBox<String> comboBoxUnit;
    private JComboBox<Double> comboBoxKdvType;
    private JTextArea textAreaDesc;
	private JFormattedTextField formattedTextFieldDate;
	
	
	private StockCardService stockCardService;
	private StockCard stockCard;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            Connection connection = DatabaseConnection.getConnection();
            StockCardDAO stockCardDAO = new StockCardDAO(connection);
            StockCardService stockCardService = new StockCardService(stockCardDAO);
            new StockCardGUI(stockCardService);
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public StockCardGUI(StockCardService stockCardService) {
		this(stockCardService, null);
	}
	/**
	 * Create the application.
	 */
	public StockCardGUI(StockCardService stockCardService, StockCard stockCard) {
		this.stockCardService = stockCardService;
	    initialize(); 

	    if (stockCard != null) {
	    	textStockCode.setText(stockCard.getStockCode());
	    	textStockName.setText(stockCard.getStockName());
	    	comboBoxStockType.setSelectedItem(stockCard.getStockType());
	    	comboBoxUnit.setSelectedItem(stockCard.getUnit());
	    	textBarcode.setText(stockCard.getBarcode());
	    	comboBoxKdvType.setSelectedItem(stockCard.getKdvType());
	    	textAreaDesc.setText(stockCard.getDescription());
	    	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	    	if(stockCard.getDate() != null) {
	    		formattedTextFieldDate.setValue(dateFormatter.format(stockCard.getDate()));
	    	}
	    }	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Consolas", Font.PLAIN, 11));
		frame.setBounds(100, 100, 724, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStockCode = new JLabel("Stok Kodu:");
		lblStockCode.setBackground(new Color(202, 202, 202));
		lblStockCode.setFont(new Font("Consolas", Font.BOLD, 24));
		lblStockCode.setBounds(10, 11, 130, 29);
		frame.getContentPane().add(lblStockCode);
		
		textStockCode = new JTextField();
		textStockCode.setFont(new Font("Consolas", Font.PLAIN, 16));
		textStockCode.setBounds(153, 9, 257, 29);
		frame.getContentPane().add(textStockCode);
		textStockCode.setColumns(10);
		
		lblStockName = new JLabel("Stok Adı :");
		lblStockName.setFont(new Font("Consolas", Font.BOLD, 24));
		lblStockName.setBounds(10, 51, 130, 29);
		frame.getContentPane().add(lblStockName);
		
		textStockName = new JTextField();
		textStockName.setFont(new Font("Consolas", Font.PLAIN, 16));
		textStockName.setColumns(10);
		textStockName.setBounds(153, 49, 257, 29);
		frame.getContentPane().add(textStockName);
		
		lblStockType = new JLabel("Stok Tipi:");
		lblStockType.setFont(new Font("Consolas", Font.BOLD, 24));
		lblStockType.setBounds(10, 91, 130, 29);
		frame.getContentPane().add(lblStockType);
		
		comboBoxStockType = new JComboBox<>();
        comboBoxStockType.setFont(new Font("Consolas", Font.PLAIN, 16));
        comboBoxStockType.setBounds(153, 89, 53, 29);
        frame.getContentPane().add(comboBoxStockType);
        comboBoxStockType.addItem(1);
        comboBoxStockType.addItem(2);
        comboBoxStockType.addItem(3);
        comboBoxStockType.addItem(4);
        comboBoxStockType.addItem(5);
		
		JLabel lblUnit = new JLabel("Birimi   :");
		lblUnit.setFont(new Font("Consolas", Font.BOLD, 24));
		lblUnit.setBounds(10, 131, 130, 29);
		frame.getContentPane().add(lblUnit);
		
		comboBoxUnit = new JComboBox<>(); 
		comboBoxUnit.setFont(new Font("Consolas", Font.PLAIN, 16));
		comboBoxUnit.setBounds(153, 131, 53, 29);
		frame.getContentPane().add(comboBoxUnit);
		comboBoxUnit.addItem("12"); 
		comboBoxUnit.addItem("22"); 
		comboBoxUnit.addItem("33");
		
		lblBarcode = new JLabel("Barkodu  :");
		lblBarcode.setFont(new Font("Consolas", Font.BOLD, 24));
		lblBarcode.setBounds(10, 171, 130, 29);
		frame.getContentPane().add(lblBarcode);
		
		lblKdvType = new JLabel("KDV Tipi :");
		lblKdvType.setFont(new Font("Consolas", Font.BOLD, 24));
		lblKdvType.setBounds(10, 211, 130, 29);
		frame.getContentPane().add(lblKdvType);
		
		lblDesc = new JLabel("Açıklama :");
		lblDesc.setFont(new Font("Consolas", Font.BOLD, 24));
		lblDesc.setBounds(10, 251, 130, 29);
		frame.getContentPane().add(lblDesc);
		
		lblDate = new JLabel("Oluşturma Zamanı:");
		lblDate.setFont(new Font("Consolas", Font.BOLD, 24));
		lblDate.setBounds(10, 425, 229, 29);
		frame.getContentPane().add(lblDate);
		
		textBarcode = new JTextField();
		textBarcode.setFont(new Font("Consolas", Font.PLAIN, 16));
		textBarcode.setColumns(10);
		textBarcode.setBounds(153, 169, 257, 29);
		frame.getContentPane().add(textBarcode);
		
		comboBoxKdvType = new JComboBox<>();
        comboBoxKdvType.setFont(new Font("Consolas", Font.PLAIN, 16));
        comboBoxKdvType.setBounds(153, 209, 67, 29);
        frame.getContentPane().add(comboBoxKdvType);
        comboBoxKdvType.addItem(10.5);
        comboBoxKdvType.addItem(15.6);
        comboBoxKdvType.addItem(20.6);
		
		textAreaDesc = new JTextArea();
		textAreaDesc.setFont(new Font("Consolas", Font.PLAIN, 14));
		textAreaDesc.setBounds(153, 249, 366, 165);
		frame.getContentPane().add(textAreaDesc);
		
		formattedTextFieldDate = new JFormattedTextField();
		formattedTextFieldDate.setFont(new Font("Consolas", Font.PLAIN, 16));
		formattedTextFieldDate.setBounds(239, 422, 201, 29);
		frame.getContentPane().add(formattedTextFieldDate);
		
		JButton btnSave = new JButton("KAYDET");
		btnSave.setForeground(new Color(0, 0, 0));
		btnSave.setBackground(new Color(192, 192, 192));
		btnSave.setFont(new Font("Consolas", Font.BOLD, 16));
		btnSave.setBounds(10, 494, 250, 42);
		frame.getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveStockCard();
            }
        });
		
		JButton btnList = new JButton("LİSTELE");
		btnList.setBackground(new Color(192, 192, 192));
		btnList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StockCardListGUI stockCardListGUI = new StockCardListGUI(stockCardService);
                stockCardListGUI.setVisible(true);
                frame.dispose();
            }
        });
		frame.setVisible(true);
		
		btnList.setFont(new Font("Consolas", Font.BOLD, 16));
		btnList.setBounds(448, 494, 250, 42);
		frame.getContentPane().add(btnList);
		
	}
	private void saveStockCard() {
        try {
        	String stockCode = textStockCode.getText();
            String stockName = textStockName.getText();
            Integer stockType = (Integer) comboBoxStockType.getSelectedItem();
            String Unit = (String) comboBoxUnit.getSelectedItem();
            String Barcode = textBarcode.getText();
            Double kdvType = (Double) comboBoxKdvType.getSelectedItem();

            String Description = textAreaDesc.getText(); 
            System.out.println("Açıklama: " + Description); 
            
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateText = formattedTextFieldDate.getText();

            Date Date = dateFormatter.parse(dateText);
            
            
            StockCard stockCard = new StockCard(stockCode, stockName, stockType, Unit, Barcode, kdvType, Description, Date);
            stockCardService.saveStockCard(stockCard);
            JOptionPane.showMessageDialog(frame, "Stok kartı başarıyla kaydedildi.");
        } catch(ParseException e){
        	 JOptionPane.showMessageDialog(frame, "Tarih formatı hatalı. Lütfen 'dd/MM/yyyy' formatında bir tarih girin.");
        } catch (SQLException e) {
        	JOptionPane.showMessageDialog(frame, "Stok kartı kaydedilemedi: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(frame, "Beklenmedik bir hata oluştu: " + e.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
		}
    }
}
