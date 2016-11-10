package cn.com.cisec.cheyoumei.server.service;

import java.util.List;

import cn.com.cisec.cheyoumei.server.model.Goods;

public interface IGoodsService {

	Goods findGoodsById(int goodId);

	List<Integer> findGoods(String shopId);

}
