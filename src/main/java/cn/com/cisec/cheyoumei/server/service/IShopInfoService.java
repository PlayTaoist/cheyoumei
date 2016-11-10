package cn.com.cisec.cheyoumei.server.service;

import java.util.List;

import cn.com.cisec.cheyoumei.server.dto.GoodsCatRelDto;
import cn.com.cisec.cheyoumei.server.dto.GoodsDto;

public interface IShopInfoService {

	Object findWashCarShops(String city, int limitStart, int pageSize);

	Integer findGoosCatId(Integer id);

	List<GoodsCatRelDto> findGoosCatRel(Integer ids);

	String findTitleByparentId(int parent_id);

	List<GoodsDto> findGoodsNameById(Integer id);

}
