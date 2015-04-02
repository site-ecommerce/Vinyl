package com.epsi.MMPS.dao;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.epsi.MMPS.beans.Customer;


public class CustomerDao implements Serializable{
	public List<Customer> customerList = null;
	
	
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}
	public Customer getCustomerById(int id){
		@SuppressWarnings("rawtypes")
		Iterator i = this.customerList.iterator();
		while(i.hasNext()){
			Customer c = (Customer) i.next();
			if (c.getCustomerId() == id){
				return c;
			}
		}
		return null;
	}
	public Customer getCustomerByEmail(String email){
		@SuppressWarnings("rawtypes")
		Iterator i = this.customerList.iterator();
		while(i.hasNext()){
			Customer c = (Customer) i.next();
			if (c.getMail().equals(email)){
				return c;
			}
		}
		return null;
	}
	public Customer checkCustomerExist(String email, String password){
		Customer c = this.getCustomerByEmail(email);
		if(c !=null && c.getPassword().equals(password)){
			return c;
		}
		return null;
	}
	public void getAllCustomers(){
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		customerList = new LinkedList<Customer>();
		Customer c = new Customer (1,"Alex", "Deneuvillers",
				"mail@mail.fr",aujourdhui, "4 rue de test", "alex",
				"0000");
		Customer c1 = new Customer (2,"Hamy", "Remi",
				"mail@mail.fr",aujourdhui, "4 rue de ", "remi",
				"0000");
		customerList.add(c);
		customerList.add(c1);
	}
}
