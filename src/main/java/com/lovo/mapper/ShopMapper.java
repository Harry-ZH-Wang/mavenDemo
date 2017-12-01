package com.lovo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lovo.beans.CommodityBean;
import com.lovo.beans.ShopBean;

public interface ShopMapper {
	
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
	
	public List<ShopBean> findShopByName(@Param("shop") ShopBean shop);
	
	public List<CommodityBean> getCommById(@Param("selectid")Long id);

}
