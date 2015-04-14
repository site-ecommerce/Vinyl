package com.epsi.MMPS.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.Customer;
import com.epsi.MMPS.beans.Product;


public class CustomerDao implements Serializable{
	public List<Customer> customerList = null;
	private String url = "jdbc:mysql://localhost:8889/bdd_mon_site_ecomm";
	private String utilisateur = "root";
	private String motDePasse = "root";
	
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public Customer getCustomerById(int id){
		@SuppressWarnings("rawtypes")
		Iterator i = this.customerList.iterator();
		while(i.hasNext()){
			Customer c = (Customer) i.next();
			if (c.getCustomerId() == id){
				return c;
			}
		}
		return null;
	}
	public Customer getCustomerByEmail(String email){
		@SuppressWarnings("rawtypes")
		Iterator i = this.customerList.iterator();
		while(i.hasNext()){
			Customer c = (Customer) i.next();
			if (c.getMail().equals(email)){
				return c;
			}
		}
		return null;
	}
	
	public void InscriptionClient(Customer c) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Connection connexion = null; 
		int IdClient = 0;
		
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
			Statement statement1 = connexion.createStatement();
			
			ResultSet resultat = statement1.executeQuery("SELECT COALESCE(MAX(NUM_CLIENT),0) + 1 as MAX FROM CLIENT");
			
			while (resultat.next()){
				IdClient = Integer.parseInt(resultat.getString("MAX"));
			}
			
		}catch ( SQLException e ) {
			e.printStackTrace();
	    } 

		try {
	   
	    Statement statement2 = connexion.createStatement();
	   
	    String sql = "INSERT INTO `CLIENT`(`NUM_CLIENT`,`NOM`, `PRENOM`, `ADR_MAIL`, `DATE_NAISSANCE`, `ADR_POSTALE`) "
	    		+ "VALUES (" + IdClient + ",'" + c.getLastname() + "','" + c.getFirstname() + "','" + c.getMail() + "','" + c.getBirthDate() + "','"+ c.getAddress() + "')";
	      
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
	
	public Customer ClientExiste(String email){
	
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
	   
	    Statement statement = connexion.createStatement();
	   
	    ResultSet resultat = statement.executeQuery("SELECT * FROM CLIENT WHERE ADR_MAIL='" + email + "'");
	 
	    while (resultat.next()){
	    	return new Customer(Integer.parseInt(resultat.getString("NUM_CLIENT")),resultat.getString("NOM"),
					  resultat.getString("PRENOM"),resultat.getString("ADR_MAIL"),
					  resultat.getString("DATE_NAISSANCE"),resultat.getString("ADR_POSTALE"));
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
		return null;
	}
	
public void ModificationClient(Customer c) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Connection connexion = null; 
		int IdClient = 0;
		
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
	   
	    Statement statement = connexion.createStatement();
	   
	    String sql = "UPDATE `CLIENT` SET `NOM` = '" + c.getLastname() + "', `PRENOM` = '" + c.getFirstname() +"' ," + 
	    		" `ADR_MAIL` = '" + c.getMail() + "', `DATE_NAISSANCE` = '" + c.getBirthDate() +"', `ADR_POSTALE` = '" + c.getAddress() + "' " + 
	    		" WHERE NUM_CLIENT = " + c.getCustomerId();
	    	
	     System.out.println("MODIFS ://// " + sql);
	    statement.executeUpdate(sql);
	    	
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
	
	
	
	public void getAllCustomers(){
		
		Connection connexion = null;
	
		customerList = new LinkedList<Customer>();
		
		try{
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse );
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
		
		try {
	   
	    Statement statement = connexion.createStatement();
	   
	    ResultSet resultat = statement.executeQuery("SELECT * FROM CLIENT ");
	 
	    while (resultat.next()){
	    	Customer c = new Customer(Integer.parseInt(resultat.getString("NUM_CLIENT")),resultat.getString("NOM"),
	    							  resultat.getString("PRENOM"),resultat.getString("ADR_MAIL"),
	    							  resultat.getString("DATE_NAISSANCE"),resultat.getString("ADR_POSTALE"));
	    	customerList.add(c);
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
	}
}
