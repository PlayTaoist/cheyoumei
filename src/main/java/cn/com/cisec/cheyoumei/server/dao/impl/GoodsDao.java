package cn.com.cisec.cheyoumei.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IGoodsDao;
import cn.com.cisec.cheyoumei.server.model.Goods;
import cn.com.cisec.cheyoumei.server.model.User;
@Repository
public class GoodsDao extends BaseDao<Goods> implements IGoodsDao {

	@Override
	public List<Integer> findGoods(String shopId) {
		String sql = "select g.id as id from Goods g where g.shopInfo_id="+shopId;
		List<Integer> list = findIdList(sql);
		return list;
	}


}
