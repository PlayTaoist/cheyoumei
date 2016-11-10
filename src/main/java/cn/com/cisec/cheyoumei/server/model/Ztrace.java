package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @类名: Ztrace 
 * @描述: 交易信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:49:57
 */
public class Ztrace implements Serializable {

	private int id;
	private String name;  //交易名称
	private String description; //具体描述
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
