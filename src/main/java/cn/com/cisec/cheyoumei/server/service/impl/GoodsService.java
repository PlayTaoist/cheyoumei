package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.dao.IGoodsDao;
import cn.com.cisec.cheyoumei.server.model.Goods;
import cn.com.cisec.cheyoumei.server.service.IGoodsService;
@Service
public class GoodsService implements IGoodsService{
	private final static Logger log = Logger.getLogger(GoodsService.class);
	@Autowired
	private IGoodsDao iGoodsDao;
	@Override
	public Goods findGoodsById(int goodId) {
		return iGoodsDao.load(goodId);
	}
	@Override
	public List<Integer> findGoods(String shopId) {
		return iGoodsDao.findGoods(shopId);
	}
}
