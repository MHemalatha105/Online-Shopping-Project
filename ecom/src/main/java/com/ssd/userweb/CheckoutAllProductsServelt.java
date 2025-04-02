package com.ssd.userweb;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.CartDto;
import com.ssd.Dto.OrdersDto;
import com.ssd.Dto.UserDto;
import com.ssd.service.OrderService;

/**
 * Servlet implementation class CheckoutAllProductsServelt
 */
@WebServlet("/CheckoutAllProducts")
public class CheckoutAllProductsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutAllProductsServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<CartDto> CartList =  (List<CartDto>) request.getSession().getAttribute("oldCartList");
		
		UserDto user = (UserDto) request.getSession().getAttribute("user");
		
		if(user==null) {
			response.sendRedirect("login.jsp");
			return;
		}
         List<OrdersDto> orderList =new ArrayList<>();
		
		for(CartDto cartDto:CartList) {

		LocalDate orderDate = LocalDate.now();
		
		Date date = Date.valueOf(orderDate);
		
		OrdersDto OrderDto = new OrdersDto();
		
		OrderDto.setId(cartDto.getId());
		OrderDto.setUserId(user.getId());
		OrderDto.setNoofOrders(cartDto.getQuantity());
		OrderDto.setOrderDate(date);
		
		orderList.add(OrderDto);
		}
		CartList.clear();
		OrderService orderService = new OrderService();
		orderService.PlaceAllOrders(orderList);
		

		request.getRequestDispatcher("/ProductServlet").forward(request, response);

	}
}
