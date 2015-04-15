package com.epsi.MMPS.beans;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	private int OrderId;
	private int CustomerId;
	private String OrderDate;
	private double price;
	public Order(){
		super();
	}
	public Order(int orderId, int customerId, String orderDate, double price) {
		super();
		OrderId = orderId;
		CustomerId = customerId;
		OrderDate = orderDate;
		this.price = price;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(String string) {
		OrderDate = string;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString(){
		return "Commande n° " + this.OrderId + " - Le " + this.OrderDate + " (" + this.price + ")";
	}
}
