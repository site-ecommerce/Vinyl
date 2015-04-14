package com.epsi.MMPS.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Customer;
import com.epsi.MMPS.dao.CustomerDao;

/**
 * Servlet implementation class ModifClientServlet
 */
@WebServlet(name = "updateInfoCustomerServlet", urlPatterns = { "/updateInfoCustomerServlet" })
public class updateCustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateCustomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  int id = Integer.parseInt(request.getParameter("IdCustomer"));
		  String email = request.getParameter("MAIL_ADDRESS");
		  System.out.println(email);
		  String nom = request.getParameter("NAME");
		  String prenom = request.getParameter("FIRSTNAME");
		  String DateN = request.getParameter("DATE").toString();
		  String Adresse = request.getParameter("ADDRESS");
	      
	    	 HttpSession session = request.getSession(true);
	    	 
	    	 Customer ClientAModif = new Customer(id, prenom, nom,email, DateN, Adresse);

	    	 if (new CustomerDao().ClientExiste(email) != null){
	    		 
				 try {
					new CustomerDao().ModificationClient(ClientAModif);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("errorMessage", "Modifications sur votre compte effecutées !! ;-)");
	    	  }
	      
	
	     this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	      
	}

}
