package com.epsi.MMPS.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.LineItem;

public class LineItemDao implements Serializable{
	
	public List<LineItem> lineItemList = null;
	private String url = "jdbc:mysql://localhost:8889/bdd_mon_site_ecomm";
	private String utilisateur = "root";
	private String motDePasse = "root";
	
	public LineItem getLineItemByID(int OrderId){
		@SuppressWarnings("rawtypes")
		Iterator i = lineItemList.iterator();
		while(i.hasNext()){
			LineItem l = (LineItem) i.next();
			if (l.getProductId().equals(OrderId)){
				return l;
			}
		}
		return null;	
	}
	
	public void getAllLineItems(){
		lineItemList = new LinkedList<LineItem>();
		LineItem l = new LineItem(1,1,"1", 35, 265.25);
		lineItemList.add(l);
	}
	
	public void ajouterLigneCommande(List<LineItem> lineItemList2){
		Connection connexion = null; 
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e){
			throw new RuntimeException(e);
		}
		
		try{
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse );
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
		for(int i = 1; i < lineItemList2.size();i++){
			try {
		   
		    Statement statement2 = connexion.createStatement();
		   
		    String sql = "INSERT INTO `LIGNES_COMMANDE`(`ID_COMMANDE`,`NUM_LIGNE`, `ID_ARTICLE`, `QTE`, `PVU`) "
		    		+ "VALUES (" + lineItemList2.get(i).getOrderId()  + "," + i + ",'" + lineItemList2.get(i).getProductId() + "'," + lineItemList2.get(i).getQuantity() + ",'" + lineItemList2.get(i).getUPrice() + "')";
		      
		    statement2.executeUpdate(sql);
		    	
			} catch ( SQLException e ) {
				e.printStackTrace();
		    } finally {
		    	if ( connexion != null )
		        try {
		            /* Fermeture de la connexion */
		            connexion.close();
		        } catch ( SQLException ignore ) {
		        ignore.printStackTrace();
		        }
		    }
		}
	}
	
}
