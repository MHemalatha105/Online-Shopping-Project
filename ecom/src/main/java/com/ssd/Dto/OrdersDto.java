package com.ssd.Dto;

import java.sql.Date;

public class OrdersDto extends ProductDto {
	//order_id, product_id, user_id, order_quantity, order_date
  public int orderId;
  public int userId;
  public int noofOrders;
  
  public Date orderDate;

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getNoofOrders() {
	return noofOrders;
}

public void setNoofOrders(int noofOrders) {
	this.noofOrders = noofOrders;
}

public Date getOrderDate() {
	return orderDate;
}

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}

public OrdersDto(int id, String name, String category, Double price, String image, int orderId, int userId,
		int noofOrders, Date orderDate) {
	super(id, name, category, price, image);
	this.orderId = orderId;
	this.userId = userId;
	this.noofOrders = noofOrders;
	this.orderDate = orderDate;
}

public OrdersDto(int id, String name, String category, Double price, String image, int userId, int noofOrders,
		Date orderDate) {
	super(id, name, category, price, image);
	this.userId = userId;
	this.noofOrders = noofOrders;
	this.orderDate = orderDate;
}


public OrdersDto() {
	
}

@Override
public String toString() {
	return "OrdersDto [orderId=" + orderId + ", userId=" + userId + ", noofOrders=" + noofOrders + ", orderDate="
			+ orderDate + "]";
}


}
