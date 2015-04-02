package com.epsi.MMPS.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epsi.MMPS.beans.Category;
import com.epsi.MMPS.beans.Product;

/**
 * Servlet implementation class categoryServlet
 */
@WebServlet("/categoryServlet")
public class categoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String cID = request.getParameter("categoryID");
		List<Category> cL = (List<Category>) session.getAttribute("categoryList");
		Iterator i = cL.iterator();
		 while (i.hasNext()){
			 Category c = (Category) i.next();
			 if (c.getCategoryId().equals(cID)){
				 session.setAttribute("categorySelected", c);
			 }
		 }		
		this.getServletContext().getRequestDispatcher("/WEB-INF/view/category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
