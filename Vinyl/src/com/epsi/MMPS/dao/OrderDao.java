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
	private String url = "jdbc:mysql://localhost:8889/bdd_mon_site_ecomm";
	private String utilisateur = "root";
	private String motDePasse = "root";
	
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
		    	return Integer.parseInt(resultat.getString("max"))+1;
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
		    		+ "VALUES (" + o.getOrderId() + 1  + "," + o.getCustomerId() + ",'" + o.getOrderDate() + "'," + o.getPrice() + ")";
		      
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
	
	
	public ArrayList<Order> getCommandeClient(int idClient){
		Connection connexion = null; 
		
		ArrayList<Order> liste = new ArrayList<Order>();
		
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
		   
		    String sql = "SELECT * FROM COMMANDE WHERE NUM_CLIENT = " + idClient;
		    
		    System.out.println("SQL //// " + sql);
		      
		    ResultSet resultat = statement2.executeQuery(sql);
			 
		    while (resultat.next()){
		    	Order o = new Order(Integer.parseInt(resultat.getString("ID_COMMANDE")),Integer.parseInt(resultat.getString("NUM_CLIENT")),
		    						 resultat.getString("DATE_COMMANDE"), Double.parseDouble(resultat.getString("TOTAL")));
		    	liste.add(o);
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
		return liste;
	}

	public ArrayList<Integer> getIdProductsArticleCustomer(int idClient){
		Connection connexion = null; 
		
		ArrayList<Integer> liste = new ArrayList<Integer>();
		
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
		   
		    String sql = "SELECT ID_ARTICLE FROM LIGNES_COMMANDE WHERE ID_COMMANDE IN (SELECT ID_COMMANDE FROM COMMANDE WHERE NUM_CLIENT = " + idClient + ")";
		    
		    System.out.println("SQL //// " + sql);
		      
		    ResultSet resultat = statement2.executeQuery(sql);
			 
		    while (resultat.next()){
		    	liste.add(Integer.parseInt(resultat.getString("ID_ARTICLE")));
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
		return liste;
	}
	
	
}
