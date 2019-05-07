package model.vo;

import java.io.Serializable;
import java.util.Date;

public class Payment extends Item implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id; //구매자 아이디
	Date payDate;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public Payment() {
		super();
	}
	
	public Payment(String id, Item item, Date payDate) {
		super(item);
		this.id = id;
		this.payDate = payDate;
	}

	@Override
	public String toString() {
		return "Payment [id = " + id + super.toString()+ "payDate=" + payDate + "]";
	}
	
	


}
