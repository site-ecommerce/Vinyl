package com.epsi.MMPS.beans;

import java.io.Serializable;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String label;
	private double ATIP;
	private String description;
	private String visual;
	private String categoryId;
	public Product(){
		super();
	}
	public Product(String id, String label, double aTIP, String description,
			String visual, String categoryId) {
		super();
		this.id = id;
		this.label = label;
		ATIP = aTIP;
		this.description = description;
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
	public double getATIP() {
		return ATIP;
	}
	public void setATIP(double aTIP) {
		ATIP = aTIP;
	}
	public String getDescription() {
		return description;
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
		return "Product [id=" + id + ", label=" + label + ", ATIP=" + ATIP
				+ ", description=" + description + ", visual=" + visual + "]";
	}
	
}
