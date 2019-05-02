package model.vo;

public class Item {

	private String itemName;
	private int itemPrice; // 가격
	private int itemAmount;
	private String itemOrigin;
	private String itemCategory;// 예 : 닭 소 양 돼지 등
	private String itemCategory2; // 예 : 등심 다리 등

	public Item(String itemName, int itemPrice,int itemAmount, String itemOrigin, String itemCategory, String itemCategory2) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemAmount = itemAmount;
		this.itemOrigin = itemOrigin;
		this.itemCategory = itemCategory;
		this.itemCategory2 = itemCategory2;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	

	public int getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getItemOrigin() {
		return itemOrigin;
	}

	public void setItemOrigin(String itemOrigin) {
		this.itemOrigin = itemOrigin;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public String getItemCategory2() {
		return itemCategory2;
	}

	public void setItemCategory2(String itemCategory2) {
		this.itemCategory2 = itemCategory2;
	}

}
