package com.ssd.service;

import java.util.List;

import com.ssd.Dao.ProductDao;
import com.ssd.Dto.ProductDto;

public class ProductService {
	
	
		ProductDao Productdao = new ProductDao();
	
	
	public List<ProductDto> getAllProducts(){
		return Productdao.getAllProducts();
		
		
	
	}
}

