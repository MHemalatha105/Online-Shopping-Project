package org.ssd.SpringJpa.ServiceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ssd.SpringJpa.dto.OrderRequest;
import org.ssd.SpringJpa.dto.OrderResponse;
import org.ssd.SpringJpa.entity.OrderEntity;
import org.ssd.SpringJpa.entity.PaymentEntity;
import org.ssd.SpringJpa.exception.PaymentException;
import org.ssd.SpringJpa.repository.OrderRepository;
import org.ssd.SpringJpa.repository.PaymentRepository;
import org.ssd.SpringJpa.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderRepository orderRepository;

	@Autowired
	public PaymentRepository paymentRepository;

	@Override
	@Transactional
	public OrderResponse placeOrder(OrderRequest orderRequest) {
		
		OrderEntity orderEntity = orderRequest.getOrder();

		orderEntity.setStatus("INPROGRESS");

		orderEntity.setOrderTackingNumber(UUID.randomUUID().toString());
		
	

		orderEntity =orderRepository.save(orderEntity);

		PaymentEntity paymentEntity = orderRequest.getPayment();
		
		if(!paymentEntity.getType().equalsIgnoreCase("DEBIT")){
            throw new PaymentException("because The Type Of Payment Your Selected IsNot Availble","Payment Declined");
		
		}
		 paymentEntity.setOrderId(orderEntity.getId());
         paymentRepository.save(paymentEntity);
         
         OrderResponse orderResponse = new OrderResponse();
         orderResponse.setOrderTackingNumber(orderEntity.getOrderTackingNumber());
         
         orderResponse.setStatus(orderEntity.getStatus());
         orderResponse.setMessage("ORDER IS PLACED");

		return orderResponse;
		}
 }
