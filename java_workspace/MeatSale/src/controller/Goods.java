package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.vo.Item;

public class Goods {

	private ArrayList<Item> itemArr;
	private String fileUrl = "data/item.ser";

	public Goods() {

		// 파일이 있는지 확인 후 없으면 기본값 넣기.
		File file = new File(fileUrl);

		boolean isExists = file.exists();

		if (!isExists) {
			try (FileOutputStream fos = new FileOutputStream(fileUrl);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos)) {

				itemArr = new ArrayList<Item>();
				itemArr.add(new Item(1, "호주산 소 등심1", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(2, "돼지 삼겹살", 2500, 17, "호주", "돼지", "등심", 3, "images/meat.jpg"));
				itemArr.add(new Item(3, "횡성 꽃등심", 5000, 30, "한국", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(4, "호주 양 갈비", 8200, 22, "호주", "양", "갈비", 5, "images/meat.jpg"));
				itemArr.add(new Item(5, "닭 한마리", 7200, 82, "한국", "닭", "전체", 2, "images/meat.jpg"));
				itemArr.add(new Item(6, "호주산 소 등심6", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(7, "호주산 소 등심7", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(8, "호주산 소 등심8", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(9, "호주산 소 등심9", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(10, "호주산 소 등심10", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(11, "호주산 소 등심11", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(12, "호주산 소 등심12", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(13, "호주산 소 등심13", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(14, "호주산 소 등심14", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(15, "호주산 소 등심15", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));
				itemArr.add(new Item(16, "호주산 소 등심16", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"));

				oos.writeObject(itemArr);

			} catch (IOException e) {

			}
		}

		itemArr = new ArrayList<Item>();

		readItem();

	}

	public ArrayList<Item> getItems() {
		return itemArr;
	}

	public ArrayList<Item> getItems(String cate1) {
		ArrayList<Item> tmpArr = (ArrayList<Item>) itemArr.clone();
		for (int i = 0; i < tmpArr.size(); i++) {
			if (!tmpArr.get(i).getItemCategory().equals(cate1)) {
				tmpArr.remove(i);
				i--;
			}
		}
		return tmpArr;
	}

	public ArrayList<Item> getItems(String cate1, String cate2) {

		ArrayList<Item> tmpArr = (ArrayList<Item>) itemArr.clone();
		for (int i = 0; i < tmpArr.size(); i++) {
			if (!(tmpArr.get(i).getItemCategory().equals(cate1) && tmpArr.get(i).getItemCategory2().equals(cate2))) {
				tmpArr.remove(i);
				i--;
			}
		}
		return tmpArr;

	}

	public void addItem(Item c) {// 상품 추가

		itemArr.add(c);

		saveFile();

	}// addItem() 끝
	
	public void removeItem(Item c) {
		
		int index = -1;
		
		for(int i=0; i<itemArr.size(); i++) {
			if(itemArr.get(i).getItemNum() == c.getItemNum()) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
			itemArr.remove(index);
		}
		
		saveFile();
		
	}

	public void saveFile() {
		try (FileOutputStream fos = new FileOutputStream(fileUrl);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {

			oos.writeObject(itemArr);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readItem() {// 상품 정보 불러오기.

		try (FileInputStream fis = new FileInputStream(fileUrl);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis)) {

			// 저장된 ArrayList 읽어오기
			ArrayList<Item> readItemArr = (ArrayList<Item>) ois.readObject();

			itemArr.addAll(readItemArr);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}// readCustomer() 끝

	public void setItem(Item c) {

		int id = c.getItemNum();
		int index = -1;

		for (int i = 0; i < itemArr.size(); i++) {
			if (itemArr.get(i).getItemNum() == id) {
				index = i;
				break;
			}
		}

		
		
		if (index != -1) {
			itemArr.set(index, c);
		}

		saveFile();

	}

	public int getMaxNum() {
		if (itemArr == null || itemArr.size() == 0) {
			return 1;
		} else {
			return itemArr.get(itemArr.size() - 1).getItemNum() + 1;
		}
	}

}
