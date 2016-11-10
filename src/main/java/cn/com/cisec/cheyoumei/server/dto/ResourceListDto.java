package cn.com.cisec.cheyoumei.server.dto;
/**
 * 前端用于列举权限的dto
 * @author fu
 *
 */
public class ResourceListDto {
	private int id;
	private String name;
	private String url;
	private String description;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
