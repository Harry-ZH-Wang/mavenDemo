package com.lovo.beans;

import java.util.List;

public class ShopBean {
	
	private Long id;
	
	private String shopName;

	private List<CommodityBean> commodities;

	public ShopBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopBean(Long id, String shopName, List<CommodityBean> commodities) {
		super();
		this.id = id;
		this.shopName = shopName;
		this.commodities = commodities;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public List<CommodityBean> getCommodities() {
		return commodities;
	}

	public void setCommodities(List<CommodityBean> commodities) {
		this.commodities = commodities;
	}

	@Override
	public String toString() {
		return "ShopBean [id=" + id + ", shopName=" + shopName
				+ ", commodities=" + commodities + "]";
	}

}
