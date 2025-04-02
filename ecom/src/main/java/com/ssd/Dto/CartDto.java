package com.ssd.Dto;

public class CartDto extends ProductDto{
	
	public int quantity;
	
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartDto(int id, String name, String category, Double price, String image, int quantity) {
		super(id, name, category, price, image);
		this.quantity = quantity;
	}

	public CartDto(int id, String name, String category, Double price, String image) {
		super(id, name, category, price, image);
	}

public CartDto() {
	super();	
	}

}
