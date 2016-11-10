package cn.com.cisec.cheyoumei.server.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
/**
 * @类名: Goods 
 * @描述: 商品 
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:20:45
 */
@Entity
public class Goods implements Serializable {

	private int id;
	private double discount;     // 折扣率
	private String name;         //商品名字
	private String description;  //描述
	private double origPrice;   //原价格
	private double discPrice;   //折后价格
	private boolean isUsed;     //是否使用
	private Date createdAt;     //创建时间
	private Date updatedAt;     //更新时间
	private boolean isCritical;    //是不是主页产品(显示洗车价格)
	private int type = 0;      //商品主要类型 0：洗车 1：汽车配件 2：代驾
	private ShopInfo shopInfo;
	private User user;
	private GoodsCat goodsCat; 
	
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	public GoodsCat getGoodsCat() {
		return goodsCat;
	}

	public void setGoodsCat(GoodsCat goodsCat) {
		this.goodsCat = goodsCat;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getOrigPrice() {
		return origPrice;
	}
	public void setOrigPrice(double origPrice) {
		this.origPrice = origPrice;
	}
	public double getDiscPrice() {
		return discPrice;
	}
	public void setDiscPrice(double discPrice) {
		this.discPrice = discPrice;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	public ShopInfo getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}
	
	public boolean isCritical() {
		return isCritical;
	}
	public void setCritical(boolean isCritical) {
		this.isCritical = isCritical;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
