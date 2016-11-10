package cn.com.cisec.cheyoumei.server.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * @类名: User 
 * @描述: 用户表 
 * @作者 liuren-mail@163.com
 * @日期 2015年6月4日 下午4:38:29
 */
@Entity
public class User {
	@Column(length=4)
	private int id; //id
	private String mobilePhone; //手机号
	private String userName; //用户名
	private String firm;       //单位名称(/商店名称)
	private String payPwd;  //支付密码
	private int point; //积分点
	private double balance; //余额
	private String loginPwd; //手机登陆密码
	private String logoUrl;  //头像的Url
	private String gender;   //性别
	private String addr;  //用户地址信息
	private int totalRase; //星级
	private int raseCount; //评价次数
	private boolean isActived; //是否激活
	private boolean isOnline; //是否在线
	private boolean isdeleted; //是否被删除
	private Date lastLogin;  //最后一次登陆时间
	private Date createdAt;  //注册当前时间
	private Date deletedAt;  //删除时间
	private int deletedByUserId; //被用户删除
	private Role role;   //角色
	
	public static final String ID = "id";
	public static final String MOBLIEPHONE = "mobliePhone";
	public static final String USERNAME = "username";
	public static final String LOGOURL = "logoUrl";
	public static final String BALANCE = "balance";
	public User() {
		super();
	}
	
	
	public User(String userName, String loginPwd) {
		super();
		this.userName = userName;
		this.loginPwd = loginPwd;
	}


	@OneToOne(fetch=FetchType.EAGER)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getPayPwd() {
		return payPwd;
	}
	public void setPayPwd(String payPwd) {
		this.payPwd = payPwd;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isActived() {
		return isActived;
	}
	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	public boolean isIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	public int getDeletedByUserId() {
		return deletedByUserId;
	}
	public void setDeletedByUserId(int deletedByUserId) {
		this.deletedByUserId = deletedByUserId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
    
}
