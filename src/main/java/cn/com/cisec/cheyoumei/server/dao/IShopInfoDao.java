package cn.com.cisec.cheyoumei.server.dao;

import java.util.List;

import cn.com.cisec.cheyoumei.server.dto.GoodsCatRelDto;
import cn.com.cisec.cheyoumei.server.dto.GoodsDto;
import cn.com.cisec.cheyoumei.server.model.ShopInfo;

public interface IShopInfoDao extends IBaseDao<ShopInfo>{

	Object findShopInfos(String city, int limitStart, int pageSize);

	Integer findGoodsCatId(Integer id);

	List<GoodsCatRelDto> findGoodsCatRel(Integer ids);

	String findTitleByParentId(int parent_id);

	List<GoodsDto> findGoodsName(Integer id);

}
