package cn.com.cisec.cheyoumei.server.dao;

import cn.com.cisec.cheyoumei.server.model.ShopGallery;

public interface IShopGalleryDao extends IBaseDao<ShopGallery> {

	String findShopGalleryUrl(int shopInfo_id);

}
