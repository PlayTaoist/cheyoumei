package cn.com.cisec.cheyoumei.server.dto;

public class RoleListDto {
	private int id;
	private String name;
	private String resources;
	private String description;
	
	public RoleListDto(int id, String name, String resources, String description) {
		super();
		this.id = id;
		this.name = name;
		this.resources = resources;
		this.description = description;
	}
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
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
