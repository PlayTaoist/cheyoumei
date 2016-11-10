package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @类名: PaymentForm 
 * @描述: 支付方式
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:34:53
 */
@Entity
public class PaymentForm implements Serializable {

	private int id;
	private String form;       //表单信息
	private String description;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} //表单描述
}
