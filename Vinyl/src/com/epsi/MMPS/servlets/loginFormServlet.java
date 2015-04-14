package com.epsi.MMPS.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Customer;
import com.epsi.MMPS.dao.CustomerDao;
import com.epsi.MMPS.helper.Helper;

/**
 * Servlet implementation class loginFormServlet
 */
public class loginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String LOGIN = "LOGIN";
	public static final String FIRSTNAME = "FIRSTNAME";
	public static final String NAME = "NAME";
	public static final String ADDRESS = "ADDRESS";
	public static final String MAIL_ADDRESS = "MAIL_ADDRESS";
	public static final String PASSWORD = "PASSWORD";
	public static final String PASSWORD_CONF = "PASSWORD_CONF";
	public static final String DATE = "DATE";
	public static  String ERROR_MESSAGE = "L'adresse e-mail ou le mot de passe saisi est incorrect.";      
	public static  String INFO_MESSAGE = "Votre compte � �t� cr�� avec succ�s !";      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		// TODO Auto-generated method stub
		int idOne = new Random().nextInt(1000);
		if (Helper.isSet(request.getParameter("creation"))){ 
			 String email = request.getParameter(MAIL_ADDRESS);
		     String password = request.getParameter(PASSWORD);
		     String name = request.getParameter(NAME);
		     String firstname = request.getParameter(FIRSTNAME);
		     String address = request.getParameter(ADDRESS);
		     String birthDate = request.getParameter(DATE);
		     
			 List<Customer> customerList = (List<Customer>)session.getAttribute("customerList"); //V�rification existence utilisateur
	    	 CustomerDao cD = new CustomerDao();
	    	 cD.setCustomerList(customerList);
	    	 System.out.println(cD.customerList.get(0).getFirstname());
	    	 
	    	  if (cD.ClientExiste(email) != null){ //Si le compte existe d�j�
	    		ERROR_MESSAGE = "Un compte existe d�j� avec cette adresse";
	    		request.setAttribute("errorMessage", ERROR_MESSAGE);
	    		this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	    	  }else{
	    		  if (checkCustomerInfo(email)){ // si le mail est correct et les mdp identiques
	    			  Date d = isDateValid(birthDate, "dd/MM/yyyy"); // si la date est au bon format
	    			  if ( d != null){
	    				  Customer c1 = new Customer(idOne, firstname, name,
	 	    					 email, d.toString(), address);
	    				 customerList.add(c1);
	    				 request.setAttribute("infoMessage", INFO_MESSAGE);
	    				 session.setAttribute("customer", c1);
	    				 this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	    			  }else {
	    				  ERROR_MESSAGE = "La date de naissance n'est pas valide";
	    		    		request.setAttribute("errorMessage", ERROR_MESSAGE);
	    		    		this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	    			  }
	    		  }else{
	    			  ERROR_MESSAGE = "La v�rification du mot de passe a �chou�";
	  	    		request.setAttribute("errorMessage", ERROR_MESSAGE);
	  	    		this.getServletContext().getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	    		  }	    		
	    	  }
		}
	}
	protected boolean checkCustomerInfo(String mail){
		Boolean test = false;
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
			CharSequence inputStr = mail;  
			//Make the comparison case-insensitive.  
			Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
			Matcher matcher = pattern.matcher(inputStr);  
			if(matcher.matches()){  
				test = true;
			}  
		return test;
	}
	
	
	protected Date isDateValid(String dateToValidate, String dateFromat){		 
		if(dateToValidate == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);
		try {
			//if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			return date;
		} catch (ParseException e) { 
			e.printStackTrace();
			return null;
		}
	}
}
