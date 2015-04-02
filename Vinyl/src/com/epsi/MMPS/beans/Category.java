package com.epsi.MMPS.beans;

import java.io.Serializable;

public class Category implements Serializable{
	private String categoryId;
	private String label;
	private String description;
	private String visual;
	
	public Category() {
		super();
	}
	public Category(String categoryId, String label, String description,
			String visual) {
		super();
		this.categoryId = categoryId;
		this.label = label;
		this.description = description;
		this.visual = visual;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
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
	
}
