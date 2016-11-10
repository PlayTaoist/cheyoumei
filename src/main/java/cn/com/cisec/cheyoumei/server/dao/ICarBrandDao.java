package cn.com.cisec.cheyoumei.server.dao;

import cn.com.cisec.cheyoumei.server.model.CarBrand;

public interface ICarBrandDao extends IBaseDao<CarBrand> {

	Integer findIdByCarBrand(String carbrand);

	boolean findIdByCarPlateNum(String plateNum);

}
