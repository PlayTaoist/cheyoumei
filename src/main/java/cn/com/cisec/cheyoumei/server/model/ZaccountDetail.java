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
 * @类名: ZaccountDetail 
 * @描述: TODO(这里用一句话描述这个类的作用) 
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:47:37
 */
@Entity
public class ZaccountDetail implements Serializable {

	private int id;
	private String account;  //另一方账号
	private String rechargeNum; //流水号
	private double amount;  //金额
	private boolean isSuccess; //是否成功
	private Date createdAt;   //创建时间 
	private PaymentForm paymentForm; //转账id
	private int access; //操作
	private Orders order;  //订单id
	private User user;     //用户id
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	public PaymentForm getPaymentForm() {
		return paymentForm;
	}
	public void setPaymentForm(PaymentForm paymentForm) {
		this.paymentForm = paymentForm;
	}
	@OneToOne(fetch=FetchType.EAGER)
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRechargeNum() {
		return rechargeNum;
	}
	public void setRechargeNum(String rechargeNum) {
		this.rechargeNum = rechargeNum;
	}
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	


}
