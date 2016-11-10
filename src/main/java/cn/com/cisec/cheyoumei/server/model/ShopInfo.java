package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
/**
 * @类名: ShopInfo 
 * @描述: 商店信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月5日 上午11:55:55
 */
@Entity
public class ShopInfo implements Serializable{
	
	private int id;
	private String province;     //所在的省份
	private String city;         //所在的城市
	private String county;       //所在的城镇
	private String area;         //所在的区域
	private String street;       //所在的街道
	private String detail;       //所在的详细地址
	private String addr;         //详细地址
	private String shopName;     //店名
	private int totalRase;
	private int raseCount;
	private int type = 0;      //商品主要类型 0：洗车 1：汽车配件 2：代驾
	private User user;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getTotalRase() {
		return totalRase;
	}
	public void setTotalRase(int totalRase) {
		this.totalRase = totalRase;
	}
	public int getRaseCount() {
		return raseCount;
	}
	public void setRaseCount(int raseCount) {
		this.raseCount = raseCount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
