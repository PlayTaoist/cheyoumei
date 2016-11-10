package cn.com.cisec.cheyoumei.server.model;

// Generated 2015-6-2 14:50:26 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @类名: GoodsGallery 
 * @描述: 产品图片信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:26:23
 */
@Entity
public class GoodsGallery implements Serializable {

	private int id;
	private String url;       //产品的多个图片
	private boolean isActived;  
	private boolean isCover;
	private Date createdAt;  //创建时间
	private Date updatedAt;  //修改时间
	private User user;
	private Goods goods;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public boolean isActived() {
		return isActived;
	}
	public void setActived(boolean isActived) {
		this.isActived = isActived;
	}
	public boolean isCover() {
		return isCover;
	}
	public void setCover(boolean isCover) {
		this.isCover = isCover;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne(fetch=FetchType.EAGER)
	public Goods getGoods() {
		return goods;
	}
	
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
    
}
