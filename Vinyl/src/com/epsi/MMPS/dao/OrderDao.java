package com.epsi.MMPS.dao;

import java.util.Date;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.Customer;
import com.epsi.MMPS.beans.LineItem;
import com.epsi.MMPS.beans.Order;

public class OrderDao implements Serializable{
	public List<Order> OrderList = null;
	private String url = "jdbc:mysql://localhost:3306/bdd_mon_site_ecomm";
	private String utilisateur = "root";
	private String motDePasse = "";
	
	public Order getOrderById(int OrderId){
		@SuppressWarnings("rawtypes")
		Iterator i = OrderList.iterator();
		while(i.hasNext()){
			Order o = (Order) i.next();
			if (o.getOrderId() == OrderId){
				return o;
			}
		}
		return null;
	}
	public int getAllOrders(){
			Connection connexion = null;
			
			try{
				connexion = DriverManager.getConnection(url, utilisateur, motDePasse );
			}catch (SQLException e){
				throw new RuntimeException(e);
			}
			
			try {
		   
		    Statement statement = connexion.createStatement();
		   
		    ResultSet resultat = statement.executeQuery("SELECT count(*) as max FROM CLIENT ");
		 
		    while (resultat.next()){
		    	return Integer.parseInt(resultat.getString("max"));
		    }
		
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
			return 0;
		}
	   
	
	
	public void ajouterCommande(Order o){
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
		
			try {
		   
		    Statement statement2 = connexion.createStatement();
		   
		    String sql = "INSERT INTO `COMMANDE`(`ID_COMMANDE`,`NUM_CLIENT`, `DATE_COMMANDE`, `TOTAL`) "
		    		+ "VALUES (" + o.getOrderId()  + "," + o.getCustomerId() + ",'" + o.getOrderDate() + "'," + o.getPrice() + ")";
		      
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
