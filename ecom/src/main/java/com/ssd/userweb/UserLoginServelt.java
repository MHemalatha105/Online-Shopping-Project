package com.ssd.userweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssd.Dto.CartDto;
import com.ssd.Dto.UserDto;
import com.ssd.service.UserService;
import com.ssd.service.cartServices;

/**
 * Servlet implementation class UserServelt
 */
@jakarta.servlet.annotation.WebServlet("/User")
public class UserLoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			UserService userService = new UserService();

			UserDto dto = new UserDto();

			dto.setEmailId(request.getParameter("EmailId"));
			dto.setPassword(request.getParameter("Password"));
			

			dto = userService.loginUser(dto);

			if (dto == null) {
				
				request.getRequestDispatcher("Login.jsp").forward(request, response);

			} else {
				cartServices service = new cartServices();
				List<CartDto> cartLIsts=service.getCartListBYUserId(dto.getId());
				
				request.getSession().setAttribute("user", dto);

				request.getSession().setAttribute("oldCartList", cartLIsts);

				
				HttpSession session = request.getSession();
				
				session.setAttribute("user", dto);
				
				request.getRequestDispatcher("/ProductServlet").forward(request, response);
				
				System.out.println(dto);

			}

		} catch (Exception e) {
			
		}
		

}}

