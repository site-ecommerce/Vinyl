package com.epsi.MMPS.beans;

import java.io.Serializable;

public class LineItem implements Serializable{
	private int OrderId;
	private int LineNumber;
	private String ProductId;
	private int quantity;
	private double UPrice;
	
	public LineItem() {
		super();
	}
	public LineItem(int orderId, int lineNumber, String productId,
			int quantity, double uPrice) {
		super();
		OrderId = orderId;
		LineNumber = lineNumber;
		ProductId = productId;
		this.quantity = quantity;
		UPrice = uPrice;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getLineNumber() {
		return LineNumber;
	}
	public void setLineNumber(int lineNumber) {
		LineNumber = lineNumber;
	}
	public String getProductId() {
		return ProductId;
	}
	public void setProductId(String productId) {
		ProductId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUPrice() {
		return UPrice;
	}
	public void setUPrice(double uPrice) {
		UPrice = uPrice;
	}
	
}
