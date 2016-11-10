package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @类名: Zappinfo 
 * @描述: App存放的信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:48:00
 */
@Entity
public class Zappinfo implements Serializable {

	private int id;       
	private String version;  //版本号
	private String name;    // 名称
	private String sysSupport; //适用系统
	private String url;        //存放位置
	private long dlTimes;    //下载次数
	private String dlMac;    //下载终端的Mac
	private String dlIp;     //下载终端的IP
	private Date createdAt; //创建时间
	private User user;      //创建者id
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSysSupport() {
		return sysSupport;
	}
	public void setSysSupport(String sysSupport) {
		this.sysSupport = sysSupport;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getDlTimes() {
		return dlTimes;
	}
	public void setDlTimes(long dlTimes) {
		this.dlTimes = dlTimes;
	}
	public String getDlMac() {
		return dlMac;
	}
	public void setDlMac(String dlMac) {
		this.dlMac = dlMac;
	}
	public String getDlIp() {
		return dlIp;
	}
	public void setDlIp(String dlIp) {
		this.dlIp = dlIp;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
