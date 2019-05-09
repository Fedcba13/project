package controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import model.vo.Item;
import model.vo.Payment;
import view.manage.DeliverManagePanel;

public class dat {

	private ArrayList<Payment> payArr;
	private String fileUrl = "asd/asd.ser";

	public dat() {

		// 파일이 있는지 확인 후 없으면 기본값 넣기.

		payArr = new ArrayList<Payment>();

		readItem();

	}
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
