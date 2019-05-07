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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.vo.Item;
import model.vo.Payment;

public class Pay {

	private ArrayList<Payment> payArr;
	private String fileUrl = "data/buy.ser";

	public Pay() {

		// 파일이 있는지 확인 후 없으면 기본값 넣기.
		File file = new File(fileUrl);

		boolean isExists = file.exists();

		if (!isExists) {
			try (FileOutputStream fos = new FileOutputStream(fileUrl);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos)) {

				payArr = new ArrayList<Payment>();
				Calendar cal = new GregorianCalendar();
				cal.add(Calendar.DATE, -5);
				payArr.add(new Payment("123", new Item(1, "호주산 소 등심1", 3000, 10, "호주", "소", "등심", 2, "images/meat.jpg"), new Date(cal.getTimeInMillis())));
				payArr.add(new Payment("456", new Item(2, "돼지 삼겹살", 2500, 17, "호주", "돼지", "등심", 3, "images/meat.jpg"), new Date(cal.getTimeInMillis())));
				

				oos.writeObject(payArr);

			} catch (IOException e) {

			}
		}

		payArr = new ArrayList<Payment>();

		readItem();

	}

	public ArrayList<Payment> getPayments() {
		return payArr;
	}

	public void addPayment(Payment pay) {// 상품 추가

		payArr.add(pay);

		saveFile();

	}// addPayment() 끝

	public void saveFile() {
		try (FileOutputStream fos = new FileOutputStream(fileUrl);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {

			oos.writeObject(payArr);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readItem() {// 상품 정보 불러오기.

		try (FileInputStream fis = new FileInputStream(fileUrl);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis)) {

			// 저장된 ArrayList 읽어오기
			ArrayList<Payment> readItemArr = (ArrayList<Payment>) ois.readObject();

			payArr.addAll(readItemArr);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}// readPayment() 끝


}
