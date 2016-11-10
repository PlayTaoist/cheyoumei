package cn.com.cisec.cheyoumei.server.dto;

public class GoodsDto {
	
	private int id;
	private String name;         //商品名字
	private double discPrice;   //折后价格
	
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
	public double getDiscPrice() {
		return discPrice;
	}
	public void setDiscPrice(double discPrice) {
		this.discPrice = discPrice;
	}
	
	
}
