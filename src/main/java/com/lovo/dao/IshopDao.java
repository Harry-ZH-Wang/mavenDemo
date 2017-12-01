package com.lovo.dao;

import java.util.List;

import com.lovo.beans.CommodityBean;
import com.lovo.beans.ShopBean;

/**
 * 商品持久层
 * @author WZH
 *
 */
public interface IshopDao {

	/**
	 * 商店添加商品，商品和商店本来应该是多对多，这里做一对多单边测试
	 * @param shop
	 * @return
	 */
	public int shopAddCommodities(ShopBean shop);
	
	/**
	 * 添加商品
	 * @param commodity
	 * @return
	 */
	public int addCommodity(List<CommodityBean> commodites);
	
	
	public List<ShopBean> findShopByName(ShopBean shop);
	
	public List<CommodityBean> getCommById(Long id);
}
