package dto;

import java.sql.Date;

public class PaymentDTO {

    private int paymentNo;

    private String memId;

    private int orderNo;
    
    private int reserNo;

    private Date paymentDate;

    private int totalPrice;

    private String paymentType;

	public PaymentDTO(int paymentNo, String memId, int orderNo, int reserNo, Date paymentDate, int totalPrice,
			String paymentType) {
		super();
		this.paymentNo = paymentNo;
		this.memId = memId;
		this.orderNo = orderNo;
		this.reserNo = reserNo;
		this.paymentDate = paymentDate;
		this.totalPrice = totalPrice;
		this.paymentType = paymentType;
	}

	public int getPaymentNo() {
		return paymentNo;
	}

	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "PaymentDTO [paymentNo=" + paymentNo + ", memId=" + memId + ", orderNo=" + orderNo + ", reserNo="
				+ reserNo + ", paymentDate=" + paymentDate + ", totalPrice=" + totalPrice + ", paymentType="
				+ paymentType + "]";
	}
    
    
}