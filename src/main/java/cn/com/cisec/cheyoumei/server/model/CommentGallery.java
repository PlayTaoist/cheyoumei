package cn.com.cisec.cheyoumei.server.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * 评论图片 
 * @author zhanggq
 *
 */
@Entity
public class CommentGallery implements Serializable {

	private int id;
	private Comment comment;   //评论
	private String url;        //图片的url
	private boolean isActived; //是否激活图片(是否审核通过)
	private boolean isCover;   //封面
	private Date createdAt;    //创建时间
	private Date updatedAt; //更新时间
	@ManyToOne(fetch=FetchType.EAGER)
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
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
	

}
