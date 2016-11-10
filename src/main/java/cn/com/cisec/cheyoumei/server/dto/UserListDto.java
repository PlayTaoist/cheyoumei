package cn.com.cisec.cheyoumei.server.dto;

import java.util.Date;

import cn.com.cisec.cheyoumei.server.model.Role;


public class UserListDto {
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
	private String role;   //角色
	
	
	public UserListDto() {
		super();
	}
	public UserListDto(int id, String mobilePhone, String userName,
			String firm, String payPwd, int point, double balance,
			String loginPwd, String logoUrl, String gender, String addr,
			int totalRase, int raseCount, boolean isActived, boolean isOnline,
			boolean isdeleted, Date lastLogin, Date createdAt, Date deletedAt,
			int deletedByUserId, String role) {
		super();
		this.id = id;
		this.mobilePhone = mobilePhone;
		this.userName = userName;
		this.firm = firm;
		this.payPwd = payPwd;
		this.point = point;
		this.balance = balance;
		this.loginPwd = loginPwd;
		this.logoUrl = logoUrl;
		this.gender = gender;
		this.addr = addr;
		this.totalRase = totalRase;
		this.raseCount = raseCount;
		this.isActived = isActived;
		this.isOnline = isOnline;
		this.isdeleted = isdeleted;
		this.lastLogin = lastLogin;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.deletedByUserId = deletedByUserId;
		this.role = role;
	}
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
