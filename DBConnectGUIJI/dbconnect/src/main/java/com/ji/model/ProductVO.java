package com.ji.model;

/**
 * @author JI
 *
 */

public class ProductVO {
	private String prodNo;
	private String prodName;
	private int invertory;
	private int price;
	private String manzufacturer;
	
	public ProductVO() {
		
	}
	
	public ProductVO(String prodNo, String prodName, int invertory, int price, String manzufacturer) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.invertory = invertory;
		this.price = price;
		this.manzufacturer = manzufacturer;
	}

	public String getProdNo() {
		return prodNo;
	}

	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getInvertory() {
		return invertory;
	}

	public void setInvertory(int invertory) {
		this.invertory = invertory;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getManzufacturer() {
		return manzufacturer;
	}

	public void setManzufacturer(String manzufacturer) {
		this.manzufacturer = manzufacturer;
	}

	@Override
	public String toString() {
		return "ProductVO [prodNo=" + prodNo + ", prodName=" + prodName + ", invertory=" + invertory + ", price="
				+ price + ", manzufacturer=" + manzufacturer + "]";
	}
	
	
	
}
