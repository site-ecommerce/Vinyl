package com.epsi.MMPS.beans;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Cart {
	private int customerID;
	private List<CartLine> cartLineList;
	
	public Cart() {
		super();
		List<CartLine> cartLineList = new LinkedList<CartLine>();
	}

	public Cart(int customerID, List<CartLine> cartLineList) {
		super();
		this.customerID = customerID;
		this.cartLineList = cartLineList;
	}
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public List<CartLine> getCartLineList() {
		return cartLineList;
	}

	public void setCartLineList(List<CartLine> cartLineList) {
		this.cartLineList = cartLineList;
	}
	public void addLineToCart(List<CartLine> cartLineList, int customerID, CartLine cL){
		Iterator i = cartLineList.iterator();
		Boolean found = false;
		while(i.hasNext()){
			CartLine c = (CartLine) i.next();
			if (c.getProductId().equals(cL.getProductId())){
				c.setLineNumber(c.getLineNumber() + cL.getLineNumber());
				found = true;
			}
		}
		if (!found){
			this.cartLineList.add(cL);
		}
	}
	

}
