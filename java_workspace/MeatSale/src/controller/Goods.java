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

import model.vo.Customer;
import model.vo.Item;
import view.MainFrame;

public class Goods {

	ArrayList<Item> itemArr;
	String fileUrl = "data/item.ser";

	public Goods() {
		
		//파일이 있는지 확인 후 없으면 기본값 넣기.
		File file = new File(fileUrl);
		
		boolean isExists = file.exists();
		
		if(!isExists) {
			try (FileOutputStream fos = new FileOutputStream(fileUrl);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos)) {
				
				itemArr = new ArrayList<Item>();
				itemArr.add(new Item("호주산 소 등심", 3000, 10, "호주", "소", "등심"));
				itemArr.add(new Item("돼지 삼겹살", 2500, 17, "호주", "돼지", "등심"));
				itemArr.add(new Item("횡성 꽃등심", 5000, 30, "한국", "소", "꽃등심"));
				itemArr.add(new Item("호주 양 갈비", 8200, 22, "호주", "양", "갈비"));
				itemArr.add(new Item("닭 한마리", 7200, 82, "한국", "닭", "전체"));

				oos.writeObject(itemArr);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		itemArr = new ArrayList<Item>();

		readCustomer();
		
	}

	public void addItem(Item c) {// 상품 추가

		itemArr.add(c);

		saveFile();

	}// addCustomer() 끝
	
	public void saveFile() {
		try (FileOutputStream fos = new FileOutputStream(fileUrl);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {

			oos.writeObject(itemArr);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readCustomer() {// 회원 정보 불러오기.

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
	
	public void setCustomer(Item c) {
		
		String id = c.getItemName();
		int index = -1;
		
		for(int i = 0; i<itemArr.size(); i++) {
			if(itemArr.get(i).getItemName().equals(id)) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
			itemArr.set(index, c);
		}	
		
		saveFile();
		
	}

}
