package com.epsi.MMPS.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.Stock;

public class StockDao implements Serializable{
	public List<Stock> StockList = null;
	
	public Stock getStockById(String productId){
		@SuppressWarnings("rawtypes")
		Iterator i = StockList.iterator();
		while(i.hasNext()){
			Stock s = (Stock) i.next();
			if (s.getProductId().equals(productId)){
				return s;
			}
		}
		return null;	
	}
	public void getAllStocks(){
		StockList = new LinkedList<Stock>();
		Stock s = new Stock("1", 35);
		StockList.add(s);
	}
}
