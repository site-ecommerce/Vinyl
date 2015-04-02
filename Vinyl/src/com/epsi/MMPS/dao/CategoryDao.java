package com.epsi.MMPS.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.Category;

public class CategoryDao implements Serializable{

	public List<Category> categoryList = null;
	
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
		Category c = new Category ("1","Marins","Les animaux marins",
				"C://");
		Category c1 = new Category ("2","Volants","Les animaux volants",
				"C://");
		Category c2 = new Category ("3","Terrestres","Les animaux Terrestres",
				"C://");
		Category c3 = new Category ("4","Iles","Poney des iles",
				"C://");
		categoryList.add(c);
		categoryList.add(c1);
		categoryList.add(c2);
		categoryList.add(c3);
	}
}
