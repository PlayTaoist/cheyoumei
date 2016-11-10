package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.log4j.Logger;
/**
 * @类名: ZusrLog 
 * @描述: 用户操作日志信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:50:25
 */
@Entity
public class ZusrLog implements Serializable {
	
	private int id;
	private String tableName; //表名
	private int row;       //行Id
	private String operationCommand; //操作命令
	private String operationName;  //操作的名称(增删改查)
	private String detail; //批处理命令存储
	private String remoteMac;  //存储操作的Mac地址
	private String remoteIp;   //存储操作的ip地址
	private Date createdAt;    //操作的时间
	private User user;       //操作员id
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getRemoteMac() {
		return remoteMac;
	}
	public void setRemoteMac(String remoteMac) {
		this.remoteMac = remoteMac;
	}
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getOperationCommand() {
		return operationCommand;
	}
	public void setOperationCommand(String operationCommand) {
		this.operationCommand = operationCommand;
	}
	public String getOperationName() {
		return operationName;
	}
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
}
