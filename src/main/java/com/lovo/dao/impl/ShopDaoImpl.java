package com.lovo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.lovo.beans.CommodityBean;
import com.lovo.beans.ShopBean;
import com.lovo.dao.IshopDao;
import com.lovo.mapper.ShopMapper;

@Repository("shopDaoImpl")
public class ShopDaoImpl implements IshopDao{
	
	
	@Resource
	private ShopMapper shopMapper;

	public int shopAddCommodities(ShopBean shop) {
		// TODO Auto-generated method stub
		return shopMapper.shopAddCommodities(shop);
	}
	@Override
	public int addCommodity(List<CommodityBean> commodites) {
		// TODO Auto-generated method stub
		return shopMapper.addCommodity(commodites);
	}
	@Override
	public List<ShopBean> findShopByName(ShopBean shop) {
		// TODO Auto-generated method stub
		return shopMapper.findShopByName(shop);
	}
	@Override
	public List<CommodityBean> getCommById(Long id) {
		// TODO Auto-generated method stub
		return shopMapper.getCommById(id);
	}

}
