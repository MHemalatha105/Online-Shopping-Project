package com.ssd.userweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.CartDto;

/**
 * Servlet implementation class IndAndDecServlet
 */
@jakarta.servlet.annotation.WebServlet("/IndAndDecServlet")
public class IndAndDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndAndDecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Action = request.getParameter("Action");
		
		Integer productsId = Integer.valueOf(request.getParameter("id"));
		
		List<CartDto> oldCartList = (List<CartDto>) request.getSession().getAttribute("oldCartList");

		
		System.out.println("Action......"+Action);
		
		System.out.println("productsId......"+productsId);
		
		int produtIndex = 0;
		for (CartDto cartDto : oldCartList) {

			if (cartDto.getId() == productsId) {
				produtIndex = oldCartList.indexOf(cartDto);
			}
		}
		CartDto newCartDto = new CartDto();

		CartDto dto = oldCartList.get(produtIndex);

		newCartDto.setId(dto.getId());
		newCartDto.setName(dto.getName());
		newCartDto.setCategory(dto.getCategory());
		newCartDto.setPrice(dto.getPrice());
		
		oldCartList.remove(produtIndex);
		
		if(Action.equals("inc")){
          newCartDto.setQuantity(dto.getQuantity()+1);
          
			
			oldCartList.add(produtIndex, newCartDto);

		}else {
			
			newCartDto.setQuantity(dto.getQuantity()-1);
			
			oldCartList.add(produtIndex, newCartDto);
			
		}
		request.getSession().setAttribute("oldCartList", oldCartList);

		

		request.getRequestDispatcher("/CheckoutServlet").forward(request, response);


		
	}

}
