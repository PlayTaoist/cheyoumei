package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * @类名: GoodsCatRel 
 * @描述: TODO(这里用一句话描述这个类的作用) 
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:24:39
 */
@Entity
public class GoodsCatRel implements Serializable {

	private int id;
	private GoodsCat child;//下级ID
	private GoodsCat parent;//上级ID
	private int level;//深度
	@ManyToOne(fetch=FetchType.EAGER)
	public GoodsCat getChild() {
		return child;
	}
	public void setChild(GoodsCat child) {
		this.child = child;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	public GoodsCat getParent() {
		return parent;
	}
	public void setParent(GoodsCat parent) {
		this.parent = parent;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	

}
