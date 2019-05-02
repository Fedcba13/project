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
import view.MainFrame;

public class Login {

	ArrayList<Customer> customerArr;

	public Login() {
		customerArr = new ArrayList<Customer>();
		File file = new File("data/customer.ser");
		
		boolean isExists = file.exists();
		
		if(!isExists) {
			try (FileOutputStream fos = new FileOutputStream("data/customer.ser");
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					ObjectOutputStream oos = new ObjectOutputStream(bos)) {

				oos.writeObject(customerArr);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		readCustomer();
	}

	public void addCustomer(Customer c) {// 회원 추가

		customerArr.add(c);

		try (FileOutputStream fos = new FileOutputStream("data/customer.ser");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos)) {

			oos.writeObject(customerArr);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}// addCustomer() 끝

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

}
