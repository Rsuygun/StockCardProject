package View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import Services.StockCardService;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import Models.StockCard;

public class StockCardListGUI extends JFrame {

    private JTable table;
    private JTextField textSearch;
    
    private StockCardService stockCardService;

    public StockCardListGUI(StockCardService stockCardService) {
        this.stockCardService = stockCardService;
        initialize(); 
        loadData();   
        showWindow(); 
    }

    private void initialize() {
        setBounds(100, 100, 847, 666);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        JLabel lblListe = new JLabel("LİSTE");
        lblListe.setHorizontalAlignment(SwingConstants.CENTER);
        lblListe.setFont(new Font("Consolas", Font.BOLD, 30));
        lblListe.setBounds(10, 11, 822, 29);
        getContentPane().add(lblListe);
        
        table = new JTable();
        table.setFont(new Font("Consolas", Font.PLAIN, 12));
        table.setBounds(20, 87, 798, 373);
        getContentPane().add(table);
        
        textSearch = new JTextField();
        textSearch.setFont(new Font("Consolas", Font.PLAIN, 16));
        textSearch.setBounds(287, 471, 250, 42);
        getContentPane().add(textSearch);
        textSearch.setColumns(10);
        
        JButton btnSerach = new JButton("ARAMA");
        btnSerach.setBackground(new Color(192, 192, 192));
        btnSerach.setFont(new Font("Consolas", Font.BOLD, 16));
        btnSerach.setBounds(568, 471, 250, 42);
        getContentPane().add(btnSerach);
        btnSerach.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String searchStockCode = textSearch.getText().trim();
        		
        		if(searchStockCode.isEmpty()) {
        			JOptionPane.showMessageDialog(null, "Lütfen aramak istediğiniz stok kodunu girin.");
                    return;
        		}
        		try {
        			 StockCard stockCard = stockCardService.searchStockCard(searchStockCode);
        			 if(stockCard != null) {
        				 DefaultTableModel model = new DefaultTableModel();
        	             model.setColumnIdentifiers(new Object[]{"Stock Code", "Stock Name", "Stock Type", "Unit", "Barcode", "KDV Type", "Description", "Date"});
        	             
        	             Object[] row = new Object[8]; 
        	                row[0] = stockCard.getStockCode();
        	                row[1] = stockCard.getStockName();
        	                row[2] = stockCard.getStockType();
        	                row[3] = stockCard.getUnit();
        	                row[4] = stockCard.getBarcode();
        	                row[5] = stockCard.getKdvType();
        	                row[6] = stockCard.getDescription();
        	                row[7] = stockCard.getDate();
        	                
        	                model.addRow(row);
        	                table.setModel(model);
        	                table.getTableHeader().setReorderingAllowed(false);
        	                table.getTableHeader().setResizingAllowed(true);
        	                table.setFillsViewportHeight(true);
        			 }else {
        				 JOptionPane.showMessageDialog(null, "Belirtilen stok kodu bulunamadı.");
        	                loadData();
        			 }
        		}catch(SQLException ex) {
        			ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Arama sırasında bir hata oluştu.");
        		}
        		
        	}
        });
        
        JButton btnSave = new JButton("YENİ STOK");
		btnSave.setBackground(new Color(192, 192, 192));
		btnSave.setFont(new Font("Consolas", Font.BOLD, 16));
		btnSave.setBounds(10, 571, 250, 42);
		getContentPane().add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                StockCardGUI stockCardGUI = new StockCardGUI(stockCardService, null);
                stockCardGUI.setVisible(true);
                dispose();
			}
		});
		setVisible(true);
        
        JButton btnDelete = new JButton("SİL");
        btnDelete.setBackground(new Color(192, 192, 192));
        btnDelete.setFont(new Font("Consolas", Font.BOLD, 16));
        btnDelete.setBounds(10, 471, 250, 42);
        getContentPane().add(btnDelete);
        btnDelete.addActionListener(new ActionListener(){
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String stockCodeToDelete = textSearch.getText().trim();
        		
        		if (stockCodeToDelete.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Lütfen silinecek stok kodunu girin.");
                    return;
                }
        		int confirm = JOptionPane.showConfirmDialog(null, "Bu stok kodunu silmek istediğinizden emin misiniz?", "Silme Onayı", JOptionPane.YES_NO_OPTION);
        		if (confirm == JOptionPane.YES_OPTION) {
        			try {
        				boolean isDeleted = stockCardService.deleteStockCard(stockCodeToDelete);
        				if(isDeleted) {
        					JOptionPane.showMessageDialog(null, "Stok kartı başarıyla silindi.");
                            loadData();
        				} else {
        					JOptionPane.showMessageDialog(null, "Belirtilen stok kodu bulunamadı.");
        				}
        			} catch (SQLException ex) {
        				 ex.printStackTrace();
        				 JOptionPane.showMessageDialog(null, "Silme işlemi sırasında bir hata oluştu.");
					}
        			}
        		}
    		});
        
        JButton btnUpdate = new JButton("GÜNCELLE");
        btnUpdate.setBackground(new Color(192, 192, 192));
        btnUpdate.setFont(new Font("Consolas", Font.BOLD, 16));
        btnUpdate.setBounds(568, 571, 250, 42);
        getContentPane().add(btnUpdate);
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String stockCodeToUpdate = textSearch.getText().trim();
            	
            	if (stockCodeToUpdate.isEmpty()) {
            		 JOptionPane.showMessageDialog(null, "Lütfen güncellenecek stok kodunu girin.");
                     return;
            	}
            	try {
            		 StockCard stockCardToUpdate = stockCardService.searchStockCard(stockCodeToUpdate);
            		 
            		 if(stockCardToUpdate != null) {
            			 StockCardGUI stockCardGUI = new StockCardGUI(stockCardService, stockCardToUpdate);
            			 stockCardGUI.setVisible(true);
            			 dispose();
            		 }else {
            			 JOptionPane.showMessageDialog(null, "Belirtilen stok kodu bulunamadı.");
            		 }
            	}catch(SQLException ex) {
            		ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Güncelleme sırasında bir hata oluştu.");
            	}
            }
        });
        
        JButton btnCopy = new JButton("KOPYALA");
        btnCopy.setFont(new Font("Consolas", Font.BOLD, 16));
        btnCopy.setBackground(Color.LIGHT_GRAY);
        btnCopy.setBounds(287, 571, 250, 42);
        getContentPane().add(btnCopy);
        btnCopy.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String stockCodeToCopy = textSearch.getText().trim();

        		if (stockCodeToCopy.isEmpty()) {
        			 JOptionPane.showMessageDialog(null, "Lütfen kopyalanacak stok kodunu girin.");
        	         return;
        		}
        		try {
        			StockCard stockCardToCopy = stockCardService.searchStockCard(stockCodeToCopy);
        			
        			if (stockCardToCopy != null) {
        				StockCard copiedStockCard = new StockCard();
                        copiedStockCard.setStockName(stockCardToCopy.getStockName());
                        copiedStockCard.setStockType(stockCardToCopy.getStockType());
                        copiedStockCard.setUnit(stockCardToCopy.getUnit());
                        copiedStockCard.setBarcode(stockCardToCopy.getBarcode());
                        copiedStockCard.setKdvType(stockCardToCopy.getKdvType());
                        copiedStockCard.setDescription(stockCardToCopy.getDescription());
                        copiedStockCard.setDate(stockCardToCopy.getDate());

                        copiedStockCard.setStockCode(""); 
                        
                        StockCardGUI stockCardGUI = new StockCardGUI(stockCardService, copiedStockCard);
                        stockCardGUI.setVisible(true);
                        dispose();
        			}else {
        				JOptionPane.showMessageDialog(null, "Belirtilen stok kodu bulunamadı.");
        			}
        		}catch (SQLException ex) {
        			ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Kopyalama sırasında bir hata oluştu.");
				}
        	}
        });
        
        JLabel lblStockCode = new JLabel("Stok Kodu");
        lblStockCode.setFont(new Font("Consolas", Font.BOLD, 13));
        lblStockCode.setBounds(20, 72, 63, 14);
        getContentPane().add(lblStockCode);
        
        JLabel lblStockName = new JLabel("Stok Adı");
        lblStockName.setFont(new Font("Consolas", Font.BOLD, 13));
        lblStockName.setBounds(120, 72, 63, 14);
        getContentPane().add(lblStockName);
        
        JLabel lblStockType = new JLabel("Stok Tipi");
        lblStockType.setFont(new Font("Consolas", Font.BOLD, 13));
        lblStockType.setBounds(220, 72, 63, 14);
        getContentPane().add(lblStockType);
        
        JLabel lblUint = new JLabel("Birimi");
        lblUint.setFont(new Font("Consolas", Font.BOLD, 13));
        lblUint.setBounds(320, 72, 63, 14);
        getContentPane().add(lblUint);
        
        JLabel lblBarcode = new JLabel("Barkodu");
        lblBarcode.setFont(new Font("Consolas", Font.BOLD, 13));
        lblBarcode.setBounds(420, 72, 63, 14);
        getContentPane().add(lblBarcode);
        
        JLabel lblKdvType = new JLabel("KDV Tipi");
        lblKdvType.setFont(new Font("Consolas", Font.BOLD, 13));
        lblKdvType.setBounds(520, 72, 63, 14);
        getContentPane().add(lblKdvType);
        
        JLabel lblDescription = new JLabel("Açıklama");
        lblDescription.setFont(new Font("Consolas", Font.BOLD, 13));
        lblDescription.setBounds(620, 72, 63, 14);
        getContentPane().add(lblDescription);
        
        JLabel lblDate = new JLabel("Tarih");
        lblDate.setFont(new Font("Consolas", Font.BOLD, 13));
        lblDate.setBounds(720, 72, 63, 14);
        getContentPane().add(lblDate);
    }

    public void loadData() {
        try {
            List<StockCard> stockCardList = stockCardService.getAllStockCards();
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(new Object[] { "Stock Code", "Stock Name", "Stock Type", "Unit", "Barcode", "KDV Type", "Description", "Date" });
            for (StockCard stockCard : stockCardList) {
                Object[] row = new Object[8]; 
                row[0] = stockCard.getStockCode();
                row[1] = stockCard.getStockName();
                row[2] = stockCard.getStockType();
                row[3] = stockCard.getUnit();
                row[4] = stockCard.getBarcode();
                row[5] = stockCard.getKdvType();
                row[6] = stockCard.getDescription();
                row[7] = stockCard.getDate();
                
                model.addRow(row);
            }
            table.setModel(model);
            table.getTableHeader().setReorderingAllowed(false);
            table.getTableHeader().setResizingAllowed(true);
            table.setFillsViewportHeight(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Veri yüklenirken bir hata oluştu.");
        }
    }

    public void showWindow() {
    	this.setVisible(true);
    }
}