package cn.com.cisec.cheyoumei.server.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @类名: Orders 
 * @描述: 订单详情
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:29:14
 */
@Entity
public class Orders implements Serializable {

	private int id;
	private String orderCode;       //订单号
	private int payStatus;          //支付状态
	private String tradeNum;        //交易号
	private int orderStatus;        //订单状态
	private String fromAccount;     //支付的账号
	private String shopName;        //商店名
	private double accountRecv;     //应付款
	private double totalRecv;        //已付款
	private int serverType;         //订单服务类型(0.到店;1.上门;)
	private int point; ////消费获取的积分
	private String couponCode; //优惠券
	private double discount;    //折扣率
	private double totalReturn;      //退款额
	private Date payAt;            //支付的时间
	private boolean customerConfirm; //消费者确认
	private boolean shopConfirm; //商户确认(暂时不做商户确认)
	private Date createdAt;        //订单创建时间
	private Date scheduleAt;       //预约时间
	private Date servicedAt;       //享受服务时间
	private Date updatedAt;        //更新时间
	private String serviceName;   //服务名称
	private String shopGalleryUrl; //可用的店铺的封面图片
	private boolean iscomment;    //是否评论过该订单
	private User userByUpdatedBy;//操作员
	private PaymentForm paymentForm; //支付方式信息
	private String address; //地址信息
	private User seller; //卖家
	private User customer;//买家ID
	private Goods goods;  //所购商品id   
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderCode() {
		return orderCode;
	}
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	public String getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}
	public double getAccountRecv() {
		return accountRecv;
	}
	public void setAccountRecv(double accountRecv) {
		this.accountRecv = accountRecv;
	}
	public double getTotalRecv() {
		return totalRecv;
	}
	public void setTotalRecv(double totalRecv) {
		this.totalRecv = totalRecv;
	}
	public double getTotalReturn() {
		return totalReturn;
	}
	public void setTotalReturn(double totalReturn) {
		this.totalReturn = totalReturn;
	}
	public int getServerType() {
		return serverType;
	}
	public void setServerType(int serverType) {
		this.serverType = serverType;
	}
	public Date getPayAt() {
		return payAt;
	}
	public void setPayAt(Date payAt) {
		this.payAt = payAt;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getScheduleAt() {
		return scheduleAt;
	}
	public void setScheduleAt(Date scheduleAt) {
		this.scheduleAt = scheduleAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)
	public PaymentForm getPaymentForm() {
		return paymentForm;
	}
	public void setPaymentForm(PaymentForm paymentForm) {
		this.paymentForm = paymentForm;
	}
	@JsonIgnore
	@OneToOne(fetch=FetchType.LAZY)
	public User getUserByUpdatedBy() {
		return userByUpdatedBy;
	}
	public void setUserByUpdatedBy(User userByUpdatedBy) {
		this.userByUpdatedBy = userByUpdatedBy;
	}
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	public User getCustomer() {
		return customer;
	}
	public void setCustomer(User customer) {
		this.customer = customer;
	}
	public int getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(int payStatus) {
		this.payStatus = payStatus;
	}
	public String getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(String tradeNum) {
		this.tradeNum = tradeNum;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public boolean isCustomerConfirm() {
		return customerConfirm;
	}
	public void setCustomerConfirm(boolean customerConfirm) {
		this.customerConfirm = customerConfirm;
	}
	public boolean isShopConfirm() {
		return shopConfirm;
	}
	public void setShopConfirm(boolean shopConfirm) {
		this.shopConfirm = shopConfirm;
	}
	public Date getServicedAt() {
		return servicedAt;
	}
	public void setServicedAt(Date servicedAt) {
		this.servicedAt = servicedAt;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getShopGalleryUrl() {
		return shopGalleryUrl;
	}
	public void setShopGalleryUrl(String shopGalleryUrl) {
		this.shopGalleryUrl = shopGalleryUrl;
	}
	public boolean isIscomment() {
		return iscomment;
	}
	public void setIscomment(boolean iscomment) {
		this.iscomment = iscomment;
	}
	
}
