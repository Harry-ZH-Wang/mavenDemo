package com.lovo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lovo.beans.ShopBean;
import com.lovo.dao.IshopDao;
import com.lovo.service.IshopService;

@Service("shopServiceImpl")
public class ShopService implements IshopService {

	@Autowired
	@Qualifier(value="shopDaoImpl")
	private IshopDao shopDaoImpl;
	
	@Override
	public int shopAddCommodities(ShopBean shop) {
		// TODO Auto-generated method stub
		
		shopDaoImpl.shopAddCommodities(shop);
		shopDaoImpl.addCommodity(shop.getCommodities());
		return 0;
	}

	@Override
	public List<ShopBean> findShopByName(ShopBean shop) {
		// TODO Auto-generated method stub
		return shopDaoImpl.findShopByName(shop);
	}

}
