package cn.com.cisec.cheyoumei.server.model;
import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @类名: ShopGallery 
 * @描述: 商店图片信息 
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:39:00
 */
@Entity
public class ShopGallery implements Serializable {

	private int id;
	private String url;         //图片的Url
	private boolean isActived;  //是否激活图片
	private boolean isCover;    //封面
	private boolean isLicense;  //是否营业执照
	private Date createdAt;     //创建时间
	private Date updatedAt;     //更新时间
	private ShopInfo shopInfo;
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
	public boolean isLicense() {
		return isLicense;
	}
	public void setLicense(boolean isLicense) {
		this.isLicense = isLicense;
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
	public ShopInfo getShopInfo() {
		return shopInfo;
	}
	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}

}
