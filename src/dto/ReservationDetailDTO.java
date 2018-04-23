package dto;
public class ReservationDetailDTO {

    private int reserNo;

    private int menuNo;

    private int menuCount;

	public ReservationDetailDTO(int reserNo, int menuNo, int menuCount) {
		super();
		this.reserNo = reserNo;
		this.menuNo = menuNo;
		this.menuCount = menuCount;
	}

	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
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