package com.epsi.MMPS.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.LineItem;

public class LineItemDao implements Serializable{
	
	public List<LineItem> lineItemList = null;
	
	public LineItem getLineItemByID(int OrderId){
		@SuppressWarnings("rawtypes")
		Iterator i = lineItemList.iterator();
		while(i.hasNext()){
			LineItem l = (LineItem) i.next();
			if (l.getProductId().equals(OrderId)){
				return l;
			}
		}
		return null;	
	}
	
	public void getAllLineItems(){
		lineItemList = new LinkedList<LineItem>();
		LineItem l = new LineItem(1,1,"1", 35, 265.25);
		lineItemList.add(l);
	}
	
}
