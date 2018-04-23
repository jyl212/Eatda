package dto;

import java.sql.Date;

public class RestOrderDTO {

    private int orderNo;

    private String restId;

    private int tableNo;

    private Date orderDate;

    private int orderPrice;

	public RestOrderDTO(int orderNo, String restId, int tableNo, Date orderDate, int orderPrice) {
		super();
		this.orderNo = orderNo;
		this.restId = restId;
		this.tableNo = tableNo;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
    
    
}