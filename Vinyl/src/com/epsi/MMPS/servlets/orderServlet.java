package com.epsi.MMPS.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Cart;
import com.epsi.MMPS.beans.CartLine;
import com.epsi.MMPS.beans.Category;
import com.epsi.MMPS.beans.Customer;
import com.epsi.MMPS.beans.LineItem;
import com.epsi.MMPS.beans.Order;
import com.epsi.MMPS.beans.Product;

/**
 * Servlet implementation class OrderServlet
 */
public class orderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Order o = new Order();
		double total = 0.0;
		int idOne = new Random().nextInt(1000);
		o.setOrderId(idOne);
		SimpleDateFormat formater = null;
		Date aujourdhui = new Date();
		formater = new SimpleDateFormat("dd/MM/yy");
		formater.format(aujourdhui);
	
		 if (session.getAttribute("customer") != null){ // If the customer is connected		
			 Cart currentCart = (Cart) session.getAttribute("cart");
			 List<Product> pL = (List<Product>) session.getAttribute("productList");
			 List<LineItem> lineItemList = new LinkedList<LineItem>();
			 Customer c = (Customer)session.getAttribute("customer");
			 o.setCustomerId(c.getCustomerId());
			 Iterator i = currentCart.getCartLineList().iterator();
			 Iterator i1 = pL.iterator();
			 Iterator i2 = lineItemList.iterator();
			 while (i.hasNext()){ // Parcours des lignes du panier
				 CartLine cL = (CartLine) i.next();
				 while (i1.hasNext()){ // Get du prix du produit en fonction de l'id
					 Product p = (Product) i1.next();
					 if (p.getId().equals(cL.getProductId())){
						 LineItem lI = new LineItem(); //création d'un object Line item : prix, id produit, id Commande
						 lI.setOrderId(idOne);
						 lI.setProductId(p.getId());
						 lI.setQuantity(cL.getLineNumber());
						 lI.setUPrice(lI.getQuantity() * p.getATIP());
						 lineItemList.add(lI);
						 total += lI.getUPrice();
					 }
				 }				 
			 }
			 o.setOrderDate(aujourdhui);
			 o.setPrice(total);
			 session.setAttribute("order", o);
			 session.setAttribute("lineItemList", lineItemList);
			 this.getServletContext().getRequestDispatcher("/WEB-INF/view/myOrder.jsp").forward(request, response);
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
