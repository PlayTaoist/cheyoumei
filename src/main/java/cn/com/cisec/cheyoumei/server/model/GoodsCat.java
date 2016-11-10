package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * @类名: GoodsCat 
 * @描述: 
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:23:14
 */
@Entity
public class GoodsCat implements Serializable {

	private int id;
	private String title;  //标题
	private int displayorder;//排序
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getDisplayorder() {
		return displayorder;
	}
	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	} 

	

}
