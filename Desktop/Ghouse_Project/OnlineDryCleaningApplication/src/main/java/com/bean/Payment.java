package com.bean;



import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*********************************************************************************************
 *          @author         G. Anvesh
 *          Description     It is an entity class that has various data members
 *         	Version         1.0
 *         	Created Date    23 MARCH 2021
 *********************************************************************************************/

@Entity
public class Payment {
	@Id
	private long paymentId;
	private String type;
	private String status;
	
	@Embedded
	private Card card;
	

	public Payment() {
		super();
	}

	public Payment(long paymentId, String type, String status, Card card) {
		super();
		this.paymentId = paymentId;
		this.type = type;
		this.status = status;
		this.card = card;

	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", type=" + type + ", status=" + status + ", card=" + card + "]";
	}

}
