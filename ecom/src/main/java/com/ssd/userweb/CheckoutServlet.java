package com.ssd.userweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.CartDto;
import com.ssd.service.cartServices;

/**
 * Servlet implementation class CheckoutServlet
 */
@jakarta.servlet.annotation.WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		cartServices service = new cartServices();

		List<CartDto> CartList = (List<CartDto>) request.getSession().getAttribute("oldCartList");

		List<CartDto> NewcartList = service.getAllProductsBYCartList(CartList);
		
		double toatlPrice = 0.0;

		for (CartDto Dto : NewcartList) {
			toatlPrice = toatlPrice + Dto.getPrice();
		}

		request.setAttribute("toatlPrice", toatlPrice);
		request.getSession().setAttribute("oldCartList", NewcartList);

		request.getRequestDispatcher("Cart.jsp").forward(request, response);

	}

}
