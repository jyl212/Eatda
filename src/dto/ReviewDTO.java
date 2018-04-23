package dto;
public class ReviewDTO {

    private int reviewNo;

    private int menuNo;

    private int reviewPoint;

    private String onelineRev;

	public ReviewDTO(int reviewNo, int menuNo, int reviewPoint, String onelineRev) {
		super();
		this.reviewNo = reviewNo;
		this.menuNo = menuNo;
		this.reviewPoint = reviewPoint;
		this.onelineRev = onelineRev;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public int getReviewPoint() {
		return reviewPoint;
	}

	public void setReviewPoint(int reviewPoint) {
		this.reviewPoint = reviewPoint;
	}

	public String getOnelineRev() {
		return onelineRev;
	}

	public void setOnelineRev(String onelineRev) {
		this.onelineRev = onelineRev;
	}
    
    
}