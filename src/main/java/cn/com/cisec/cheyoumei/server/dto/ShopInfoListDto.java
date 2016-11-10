package cn.com.cisec.cheyoumei.server.dto;

public class ShopInfoListDto {
	private int id;
	private String addr;
	private String shopName;//店名
	private int totalRase;
	private int user_id;
	private String url;
	private double discPrice;
	private int goodsId;
	private String goodsName;
	
	public ShopInfoListDto() {
		super();
	}
	public ShopInfoListDto(int id, String addr, String shopName,int totalRase, int user_id,
			String url, double discPrice,int goodsId,String goodsName) {
		super();
		this.id = id;
		this.addr = addr;
		this.shopName = shopName;
		this.totalRase = totalRase;
		this.user_id = user_id;
		this.url = url;
		this.discPrice = discPrice;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public int getTotalRase() {
		return totalRase;
	}
	public void setTotalRase(int totalRase) {
		this.totalRase = totalRase;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public double getDiscPrice() {
		return discPrice;
	}
	public void setDiscPrice(double discPrice) {
		this.discPrice = discPrice;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
}
