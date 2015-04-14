package com.epsi.MMPS.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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
 * Servlet implementation class InscriptionServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
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
		  String email = request.getParameter("MAIL_ADDRESS");
		  System.out.println(email);
		  String nom = request.getParameter("NAME");
		  String prenom = request.getParameter("FIRSTNAME");
		  String DateN = request.getParameter("DATE").toString();
		  String Adresse = request.getParameter("ADDRESS");
	      
	    	 HttpSession session = request.getSession(true);
	    	 Customer testClientExiste = new CustomerDao().ClientExiste(email);
	    	 
	    	  if (testClientExiste == null){
	    	       Customer ClientAInscrire = new Customer(1, prenom, nom,email, DateN, Adresse);

				 try {
					new CustomerDao().InscriptionClient(ClientAInscrire);
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("errorMessage", "Bienvenue " + nom + " " + prenom + " ;-)");
	    	  }else{
	    		  request.setAttribute("errorMessage", "Compte déja existant");
	    	  }
	      
	
	     this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	      
	}

}
