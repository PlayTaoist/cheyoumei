package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
/**
 * @类名: Promotion 
 * @描述: 活动内容表
 * @作者 liuren-mail@163.com
 * @日期 2015年6月4日 下午7:34:48
 */
@Entity
public class Promotion implements Serializable {

	private int id;
	private String name;  //活动名称
	private Date startAt; //发起日期
	private Date endAt;   //结束日期
	private int type;     //活动类型
	private int requirement;
	private int awardType;  //奖励方式:0限时抢购 1减金额 2增积分 4赠送代金券 5赠送赠品 6免运费
	private double awardValue;   //奖励数值
	private String description; //活动描述
	private boolean isUsed;   //是否已经使用
	private User user;      //发起人(商家)
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartAt() {
		return startAt;
	}
	public void setStartAt(Date startAt) {
		this.startAt = startAt;
	}
	public Date getEndAt() {
		return endAt;
	}
	public void setEndAt(Date endAt) {
		this.endAt = endAt;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRequirement() {
		return requirement;
	}
	public void setRequirement(int requirement) {
		this.requirement = requirement;
	}
	public int getAwardType() {
		return awardType;
	}
	public void setAwardType(int awardType) {
		this.awardType = awardType;
	}
	public double getAwardValue() {
		return awardValue;
	}
	public void setAwardValue(double awardValue) {
		this.awardValue = awardValue;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isUsed() {
		return isUsed;
	}
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}
	
	
	
}
