package cn.com.cisec.cheyoumei.server.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.cisec.cheyoumei.server.dao.ICarBrandDao;
import cn.com.cisec.cheyoumei.server.model.CarBrand;
@Repository
public class CarBrandDao extends BaseDao<CarBrand> implements ICarBrandDao{
	@Override
	public Integer findIdByCarBrand(String carbrand) {
		String sql ="select c.id from CarBrand c where c.brand ='"+carbrand+"'";
		System.out.println("sql:"+sql);
		Integer carBrandId = findIdByXXXX(sql);
		return carBrandId;
	}

	@Override
	public boolean findIdByCarPlateNum(String plateNum) {
		String sql ="select c.plateNum from UsrCar c where c.plateNum ='"+plateNum+"'";
		Boolean plateNumName = findPlateNumByNum(sql);
		return plateNumName;
	}

}
