package com.epsi.MMPS.beans;

import java.util.Iterator;
import java.util.List;

public class CartLine {
	private String productId;
	private int lineNumber;
	private int quantite;

	public CartLine() {
		super();
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public CartLine(String lineItem, int lineNumber,int q) {
		super();
		this.productId = lineItem;
		this.lineNumber = lineNumber;
		this.quantite = q;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
}
