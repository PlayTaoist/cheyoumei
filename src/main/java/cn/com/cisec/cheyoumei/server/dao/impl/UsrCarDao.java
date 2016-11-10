package cn.com.cisec.cheyoumei.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.IUsrCarDao;
import cn.com.cisec.cheyoumei.server.model.UsrCar;
@Repository
public class UsrCarDao extends BaseDao<UsrCar> implements IUsrCarDao {
	

	@Override
	public List findUsrCar(Integer userid_id) {
		String sql = "SELECT c.id AS id,u.logoUrl AS logoUrl,c.plateNum AS plateNum,c.carSeries AS carSeries,c.carColor AS carColor,c.defaultOne AS defaultOne FROM UsrCar c LEFT JOIN CarBrand u ON c.carBrand_id=u.id WHERE c.userid_id="+userid_id;
		List list =findUsrCarListDatas(sql);
		return list;
	}


}
