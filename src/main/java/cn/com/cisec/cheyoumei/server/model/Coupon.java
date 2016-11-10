package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * @类名: Coupon 
 * @描述: 优惠券 
 * @作者 liuren-mail@163.com
 * @日期 2015年6月4日 下午7:37:56
 */
@Entity
public class Coupon implements Serializable{
	
	private int id;
	private String couponCode;
	private double amount;
	private Date useAt;
	private Date beforAt;
	private int isUsed;
	private User user;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getUseAt() {
		return useAt;
	}
	public void setUseAt(Date useAt) {
		this.useAt = useAt;
	}
	public Date getBeforAt() {
		return beforAt;
	}
	public void setBeforAt(Date beforAt) {
		this.beforAt = beforAt;
	}
	public int getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	@OneToOne(fetch=FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
