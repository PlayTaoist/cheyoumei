package cn.com.cisec.cheyoumei.server.model;

// Generated 2015-6-2 14:50:26 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * @类名: UsrCar 
 * @描述: 用户车辆信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:44:35
 */
@Entity
public class UsrCar implements Serializable {

	private int id;
	private boolean defaultOne;  //是否默认
	private Date createdAt;     //创建时间
	private String plateNum;    //车牌号
	private boolean isDeleted;  //是否删除
	private String carColor;    //车辆颜色
	private String carSeries;   //车品牌的型号
	private CarBrand carBrand; //车辆品牌
	private User userid;//用户id
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDefaultOne() {
		return defaultOne;
	}
	public void setDefaultOne(boolean defaultOne) {
		this.defaultOne = defaultOne;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public String getCarColor() {
		return carColor;
	}
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getCarSeries() {
		return carSeries;
	}
	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	public CarBrand getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(CarBrand carBrand) {
		this.carBrand = carBrand;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	public User getUserid() {
		return userid;
	}
	public void setUserid(User userid) {
		this.userid = userid;
	}
	


}
