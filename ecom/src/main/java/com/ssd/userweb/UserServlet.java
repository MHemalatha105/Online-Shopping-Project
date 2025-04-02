package com.ssd.userweb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.UserDto;
import com.ssd.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
@jakarta.servlet.annotation.WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserService userService = new UserService();
		try {
			UserDto dto = new UserDto();

			dto.setName(request.getParameter("Name"));
			dto.setEmailId(request.getParameter("EmailId"));
			dto.setMobileNo(Long.valueOf(request.getParameter("MobileNo")));
			dto.setPassword(request.getParameter("Password"));
			dto.setAddress(request.getParameter("Address"));

			userService.createuser(dto);

			request.getRequestDispatcher("Login.jsp").forward(request, response);
		} catch (

		Exception e) {
			// TODO: handle exception
		}
	}

	public void userLogin(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserService userService = new UserService();

			UserDto dto = new UserDto();

			dto.setEmailId(request.getParameter("EmailId"));
			dto.setPassword(request.getParameter("Password"));

			dto = userService.loginUser(dto);

			if (dto == null) {
				String contextPath = request.getContextPath();

				System.out.println("contextPath..." + contextPath);
				String servletPath = request.getServletPath();

				System.out.println("servletPath" + servletPath);
				System.out.print(request.getContextPath());
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			} else {
				
				request.getRequestDispatcher("Signup.jsp").forward(request, response);
				
			}

		} catch (Exception e) {
			
		}

	}
}
