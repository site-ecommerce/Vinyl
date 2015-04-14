package com.epsi.MMPS.beans;

import java.io.Serializable;
import java.util.Random;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String label;
	private double PRIX;
	private String description;
	private int stars;
	private String visual;
	private String categoryId;
	public Product(){
		super();
	}
	public Product(String id, String label, double pRIX, String description,
			String visual, String categoryId) {
		super();
		Random rand = new Random();
		this.id = id;
		this.label = label;
		PRIX = pRIX;
		this.description = description;
		this.stars = rand.nextInt(6);
		this.visual = visual;
		this.categoryId = categoryId;
	}
	
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public double getPRIX() {
		return PRIX;
	}
	public void setPRIX(double pRIX) {
		PRIX = pRIX;
	}
	public String getDescription() {
		return description;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVisual() {
		return visual;
	}
	public void setVisual(String visual) {
		this.visual = visual;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", label=" + label + ", PRIX=" + PRIX
				+ ", description=" + description + ", visual=" + visual + "]";
	}
	
}
