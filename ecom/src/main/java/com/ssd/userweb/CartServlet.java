package com.ssd.userweb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssd.Dto.CartDto;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<CartDto> oldCartList =(List<CartDto>)
				request.getSession().getAttribute("oldCartList");
		
           Integer productId = Integer.valueOf(request.getParameter("id"));
           
           System.out.println(productId);
           
           CartDto cartdto = new CartDto();
           List<CartDto> cartList = new ArrayList<>();
           if(oldCartList != null && oldCartList.size()>0) {
        	   cartList = oldCartList;
        	   for(CartDto product:cartList) {
        		   if(product.getId()== productId) {
        			   response.sendRedirect ("Alret.jsp");
        			   return;
        		   }
        	   }
        		   cartdto.setId(productId);
            	   cartdto.setQuantity(1);
            	   
                    cartList.add(cartdto);
            	HttpSession  session= request.getSession();
            	session.setAttribute("oldCartList", cartList);
            	
        	  
           }else {
        	   cartdto.setId(productId);
        	   cartdto.setQuantity(1);
        	   cartList.add(cartdto);
        	HttpSession  session= request.getSession();
        	session.setAttribute("oldCartList", cartList);
        	
           }request.getRequestDispatcher("ProductServlet").forward(request, response);
           
           System.out.println(cartList);
	}
	

}
