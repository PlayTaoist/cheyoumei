package cn.com.cisec.cheyoumei.server.dao;

import java.util.List;

import cn.com.cisec.cheyoumei.server.model.Goods;

public interface IGoodsDao extends IBaseDao<Goods>{

	List<Integer> findGoods(String shopId);

}
