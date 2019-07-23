package com.ji.model;

/**
 * @author JI
 *
 */

public class CusOrderVO {
	private String orderNo;
	private String orderCus;
	private String orderPro;
	private int quantity;
	private String address;
	private String orderDate;

	public CusOrderVO() {
		
	}

	public CusOrderVO(String orderNo, String orderCus, String orderPro, int quantity, String address,
			String orderDate) {
		super();
		this.orderNo = orderNo;
		this.orderCus = orderCus;
		this.orderPro = orderPro;
		this.quantity = quantity;
		this.address = address;
		this.orderDate = orderDate;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderCus() {
		return orderCus;
	}

	public void setOrderCus(String orderCus) {
		this.orderCus = orderCus;
	}

	public String getOrderPro() {
		return orderPro;
	}

	public void setOrderPro(String orderPro) {
		this.orderPro = orderPro;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "CusOrderVO [orderNo=" + orderNo + ", orderCus=" + orderCus + ", orderPro=" + orderPro + ", quantity="
				+ quantity + ", address=" + address + ", orderDate=" + orderDate + "]";
	}
	
	
}
