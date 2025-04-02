package com.ssd.service;

import java.util.List;

import com.ssd.Dao.CartDao;
import com.ssd.Dto.CartDto;

public class cartServices {
	
	
	CartDao Dao = new CartDao();
	
	public List<CartDto> getAllProductsBYCartList (List<CartDto> oldCartList){
		return Dao.getAllProducts(oldCartList);
		
	}

	
	public void saveCart(List<CartDto> cartList,Integer uId) {
		Dao.saveCartData(cartList, uId);
	}
	
	public List<CartDto>  getCartListBYUserId(Integer uId) {
		
		return Dao.getCartList(uId);
		
	}
	
	public void removeCrtListByUserId(Integer uId){
		Dao.revomeCartListByUserId(uId);
	}


   }
