package com.ssd.userweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.CartDto;

/**
 * Servlet implementation class RemoveProductServlett
 */
@jakarta.servlet.annotation.WebServlet("/RemoveProductServlet")
public class RemoveProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
List<CartDto> CartList  =  (List<CartDto>) request.getSession().getAttribute("oldCartList");
		
		Integer productId = Integer.valueOf(request.getParameter("id"));
		int index =0;
          for(CartDto dto : CartList) {
			
			if(dto.getId()==productId) {
				
				index= CartList.indexOf(dto);
			}
			CartList.remove(index);

			double toatlPrice = 0.0;
			for(CartDto Dto:CartList) {
				toatlPrice = toatlPrice + dto.getPrice();
			}
			request.setAttribute("toatlPrice", toatlPrice);
			
			request.getSession().setAttribute("oldCartList", CartList);
			
			request.getRequestDispatcher("Cart.jsp").forward(request, response);

	}
	}
}
