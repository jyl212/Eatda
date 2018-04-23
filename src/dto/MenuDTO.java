package dto;
public class MenuDTO {

    private int menuNo;

    private String restId;

    private String menuName;

    private int menuPrice;

    private String menuDetail;

    private String menuType;

    private String menuImg;

	public MenuDTO(int menuNo, String restId, String menuName, int menuPrice, String menuDetail, String menuType,
			String menuImg) {
		super();
		this.menuNo = menuNo;
		this.restId = restId;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuDetail = menuDetail;
		this.menuType = menuType;
		this.menuImg = menuImg;
	}

	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuDetail() {
		return menuDetail;
	}

	public void setMenuDetail(String menuDetail) {
		this.menuDetail = menuDetail;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuImg() {
		return menuImg;
	}

	public void setMenuImg(String menuImg) {
		this.menuImg = menuImg;
	}

	@Override
	public String toString() {
		return "MenuDTO [menuNo=" + menuNo + ", restId=" + restId + ", menuName=" + menuName + ", menuPrice="
				+ menuPrice + ", menuDetail=" + menuDetail + ", menuType=" + menuType + ", menuImg=" + menuImg + "]";
	}
    
    
}