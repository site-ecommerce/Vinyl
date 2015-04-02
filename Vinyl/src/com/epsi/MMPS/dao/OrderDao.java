package com.epsi.MMPS.dao;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.Order;

public class OrderDao implements Serializable{
	public List<Order> OrderList = null;
	
	public Order getOrderById(int OrderId){
		@SuppressWarnings("rawtypes")
		Iterator i = OrderList.iterator();
		while(i.hasNext()){
			Order o = (Order) i.next();
			if (o.getOrderId() == OrderId){
				return o;
			}
		}
		return null;
	}
	public void getAllOrders(){
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		formater.format(aujourdhui);
		OrderList = new LinkedList<Order>();
		Order o = new Order (1,1,aujourdhui,657.25);
		OrderList.add(o);
	}

}
