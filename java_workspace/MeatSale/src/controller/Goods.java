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
				itemArr.add(new Item(1, "국내산 소 안심", 3000, 10, "한국", "소", "안심", 2, "images/국내산 소 안심.gif"));
				itemArr.add(new Item(2, "국내산 닭가슴살", 2500, 4, "한국", "닭", "닭가슴살", 3, "images/닭가슴살.gif"));
				itemArr.add(new Item(3, "미국산 닭가슴살", 5200, 6, "미국", "닭", "닭가슴살", 2, "images/닭가슴살.gif"));
				itemArr.add(new Item(4, "브라질산 닭 날개/윙", 7000, 20, "브라질", "닭", "날개/윙", 1, "images/닭날개윙.gif"));
				itemArr.add(new Item(5, "국내산 목등심", 5900, 7, "한국", "소", "등심", 3, "images/소 목 등심 국내산.gif"));
				itemArr.add(new Item(6, "국내산 돼지 앞다리살", 3600, 7, "한국", "돼지", "앞다리", 2, "images/앞다리살 제육용.gif"));
				itemArr.add(new Item(7, "국내산 양 숄더랙", 9000, 24, "한국", "양", "어깨", 2, "images/양 숄더랙.gif"));
				itemArr.add(new Item(8, "국내산 양 갈비", 10000, 19, "한국", "양", "갈비", 4, "images/양갈비.gif"));
				itemArr.add(new Item(9, "국내산 양 삼겹살", 3000, 10, "한국", "양", "갈비", 1, "images/양삼겹살.gif"));
				itemArr.add(new Item(10, "호주산 와규 치맛살", 6200, 11, "호주", "소", "채끝살", 2, "images/와규 치맛살.gif"));
				itemArr.add(new Item(11, "국내산 돼지 가브리살", 4000, 6, "한국", "돼지", "등심", 2, "images/한돈 가브리살.gif"));
				itemArr.add(new Item(12, "국내산 소 등심", 6000, 0, "한국", "소", "등심", 2, "images/소 목 등심 국내산.gif"));
				itemArr.add(new Item(13, "국내산 소 등심 기름 제거", 5000, 2, "한국", "소", "등심", 2, "images/호주산 소 부채살.gif"));
				itemArr.add(new Item(14, "국내산 소 목 등심", 5500, 3, "한국", "소", "등심", 2, "images/호주산 와규.gif"));
				itemArr.add(new Item(15, "호주산 소 등심", 3000, 8, "호주", "소", "등심", 2, "images/소 목 등심 국내산.gif"));
				itemArr.add(new Item(16, "호주산 소 목 등심", 6600, 10, "호주", "소", "등심", 2, "images/국내산 소 안심.gif"));
				itemArr.add(new Item(17, "국내산 등심", 7000, 30, "한국", "소", "등심", 2, "images/와규 치맛살.gif"));
				itemArr.add(new Item(18, "호주산 등심", 6000, 70, "호주", "소", "등심", 2, "images/한돈 항정살.gif"));

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
