package cn.com.cisec.cheyoumei.server.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * @类名: ShopUsrMoreInfo 
 * @描述: 商店信息
 * @作者 liuren-mail@163.com
 * @日期 2015年6月2日 下午9:40:53
 */
@Entity
public class ShopUsrMoreInfo implements Serializable {

	private int id;
	private User user;
	private int shopCounts; //商店个数
	private double avgArea; //平均营业面积
	private int workerCount; //工人数量
	private String shopCat;   //商铺性质
	private int recommended = 0; //推荐(根据数字排序)
	private boolean hasCarPort;//是否有独立洗车位
	private boolean hasResting;//是否有休息室
	private String moreInfo;  //备注
	private Date createdAt;   //商店更多信息创建时间
	private int createdBy; // 创建者ID
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShopCounts() {
		return shopCounts;
	}
	public void setShopCounts(int shopCounts) {
		this.shopCounts = shopCounts;
	}
	public double getAvgArea() {
		return avgArea;
	}
	public void setAvgArea(double avgArea) {
		this.avgArea = avgArea;
	}
	
	public int getRecommended() {
		return recommended;
	}
	public void setRecommended(int recommended) {
		this.recommended = recommended;
	}
	public int getWorkerCount() {
		return workerCount;
	}
	public void setWorkerCount(int workerCount) {
		this.workerCount = workerCount;
	}
	public String getShopCat() {
		return shopCat;
	}
	public void setShopCat(String shopCat) {
		this.shopCat = shopCat;
	}
	public boolean isHasCarPort() {
		return hasCarPort;
	}
	public void setHasCarPort(boolean hasCarPort) {
		this.hasCarPort = hasCarPort;
	}
	public boolean isHasResting() {
		return hasResting;
	}
	public void setHasResting(boolean hasResting) {
		this.hasResting = hasResting;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}
	@OneToOne(fetch=FetchType.EAGER)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
