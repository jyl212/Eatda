package dto;
public class OrderDetailDTO {

    private int orderNo;

    private int menuNo;

    private int menuCount;

	public OrderDetailDTO(int orderNo, int menuNo, int menuCount) {
		super();
		this.orderNo = orderNo;
		this.menuNo = menuNo;
		this.menuCount = menuCount;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public int getMenuCount() {
		return menuCount;
	}

	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}
    
    
}