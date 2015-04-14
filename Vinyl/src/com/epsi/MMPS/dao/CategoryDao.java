package com.epsi.MMPS.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.Category;
import com.epsi.MMPS.beans.Customer;

public class CategoryDao implements Serializable{

	public List<Category> categoryList = null;
	private String url = "jdbc:mysql://localhost:8889/bdd_mon_site_ecomm";
	private String utilisateur = "root";
	private String motDePasse = "root";
	
	public Category getCategoryById(String id){
		@SuppressWarnings("rawtypes")
		Iterator i = categoryList.iterator();
		while(i.hasNext()){
			Category c = (Category) i.next();
			if (c.getCategoryId().equals(id)){
				return c;
			}
		}
		return null;
	}
	public void getAllCategories(){
			categoryList = new LinkedList<Category>();
			
			Connection connexion = null;
			
			try{
				connexion = DriverManager.getConnection(url, utilisateur, motDePasse );
			}catch (SQLException e){
				throw new RuntimeException(e);
			}
			
			try {
		   
		    Statement statement = connexion.createStatement();
		   
		    ResultSet resultat = statement.executeQuery("SELECT * FROM CATEGORIES ");
		 
		    while (resultat.next()){
		    	Category c = new Category(resultat.getString("ID_categorie"), resultat.getString("LIBELLE"),
		    							resultat.getString("DESCRIPTION"),"");
		    	categoryList.add(c);
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
