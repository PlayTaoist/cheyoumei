package cn.com.cisec.cheyoumei.server.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @类名: PhoneCode 
 * @描述: 存放手机验证码的功能
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:36:11
 */
@Entity
public class PhoneCode implements Serializable {

	private int id;
	private String mobliePhone; //手机号
	private String code;        //验证码
	private Date createdAt;  //创建时间
	private Date beforeAt;//有效时间
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobliePhone() {
		return mobliePhone;
	}
	public void setMobliePhone(String mobliePhone) {
		this.mobliePhone = mobliePhone;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getBeforeAt() {
		return beforeAt;
	}
	public void setBeforeAt(Date beforeAt) {
		this.beforeAt = beforeAt;
	}   
	
}
