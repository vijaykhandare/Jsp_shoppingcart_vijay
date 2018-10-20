package com.pojo;

public class item {


	
	
	private Product p=new Product();
	private int quantity;
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public item(Product p, int quantity) {
		super();
		this.p = p;
		this.quantity = quantity;
	}
	

}
