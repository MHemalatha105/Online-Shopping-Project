package org.ssd.SpringJpa.dto;

import org.ssd.SpringJpa.entity.OrderEntity;
import org.ssd.SpringJpa.entity.PaymentEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private OrderEntity order;
    private PaymentEntity payment;


}
