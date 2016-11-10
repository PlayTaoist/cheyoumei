package cn.com.cisec.cheyoumei.server.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.cisec.cheyoumei.server.dao.ICarBrandDao;
import cn.com.cisec.cheyoumei.server.dao.IUserDao;
import cn.com.cisec.cheyoumei.server.dao.IUsrCarDao;
import cn.com.cisec.cheyoumei.server.model.CarBrand;
import cn.com.cisec.cheyoumei.server.model.User;
import cn.com.cisec.cheyoumei.server.model.UsrCar;
import cn.com.cisec.cheyoumei.server.service.IUsrCarService;

@Service
public class UsrCarService implements IUsrCarService{
	
	@Autowired
	private IUsrCarDao iUsrCarDao;
	@Autowired
	private IUserDao userDao;
	@Autowired
	private ICarBrandDao iCarBrandDao;
	@Override
	public String addUsrCar(String plateNum, String carColor, Integer userid_id,
			String carBrandName,String carbrand) {
		UsrCar usrCar = new UsrCar();
		User user = userDao.load(userid_id);
		Integer carBrandId = iCarBrandDao.findIdByCarBrand(carBrandName);
		if (carBrandId==null||"".equals(carBrandId)) {
			CarBrand cBrand = new CarBrand();
			cBrand.setBrand(carBrandName);
			cBrand.setLogoUrl("upload/images/carBrand/noLogo.png");
			iCarBrandDao.add(cBrand);
			carBrandId = iCarBrandDao.findIdByCarBrand(carBrandName);
		}
		
		boolean  plateNumName = iCarBrandDao.findIdByCarPlateNum(plateNum);
		if (carBrandId==null||"".equals(carBrandId)||plateNumName) {
			System.out.println("plateNumName:车牌号已经存在"+plateNumName);
			return null;
		}
		CarBrand carBrand = iCarBrandDao.load(carBrandId);
		usrCar.setPlateNum(plateNum);
		usrCar.setCarColor(carColor);
		usrCar.setUserid(user);
		usrCar.setCarBrand(carBrand);
		Date createTime = new Date();
		usrCar.setCreatedAt(createTime);
		usrCar.setDefaultOne(false);
		usrCar.setCarSeries(carbrand);
		iUsrCarDao.add(usrCar);
		return carBrandName;
	}
	@Override
	public List findUsrCar(Integer userid_id) {
		List list = iUsrCarDao.findUsrCar(userid_id);
		return list;
	}
	@Override
	public void updateUsrCar(Integer id, String plateNum, String carColor,
			String carSeries,String carBrandName) {
		UsrCar usrCar = iUsrCarDao.load(id);
		Integer carBrandId = iCarBrandDao.findIdByCarBrand(carBrandName);
		CarBrand carBrand = iCarBrandDao.load(carBrandId);
		usrCar.setPlateNum(plateNum);
		usrCar.setCarColor(carColor);
		usrCar.setCarBrand(carBrand);
		usrCar.setCarSeries(carSeries);
		iUsrCarDao.update(usrCar);
	}
	@Override
	public void delUsrCar(Integer id) {
		iUsrCarDao.delete(id);
//		这个是伪善除代码
//		UsrCar usrCar = iUsrCarDao.load(id);
//		usrCar.setDeleted(true);
//		iUsrCarDao.update(usrCar);
	}
	@Override
	public void modifyUsrCarInfoToFalse(Integer id) {
		UsrCar usrCar = iUsrCarDao.load(id);
		usrCar.setCarBrand(usrCar.getCarBrand());
		usrCar.setCarColor(usrCar.getCarColor());
		usrCar.setCarSeries(usrCar.getCarSeries());
		usrCar.setDeleted(false);
		usrCar.setPlateNum(usrCar.getPlateNum());
		usrCar.setUserid(usrCar.getUserid());
		usrCar.setDefaultOne(false);
		iUsrCarDao.update(usrCar);
	}
	@Override
	public void modifyUsrCarInfoToTrue(int carId) {
		UsrCar usrCar = iUsrCarDao.load(carId);
		usrCar.setCarBrand(usrCar.getCarBrand());
		usrCar.setCarColor(usrCar.getCarColor());
		usrCar.setCarSeries(usrCar.getCarSeries());
		usrCar.setDeleted(false);
		usrCar.setPlateNum(usrCar.getPlateNum());
		usrCar.setUserid(usrCar.getUserid());
		usrCar.setDefaultOne(true);
		iUsrCarDao.update(usrCar);
	}
	
}
