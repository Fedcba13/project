package model.vo;

import java.io.Serializable;
import java.util.Date;

public class Payment extends Item implements Serializable{
	
	Date payDate;
	
	public Payment() {
		super();
	}
	
	public Payment(Item item, Date payDate) {
		super(item);
		this.payDate = payDate;
	}


}
