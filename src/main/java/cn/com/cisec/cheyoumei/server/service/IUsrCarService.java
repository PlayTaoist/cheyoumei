package cn.com.cisec.cheyoumei.server.service;

import java.util.List;

public interface IUsrCarService {

	String addUsrCar(String plateNum, String carColor, Integer userid_id,
			String carBrandName,String carbrand);

	List findUsrCar(Integer userid_id);

	void updateUsrCar(Integer id, String plateNum, String carColor,
			String carSeries,String carBrandName);

	void delUsrCar(Integer id);

	void modifyUsrCarInfoToFalse(Integer id);

	void modifyUsrCarInfoToTrue(int carId);
}
