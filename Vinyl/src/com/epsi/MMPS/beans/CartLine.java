package com.epsi.MMPS.beans;

import java.util.Iterator;
import java.util.List;

public class CartLine {
	private String productId;
	private int lineNumber;

	public CartLine() {
		super();
	}
	public CartLine(String lineItem, int lineNumber) {
		super();
		this.productId = lineItem;
		this.lineNumber = lineNumber;
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
