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

import com.epsi.MMPS.beans.Product;

public class ProductDao implements Serializable{
	private static String workingDir = System.getProperty("user.dir")+"/";   
	public List<Product> productList = null;
	private String url = "jdbc:mysql://localhost:8889/bdd_mon_site_ecomm";
	private String utilisateur = "root";
	private String motDePasse = "root";
	
	public Product getProductById(String id){
		Iterator i = productList.iterator();
		while(i.hasNext()){
			Product p = (Product) i.next();
			if (p.getId().equals(id)){
				return p;
			}
		}
		return null;
	}
	
public void getAllProducts() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	productList = new LinkedList<Product>();
	
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
   
    ResultSet resultat = statement.executeQuery("SELECT ARTICLES.*,LIEN_CATART.ID_CATEGORIE FROM ARTICLES, LIEN_CATART WHERE ARTICLES.ID_ARTICLE = LIEN_CATART.ID_ARTICLE" );
    
 
    String id ="";
    String label ="";
    Double PRIX = 0.0;
    String description ="";
    String visual = "";
    String categoryId ="";
   
    while ( resultat.next() ) {
    	id  = resultat.getString("ID_ARTICLE");
    	label = resultat.getString("LIBELLE"); 
    	PRIX = Double.parseDouble(resultat.getString("PVTTC"));
    	description = resultat.getString("DESCRIPTION");
    	visual = resultat.getString("VISUEL");
    	categoryId = resultat.getString("ID_CATEGORIE");
 
    	Product p1 = new Product(id,label,PRIX,description,visual,categoryId);
          productList.add(p1);
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
	public void addProduct(Product p){
		productList.add(p);
	}

	public void deleteProduct(String id){
		productList.remove(getProductById(id));
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
}
