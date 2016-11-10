package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @类名: UsrCategory 
 * @描述: 用户角色信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:45:23
 */
@Entity
public class UsrCategory implements Serializable {

	private int id;
	private String category;
	private String description;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
