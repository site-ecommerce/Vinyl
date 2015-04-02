package com.epsi.MMPS.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Product;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
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
		HttpSession session = request.getSession(true);
		String searchString = request.getParameter("searchString");
		List<Product> productFoundList = new LinkedList<Product>();
		List<Product> pL = (List<Product>) session.getAttribute("productList");
		Iterator i = pL.iterator();
		 while (i.hasNext()){
			 Product p = (Product) i.next();
			 if (p.getLabel().toLowerCase().contains(searchString.toLowerCase())){
				 productFoundList.add(p);
			 }
		 }
		 session.setAttribute("productFoundList", productFoundList);
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp").forward(request, response);
	}

}
