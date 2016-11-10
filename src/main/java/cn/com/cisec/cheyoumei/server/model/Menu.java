package cn.com.cisec.cheyoumei.server.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("menu")
public class Menu extends Resource {
	private String ids;
	private String text;
	private String icon;
	private boolean expanded;
	private boolean leaf;
	
	private Set<Menu> childMenu;
	@OneToMany
	public Set<Menu> getChildMenu() {
		return childMenu;
	}
	public void setChildMenu(Set<Menu> childMenu) {
		this.childMenu = childMenu;
	}
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	
}
