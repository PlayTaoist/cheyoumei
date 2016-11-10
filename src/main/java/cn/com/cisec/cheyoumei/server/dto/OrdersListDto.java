package cn.com.cisec.cheyoumei.server.dto;

import java.util.Date;

import cn.com.cisec.cheyoumei.server.model.Goods;
import cn.com.cisec.cheyoumei.server.model.PaymentForm;
import cn.com.cisec.cheyoumei.server.model.User;

public class OrdersListDto {
	
	private int id;
	private String orderCode;       //订单号
	private int payStatus;          //支付状态
	private String tradeNum;        //交易号
	private int orderStatus;        //订单状态
	private String fromAccount;     //支付的账号
	private String shopName;        //店铺名称
	private double accountRecv;     //应付款
	private double totalRecv;        //已付款
	private int serverType;         //订单服务类型(0.到店;1.上门;)
	private int point; ////消费获取的积分
	private String couponCode; //优惠券
	private double discount;    //折扣率
	private double totalReturn;      //退款额
	private Date payAt;            //支付的时间
	private boolean customerConfirm; //消费者确认
	private boolean shopConfirm; //商户确认
	private Date createdAt;        //订单创建时间
	private Date scheduleAt;       //预约时间
	private Date servicedAt;       //享受服务时间
	private Date updatedAt;        //更新时间
	private int userByUpdatedBy;//操作员
	private int paymentForm; //支付方式信息
	private String address; //地址信息
	private int seller; //卖家
	private int customer;//买家ID
	private int goods;  //所购商品id  
	private String serviceName;   //服务名称
	private String shopGalleryUrl; //可用的店铺的封面图片
	private boolean iscomment;
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
	public int getServerType() {
		return serverType;
	}
	public void setServerType(int serverType) {
		this.serverType = serverType;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
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
	public double getTotalReturn() {
		return totalReturn;
	}
	public void setTotalReturn(double totalReturn) {
		this.totalReturn = totalReturn;
	}
	public Date getPayAt() {
		return payAt;
	}
	public void setPayAt(Date payAt) {
		this.payAt = payAt;
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
	public Date getServicedAt() {
		return servicedAt;
	}
	public void setServicedAt(Date servicedAt) {
		this.servicedAt = servicedAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public int getUserByUpdatedBy() {
		return userByUpdatedBy;
	}
	public void setUserByUpdatedBy(int userByUpdatedBy) {
		this.userByUpdatedBy = userByUpdatedBy;
	}
	public int getPaymentForm() {
		return paymentForm;
	}
	public void setPaymentForm(int paymentForm) {
		this.paymentForm = paymentForm;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSeller() {
		return seller;
	}
	public void setSeller(int seller) {
		this.seller = seller;
	}
	public int getCustomer() {
		return customer;
	}
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	public int getGoods() {
		return goods;
	}
	public void setGoods(int goods) {
		this.goods = goods;
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
