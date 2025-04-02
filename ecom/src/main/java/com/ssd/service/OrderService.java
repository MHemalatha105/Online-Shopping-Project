package com.ssd.service;

import java.util.List;

import com.ssd.Dao.OrderDao;
import com.ssd.Dto.OrdersDto;

public class OrderService {
	
	public OrderDao dao = new OrderDao();
	public void placeYourOrder(OrdersDto dto) {
		dao.placeOrder(dto);

	}
	public void PlaceAllOrders(List<OrdersDto> orderList) {
		dao.placeAllOrders(orderList);
	}
}
