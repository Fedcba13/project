package model.vo;

import java.io.Serializable;

public class Item implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int itemNum;
	private String itemName;
	private int itemPrice; // 가격
	private int itemAmount;
	private String itemOrigin;
	private String itemCategory;// 예 : 닭 소 양 돼지 등
	private String itemCategory2; // 예 : 등심 다리 등
	private int deliver; // 배송 기간 예) 2, 3 2일 3일
	private String itemImageUrl; // 아이템 이미지

	public Item() {

	}

	public Item(int itemNum, String itemName, int itemPrice, int itemAmount, String itemOrigin, String itemCategory,
			String itemCategory2, int deliver, String itemImageUrl) {
		this.itemNum = itemNum;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemAmount = itemAmount;
		this.itemOrigin = itemOrigin;
		this.itemCategory = itemCategory;
		this.itemCategory2 = itemCategory2;
		this.deliver = deliver;
		this.itemImageUrl = itemImageUrl;
	}

	public Item(Item item) {
		this.itemNum = item.itemNum;
		this.itemName = item.itemName;
		this.itemPrice = item.itemPrice;
		this.itemAmount = item.itemAmount;
		this.itemOrigin = item.itemOrigin;
		this.itemCategory = item.itemCategory;
		this.itemCategory2 = item.itemCategory2;
		this.deliver = item.deliver;
		this.itemImageUrl = item.itemImageUrl;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
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

	public int getDeliver() {
		return deliver;
	}

	public void setDeliver(int deliver) {
		this.deliver = deliver;
	}

	public String getItemImageUrl() {
		return itemImageUrl;
	}

	public void setItemImageUrl(String itemImageUrl) {
		this.itemImageUrl = itemImageUrl;
	}

	@Override
	public String toString() {
		return "Item [itemNum=" + itemNum + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemAmount="
				+ itemAmount + ", itemOrigin=" + itemOrigin + ", itemCategory=" + itemCategory + ", itemCategory2="
				+ itemCategory2 + ", deliver=" + deliver + ", itemImageUrl=" + itemImageUrl + "]";
	}

}
