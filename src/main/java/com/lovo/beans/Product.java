package com.lovo.beans;

import java.io.Serializable;

/**
 * 测试用简单商品类
 * @author WZH
 *
 */
public class Product implements Serializable{

	private static final long serialVersionUID = 5801648617772990983L;
	
	//商品id
	private Long id;
	//商品名
	private String name;
	//商品价格
	private double price;
	//厂商
	private String factory;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long id, String name, double price, String factory) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.factory = factory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price
				+ ", factory=" + factory + "]";
	}
	
}
