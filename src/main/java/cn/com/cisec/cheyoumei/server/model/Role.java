package cn.com.cisec.cheyoumei.server.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	private int id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 角色的权限
	 */
	private  Set<Resource> resources;
	
	public Role() {
		super();
	}
	public Role(String name, String description, Set<Resource> resources) {
		super();
		this.name = name;
		this.description = description;
		this.resources = resources;
	}
	@Id
	@GeneratedValue
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
	@ManyToMany(fetch=FetchType.EAGER)
	public Set<Resource> getResources() {
		return resources;
	}
	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}
	
	
}
