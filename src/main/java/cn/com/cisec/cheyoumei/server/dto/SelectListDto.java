package cn.com.cisec.cheyoumei.server.dto;
/**
 * 前端用于选择的dto
 * @author fu
 *
 */
public class SelectListDto {
	/**
	 * 显示的字段
	 */
	private String boxLabel;
	/**
	 * 名次
	 */
	private String name;
	/**
	 * 选中的值，即资源的ID
	 */
	private int inputValue;
	/**
	 * 是否被选中
	 */
	private boolean checked;
	public String getBoxLabel() {
		return boxLabel;
	}
	public void setBoxLabel(String boxLabel) {
		this.boxLabel = boxLabel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getInputValue() {
		return inputValue;
	}
	public void setInputValue(int inputValue) {
		this.inputValue = inputValue;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public SelectListDto(String boxLabel, String name, int inputValue,
			boolean checked) {
		super();
		this.boxLabel = boxLabel;
		this.name = name;
		this.inputValue = inputValue;
		this.checked = checked;
	}
	
}
