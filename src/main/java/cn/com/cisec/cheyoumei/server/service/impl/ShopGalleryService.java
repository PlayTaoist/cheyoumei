package cn.com.cisec.cheyoumei.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.dao.IShopGalleryDao;
import cn.com.cisec.cheyoumei.server.service.IShopGalleryService;
@Service
public class ShopGalleryService implements IShopGalleryService {
	
	@Autowired
	private IShopGalleryDao iShopGalleryDao;
	
	@Override
	public String findShopGalleryUrl(int shopInfo_id) {
		String ShopGalleryUrl = iShopGalleryDao.findShopGalleryUrl(shopInfo_id);
		return ShopGalleryUrl;
	}

}
