package com.ssd.userweb;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.OrdersDto;
import com.ssd.Dto.UserDto;
import com.ssd.service.OrderService;

/**
 * Servlet implementation class ProductMainBUYservlet
 */
@jakarta.servlet.annotation.WebServlet("/ProductMainBUYservlet")
public class ProductMainBUYservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		UserDto user = (UserDto) request.getSession().getAttribute("user");

		if (user == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		LocalDate oDate = LocalDate.now();

		Date date = Date.valueOf(oDate);

		Integer produtId = Integer.valueOf(request.getParameter("id"));

		Integer noOrders = Integer.valueOf(request.getParameter("quantity"));

		Integer uId = user.getId();
		
		OrdersDto orderDto = new OrdersDto();
		orderDto.setId(produtId);
		orderDto.setUserId(uId);
		orderDto.setNoofOrders(noOrders);
		orderDto.setOrderDate(date);
		
		OrderService oService = new OrderService();
		
		oService.placeYourOrder(orderDto);
		
		request.getRequestDispatcher("/ProductServlet").forward(request, response);

      System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"+uId);
	}

}
