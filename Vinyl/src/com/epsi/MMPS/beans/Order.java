package com.epsi.MMPS.beans;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	private int OrderId;
	private int CustomerId;
	private Date OrderDate;
	private double price;
	public Order(){
		super();
	}
	public Order(int orderId, int customerId, Date orderDate, double price) {
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
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
