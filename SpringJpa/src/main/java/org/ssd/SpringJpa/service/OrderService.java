package org.ssd.SpringJpa.service;

import org.ssd.SpringJpa.dto.OrderRequest;
import org.ssd.SpringJpa.dto.OrderResponse;


public interface OrderService  {
  
	

    OrderResponse placeOrder(OrderRequest orderRequest);

}
