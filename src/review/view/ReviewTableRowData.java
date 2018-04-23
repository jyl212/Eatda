package review.view;

public class ReviewTableRowData {
	private String menuName;
	private int reveiewPoint;
	private String review;
	
	public ReviewTableRowData(String menuName, int reveiewPoint, String review) {
		super();
		this.menuName = menuName;
		this.reveiewPoint = reveiewPoint;
		this.review = review;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getReveiewPoint() {
		return reveiewPoint;
	}

	public void setReveiewPoint(int reveiewPoint) {
		this.reveiewPoint = reveiewPoint;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "ReviewTableRowData [menuName=" + menuName + ", reveiewPoint=" + reveiewPoint + ", review=" + review
				+ "]";
	}
	
	

}
