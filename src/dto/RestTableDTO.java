package dto;
public class RestTableDTO {

    private int tableNo;

    private String restId;

    private String tableName;

    private String tableState;

    private int tableX;

    private int tableY;

    private int tableW;

    private int tableH;

    private int tableType;

    private int perCount;

    private String tableComment;

	public RestTableDTO(int tableNo, String restId, String tableName, String tableState, int tableX, int tableY,
			int tableW, int tableH, int tableType, int perCount, String tableComment) {
		super();
		this.tableNo = tableNo;
		this.restId = restId;
		this.tableName = tableName;
		this.tableState = tableState;
		this.tableX = tableX;
		this.tableY = tableY;
		this.tableW = tableW;
		this.tableH = tableH;
		this.tableType = tableType;
		this.perCount = perCount;
		this.tableComment = tableComment;
	}

	public int getTableNo() {
		return tableNo;
	}

	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableState() {
		return tableState;
	}

	public void setTableState(String tableState) {
		this.tableState = tableState;
	}

	public int getTableX() {
		return tableX;
	}

	public void setTableX(int tableX) {
		this.tableX = tableX;
	}

	public int getTableY() {
		return tableY;
	}

	public void setTableY(int tableY) {
		this.tableY = tableY;
	}

	public int getTableW() {
		return tableW;
	}

	public void setTableW(int tableW) {
		this.tableW = tableW;
	}

	public int getTableH() {
		return tableH;
	}

	public void setTableH(int tableH) {
		this.tableH = tableH;
	}

	public int getTableType() {
		return tableType;
	}

	public void setTableType(int tableType) {
		this.tableType = tableType;
	}

	public int getPerCount() {
		return perCount;
	}

	public void setPerCount(int perCount) {
		this.perCount = perCount;
	}

	public String getTableComment() {
		return tableComment;
	}

	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
    
	
}