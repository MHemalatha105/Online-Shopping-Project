package com.ssd.userweb;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.CartDto;
import com.ssd.Dto.OrdersDto;
import com.ssd.Dto.UserDto;
import com.ssd.service.OrderService;

/**
 * Servlet implementation class OrderServlet
 */
@jakarta.servlet.annotation.WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		UserDto user = (UserDto) request.getSession().getAttribute("user");
		
		List<CartDto> newCartList = (List<CartDto>) request.getSession().getAttribute("oldCartList");

		if(user==null) {
			response.sendRedirect("Login.jsp");
			return;
		}


		LocalDate orderId = LocalDate.now();
		
		Date date = Date.valueOf(orderId);
		
		Integer produtId = Integer.valueOf(request.getParameter("id"));
		
		Integer NoOfOrders = Integer.valueOf(request.getParameter("quantity"));
		
		Integer uId =user.getId();
		
		OrdersDto orderDto = new OrdersDto();
	
		
		orderDto.setId(produtId);
		orderDto.setUserId(uId);
		orderDto.setNoofOrders(NoOfOrders);
		orderDto.setOrderDate(date);
		
		OrderService orderservice = new OrderService();
		
		orderservice.placeYourOrder(orderDto);
		int index =0;
		for(CartDto dto:newCartList) {
			if(dto.getId()==produtId);
			index=newCartList.indexOf(dto);	
		}
		newCartList.remove(index);
		
		if(newCartList.size()>0) {
			request.getSession().setAttribute("oldCartList", newCartList);
			request.getRequestDispatcher("/CheckoutServlet").forward(request, response);
		}else {
    
		request.getSession().setAttribute("oldCartList", newCartList);
		request.getRequestDispatcher("/ProductServlet").forward(request, response);
		}
	}

}
