package com.ssd.userweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.CartDto;
import com.ssd.Dto.UserDto;
import com.ssd.service.cartServices;

/**
 * Servlet implementation class LogoutServlet
 */
@jakarta.servlet.annotation.WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	List<CartDto> OldcartList=	(List<CartDto>) request.getSession().getAttribute("oldCartList");
		
		UserDto  userdto =(UserDto) request.getSession().getAttribute("user");
		
		if(userdto==null) {
			response.sendRedirect("Login.jsp");
			return;
		}
		
		cartServices service = new cartServices();
		if(OldcartList!=null && OldcartList.size()>0) {
			service.saveCart(OldcartList, userdto.getId());
			
			service.removeCrtListByUserId(userdto.getId());
		}
		request.getSession().removeAttribute("oldCartList");
		request.getSession().removeAttribute("user");
		response.sendRedirect("Login.jsp");

	}

}
