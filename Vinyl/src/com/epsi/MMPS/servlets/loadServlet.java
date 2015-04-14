package com.epsi.MMPS.servlets;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Cart;
import com.epsi.MMPS.beans.CartLine;
import com.epsi.MMPS.beans.Category;
import com.epsi.MMPS.beans.Customer;
import com.epsi.MMPS.beans.Product;
import com.epsi.MMPS.dao.CategoryDao;
import com.epsi.MMPS.dao.CustomerDao;
import com.epsi.MMPS.dao.ProductDao;
import com.epsi.MMPS.beans.Order;
import com.epsi.MMPS.beans.Stock;
import com.epsi.MMPS.dao.OrderDao;
import com.epsi.MMPS.dao.StockDao;

/**
 * Servlet implementation class loadServlet
 */

public class loadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if (session.getAttribute("productList") == null){
			 session.setAttribute("productList", listProducts());
		}
		if (session.getAttribute("customerList") == null){
			 session.setAttribute("customerList", listCustomer());
		}
		if (session.getAttribute("orderList") == null){
			 session.setAttribute("orderList", listOrder());
		}
		if (session.getAttribute("cart") == null){
			 session.setAttribute("cart", initCart());
		}
		if (session.getAttribute("categoryList") == null){
			 session.setAttribute("categoryList", listCategory());
		}
       
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	public Cart initCart(){
		Cart c = new Cart();
		List<CartLine> lineList = new LinkedList<CartLine>();
		//lineList.add(new CartLine("1", 3));
		//lineList.add(new CartLine("2", 5));
		//c.setCustomerID(1);
		c.setCartLineList(lineList);
		return c;
	}
	public List<Product> listProducts(){
		ProductDao pD = new ProductDao();
		try {
			pD.getAllProducts();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Product> productList = pD.productList;
		return productList;
	}
	public List<Customer> listCustomer(){
		CustomerDao cD = new CustomerDao();
		cD.getAllCustomers();
		List<Customer> customerList = cD.customerList;
		return customerList;
	}
	public List<Order> listOrder(){
		OrderDao oD = new OrderDao();
		oD.getAllOrders();
		List<Order> orderList = oD.OrderList;
		return orderList;
	}
	public List<Category> listCategory(){
		CategoryDao cD = new CategoryDao();
		cD.getAllCategories();
		List<Category> categoryList = cD.categoryList;
		return categoryList;
	}
}
