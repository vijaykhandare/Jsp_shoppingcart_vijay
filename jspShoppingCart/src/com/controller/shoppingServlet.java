package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BLManager;
import com.pojo.Product;
import com.pojo.item;

/**
 * Servlet implementation class shoppingServlet
 */
@WebServlet("/shoppingServlet")
public class shoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BLManager bl = new BLManager();

	Product p = new Product();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id1 = Integer.parseInt(request.getParameter("id"));

		p = bl.serchbyid(id1);
		int id = p.getId();
//hi this is git hub
		/*
		 * String action=request.getParameter("ordernow");
		 * System.out.println("action:"+action);
		 */
	
		String action =request.getParameter("action");
		
		//System.out.println(action1 + "action1");
		// System.out.println(action+"action");
		HttpSession session = request.getSession();
		if (action.equals("ordernow")) {
			if (session.getAttribute("cart") == null) {
				List<item> cart = new ArrayList<item>();

				cart.add(new item(p, 1));
				session.setAttribute("cart", cart);

			} else {

				List<item> cart = (List<item>) session.getAttribute("cart");
				int index = isExisting(id, cart);
				if (index == -1) {
					cart.add(new item(p, 1));

				} else {
					int quantity = cart.get(index).getQuantity() + 1;
					cart.get(index).setQuantity(quantity);
				}
				session.setAttribute("cart", cart);
			}
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}

		else if (action.equals("delete")) {

			List<item> cart = (List<item>) session.getAttribute("cart");
			int index1 = isExisting(id, cart);
			cart.remove(index1);
			session.setAttribute("cart", cart);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
	}

	private int isExisting(int id, List<item> cart) {

		for (int i = 0; i < cart.size(); i++) {

			if (cart.get(i).getP().getId() == id) {
				return i;
			}
		}
		return -1;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {


		
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		if(action.equalsIgnoreCase("update"))
		{
			
			
			List<item> cart=(List<item>) session.getAttribute("cart");
			String quantity[]=request.getParameterValues("quantity");
			for (int i = 0; i < cart.size() ; i++) {
				
				cart.get(i).setQuantity(Integer.parseInt(quantity[i]));
				
				
			}
			session.setAttribute("cart", cart);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
			}

}
