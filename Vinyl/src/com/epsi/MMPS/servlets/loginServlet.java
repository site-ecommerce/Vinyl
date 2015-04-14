package com.epsi.MMPS.servlets;

import java.io.IOException;
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
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static final String MAIL_ADDRESS = "MAIL_ADDRESS";
    public static final String PASSWORD = "PASSWORD";
	public static final String PASSWORD_ERROR_MESSAGE = "L'adresse e-mail ou le mot de passe saisi est incorrect.";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		      String email = request.getParameter(MAIL_ADDRESS);
		       String password = request.getParameter("DATE_NAISSANCE");
		      if (Helper.isSet(email) && Helper.isSet(password)){
		       System.out.println("ok");
		       HttpSession session = request.getSession(true);
		       List<Customer> customerList = (List<Customer>)session.getAttribute("customerList");
		       CustomerDao cD = new CustomerDao();
		       cD.setCustomerList(customerList);
		       System.out.println(cD.customerList.get(0).getFirstname());
		       Customer c = cD.ClientExiste(email);
		       
		        if (c != null){
		              session.setAttribute("customer", c);
		        }else{
		         request.setAttribute("errorMessage", PASSWORD_ERROR_MESSAGE);
		        }
		       }else{
		        request.setAttribute("errorMessage", "Veuillez remplir tous les champs");
		       }
		      this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
		       
	}

}
