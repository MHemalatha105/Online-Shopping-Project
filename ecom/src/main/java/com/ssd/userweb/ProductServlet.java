package com.ssd.userweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssd.Dto.ProductDto;
import com.ssd.service.ProductService;

/**
 * Servlet implementation class ProductServlet
 */
@jakarta.servlet.annotation.WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		ProductService Productservice = new ProductService();
		List<ProductDto> AllproductList = Productservice.getAllProducts();
	
		
		
		
		request.setAttribute("AllproductList", AllproductList);
		request.getRequestDispatcher("Landing.jsp").forward(request, response);
		

	}

}
