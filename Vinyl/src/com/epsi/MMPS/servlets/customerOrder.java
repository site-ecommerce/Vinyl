package com.epsi.MMPS.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Cart;
import com.epsi.MMPS.beans.Customer;
import com.epsi.MMPS.beans.LineItem;
import com.epsi.MMPS.beans.Order;
import com.epsi.MMPS.beans.Product;
import com.epsi.MMPS.dao.OrderDao;

/**
 * Servlet implementation class customerOrder
 */
@WebServlet("/customerOrder")
public class customerOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public customerOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(true);
		 if (session.getAttribute("customer") != null){ // If the customer is connected		
			 Customer c = (Customer)session.getAttribute("customer");
			 System.out.println("ID en cours" + c.getCustomerId());
			 ArrayList<Order> ListeRetourneCommande = new ArrayList<Order>();
			 ArrayList<Integer> ListeIdProductsInOrders = new ArrayList<Integer>();
			 
			 ListeIdProductsInOrders = new OrderDao().getIdProductsArticleCustomer(c.getCustomerId());
			 ListeRetourneCommande = new OrderDao().getCommandeClient(c.getCustomerId());
			 
			 List<Product> pL = (List<Product>) session.getAttribute("productList");
			 
			 session.setAttribute("CommandProducts",ListeIdProductsInOrders);
			 session.setAttribute("AllProducts", pL);
			 session.setAttribute("AllOrdersCustomer", ListeRetourneCommande);
		 }
		 this.getServletContext().getRequestDispatcher("/WEB-INF/view/myOrders.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
