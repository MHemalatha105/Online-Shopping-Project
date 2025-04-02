package org.ssd.SpringJpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssd.SpringJpa.ServiceImpl.OrderServiceImpl;
import org.ssd.SpringJpa.dto.OrderRequest;
import org.ssd.SpringJpa.dto.OrderResponse;

@RestController
@RequestMapping("/api")
public class OrderController {

	
	@Autowired
	public OrderServiceImpl orderServiceImpl;
	
	@PostMapping("/order")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest){
		
	OrderResponse orderResponse =	orderServiceImpl.placeOrder(orderRequest);
	
	return new ResponseEntity<OrderResponse>(orderResponse,HttpStatus.CREATED);
	}
}
