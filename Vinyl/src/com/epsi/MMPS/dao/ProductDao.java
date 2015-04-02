package com.epsi.MMPS.dao;


import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.Product;

public class ProductDao implements Serializable{
	private static String workingDir = System.getProperty("user.dir")+"/";   
	public List<Product> productList = null;
	
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
	public void getAllProducts(){
		productList = new LinkedList<Product>();
		Product p = new Product("1", "Poney des montagnes", 456.99, "Ceci est un poney des montagne", "C://", "1");
		Product p1 = new Product("2", "Poney des forêts", 56.99, "Ceci est un poney des forêts", "C://", "2");
		Product p2 = new Product("3", "Poney des mers", 46.99, "Ceci est un poney des mers", "C://", "3");
		Product p3 = new Product("4", "Poney arc en ciel", 26.99, "Ceci est un poney arc en ciel", "C://", "3");
		Product p4 = new Product("5", "Poney des iles", 126.99, "Poney des iles", "C://", "4");
		productList.add(p);
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		productList.add(p4);
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
