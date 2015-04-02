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
		Product p = new Product("1", "Vinyl A", 19.99, "Album classique", "C://", "1");
		Product p1 = new Product("2", "Vinyl B", 16.99, "Album rock", "C://", "2");
		Product p2 = new Product("3", "Vinyl C", 46.99, "Album jazz 1", "C://", "3");
		Product p3 = new Product("4", "Vinyl D", 86.99, "Album jazz 2", "C://", "3");
		Product p4 = new Product("5", "Vinyl E", 26.99, "Album pop", "C://", "4");
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
