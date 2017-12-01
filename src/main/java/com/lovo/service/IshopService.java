package com.lovo.service;

import java.util.List;

import com.lovo.beans.ShopBean;

public interface IshopService {
	/**
	 * 商店添加商品，商品和商店本来应该是多对多，这里做一对多单边测试
	 * @param shop
	 * @return
	 */
	public int shopAddCommodities(ShopBean shop);
	
	public List<ShopBean> findShopByName(ShopBean shop);
}
