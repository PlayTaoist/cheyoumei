package cn.com.cisec.cheyoumei.server.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IShopGalleryDao;
import cn.com.cisec.cheyoumei.server.model.ShopGallery;
@Repository
public class ShopGalleryDao extends BaseDao<ShopGallery> implements IShopGalleryDao {

	@Override
	public String findShopGalleryUrl(int shopInfo_id) {
		String sql = "select s.url from ShopGallery s where s.actived=1 and s.cover=1 and s.license=0 and s.shopInfo_id="+shopInfo_id;
		//findShopGalleryUrl(sql);
		String ShopGalleryUrl =findTitleByParentId(sql);
		System.out.println("ShopGalleryUrl:"+ShopGalleryUrl);
		return ShopGalleryUrl;
	}


}
