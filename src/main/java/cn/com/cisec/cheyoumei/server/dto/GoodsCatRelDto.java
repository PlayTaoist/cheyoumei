package cn.com.cisec.cheyoumei.server.dto;

public class GoodsCatRelDto {
	private int id;
	private int child;//下级ID
	private int parent;//上级ID
	private int level;//深度
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChild() {
		return child;
	}
	public void setChild(int child) {
		this.child = child;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
