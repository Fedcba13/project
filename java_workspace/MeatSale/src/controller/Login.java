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

import model.vo.Customer;
import view.MainFrame;

public class Login {

	ArrayList<Customer> customerArr;

	public Login() {
		
		//파일이 있는지 확인 후 없으면 기본값 넣기.
		File file = new File("data/customer.ser");
		
		boolean isExists = file.exists();
		
		if(!isExists) {
			try (FileOutputStream fos = new FileOutputStream("data/customer.ser");
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos)) {
				
				Calendar calendar = new GregorianCalendar(1994, 3, 22);
				customerArr = new ArrayList<Customer>();
				customerArr.add(new Customer("111", "김지민", "111", "서울시 강남구", new Date(calendar.getTimeInMillis()), "01048772366"));
				calendar = new GregorianCalendar(1991, 7, 15);
				customerArr.add(new Customer("222", "홍수현", "222", "서울시 관악구", new Date(calendar.getTimeInMillis()), "01012345678"));
				calendar = new GregorianCalendar(1996, 8, 12);
				customerArr.add(new Customer("333", "이예림", "333", "서울시 서초구", new Date(calendar.getTimeInMillis()), "01048231187"));

				oos.writeObject(customerArr);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		customerArr = new ArrayList<Customer>();

		readCustomer();
		
	}

	public void addCustomer(Customer c) {// 회원 추가

		customerArr.add(c);

		saveFile();

	}// addCustomer() 끝
	
	public void saveFile() {
		try (FileOutputStream fos = new FileOutputStream("data/customer.ser");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {

			oos.writeObject(customerArr);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readCustomer() {// 회원 정보 불러오기.

		try (FileInputStream fis = new FileInputStream("data/customer.ser");
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis)) {

			// 저장된 ArrayList 읽어오기
			ArrayList<Customer> readCustomerArr = (ArrayList<Customer>) ois.readObject();

			customerArr.addAll(readCustomerArr);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}// readCustomer() 끝

	// ID중복체크
	public boolean sameIdCheck(String id) {
		for (Customer c : customerArr) {
			if (c.getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
	
	//로그인 메소드
	//1: 로그인성공, 0: 아이디 없음, -1 : 비밀번호 오류
	public int login(Customer c) {
		
		for(Customer cu : customerArr) {
			if(cu.getId().equals(c.getId())) {
				if(cu.getPw().equals(c.getPw())) {
					MainFrame.user = cu;
					return 1;
				}else {
					return -1;
				}
			}
		}
		
		return 0;
		
	}
	
	public void setCustomer(Customer c) {
		
		String id = c.getId();
		int index = -1;
		
		for(int i = 0; i<customerArr.size(); i++) {
			if(customerArr.get(i).getId().equals(id)) {
				index = i;
				break;
			}
		}
		
		if(index != -1) {
			customerArr.set(index, c);
		}	
		
		saveFile();
		
	}

}
