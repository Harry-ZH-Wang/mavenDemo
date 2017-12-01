package com.lovo.beans;

public class CommodityBean {
	
	private Long id;
	
	private String commodityName;
	
	private String commodityPrice;
	
	private Long shopId;

	public CommodityBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommodityBean(Long id, String commodityName, String commodityPrice,
			Long shopId) {
		super();
		this.id = id;
		this.commodityName = commodityName;
		this.commodityPrice = commodityPrice;
		this.shopId = shopId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(String commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	@Override
	public String toString() {
		return "CommodityBean [id=" + id + ", commodityName=" + commodityName
				+ ", commodityPrice=" + commodityPrice + ", shopId=" + shopId
				+ "]";
	}
	
	

}
