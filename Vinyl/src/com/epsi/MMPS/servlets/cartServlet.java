package com.epsi.MMPS.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Cart;
import com.epsi.MMPS.beans.CartLine;
import com.epsi.MMPS.beans.Customer;

/**
 * Servlet implementation class cartServlet
 */
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession(true);
		if(request.getParameter("transaction").equals("add")){ // add to the shopping Cart
			if (session.getAttribute("customer") != null){ // If the customer is connected				
				if (session.getAttribute("cart") == null){
					session.setAttribute("cart", new loadServlet().initCart());
				}
					Cart cT = (Cart) session.getAttribute("cart"); // get the current cart
					Customer c = (Customer) session.getAttribute("customer");
					cT.addLineToCart(cT.getCartLineList(), c.getCustomerId(), new CartLine(request.getParameter("productId"),1,Integer.parseInt(request.getParameter("qte"))));
					this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);			
			}else{
				this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
			}			
		}else if(request.getParameter("transaction").equals("print")){
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/myCart.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
