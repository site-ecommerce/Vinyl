package com.epsi.MMPS.beans;

import java.io.Serializable;

public class Stock implements Serializable{
	private String productId;
	private int quantity;
	
	public Stock() {
		super();
	}
	public Stock(String productId, int quantity) {
		super();
		this.productId = productId;
		this.quantity = quantity;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
