package model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String pw;
	private String addr;
	private Date birth;
	private ArrayList<Item> cart; // 장바구니

	public Customer(String id, String name, String pw, String addr, Date birth) {
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.addr = addr;
		this.birth = birth;
	}
	
	public Customer(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public ArrayList<Item> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Item> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", pw=" + pw + ", addr=" + addr + ", birth=" + birth
				+ ", cart=" + cart + "]";
	}
	
	

}
