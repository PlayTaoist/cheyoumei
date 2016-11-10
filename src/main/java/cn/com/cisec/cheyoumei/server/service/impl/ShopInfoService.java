package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.dao.IShopInfoDao;
import cn.com.cisec.cheyoumei.server.dto.GoodsCatRelDto;
import cn.com.cisec.cheyoumei.server.dto.GoodsDto;
import cn.com.cisec.cheyoumei.server.service.IShopInfoService;
@Service
public class ShopInfoService implements IShopInfoService {
	@Autowired
	private IShopInfoDao iShopInfoDao;
	
	@Override
	public Object findWashCarShops(String city, int limitStart, int pageSize) {
		return iShopInfoDao.findShopInfos(city,limitStart,pageSize);
	}

	@Override
	public Integer findGoosCatId(Integer id) {
		return iShopInfoDao.findGoodsCatId(id);
	}

	@Override
	public List<GoodsCatRelDto> findGoosCatRel(Integer ids) {
		return iShopInfoDao.findGoodsCatRel(ids);
	}

	@Override
	public String findTitleByparentId(int parent_id) {
		return iShopInfoDao.findTitleByParentId(parent_id);
	}

	@Override
	public List<GoodsDto> findGoodsNameById(Integer id) {
		return iShopInfoDao.findGoodsName(id);
	}

}
