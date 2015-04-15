package com.epsi.MMPS.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.epsi.MMPS.dao.LineItemDao;
import com.epsi.MMPS.dao.OrderDao;

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
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
	
		 if (session.getAttribute("customer") != null){ // If the customer is connected		
			 Cart currentCart = (Cart) session.getAttribute("cart");
			 List<Product> pL = (List<Product>) session.getAttribute("productList");
			 List<LineItem> lineItemList = new LinkedList<LineItem>();
			 Customer c = (Customer)session.getAttribute("customer");
			 o.setCustomerId(c.getCustomerId());
			 o.setOrderId(new OrderDao().getAllOrders() + 1);
			 System.out.println("nombre de commandes" + o.getOrderId());
			 System.out.println("nombre de produits" + currentCart.getCartLineList().size());
			 //Iterator i = currentCart.getCartLineList().iterator();
			 //Iterator i1 = pL.iterator();
			 //Iterator i2 = lineItemList.iterator();
			 //while (i.hasNext()){ // Parcours des lignes du panier
			 for(int y=0; y < currentCart.getCartLineList().size();y++){
			 CartLine cL = currentCart.getCartLineList().get(y);
			 for(int i=0; i < pL.size();i++){ // Get du prix du produit en fonction de l'id
				 Product p = pL.get(i);
				 if (p.getId().equals(cL.getProductId())){
					 LineItem lI = new LineItem(); //crï¿½ation d'un object Line item : prix, id produit, id Commande
					 lI.setOrderId(o.getOrderId());
					 lI.setProductId(p.getId());
					 lI.setQuantity(cL.getLineNumber());
					 lI.setUPrice(lI.getQuantity() * p.getPRIX());
					 lineItemList.add(lI);
					 total += lI.getUPrice();
				 }
			 }				 
		 }

			 o.setOrderDate(dateFormat.format(date));
			 o.setPrice(total + ( 1 + 0.02 * total));
			 new OrderDao().ajouterCommande(o);
			 new LineItemDao().ajouterLigneCommande(lineItemList);
			 currentCart.dropCart(currentCart);
			 session.setAttribute("infos", "Votre commande a été enregistrée !");
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
