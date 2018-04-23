package dto;

import java.sql.Date;

public class PointListDTO {

    private int pointNo;

    private String memId;

    private String savepointRest;

    private int usePoint;

    private Date savepointDate;

	public PointListDTO(int pointNo, String memId, String savepointRest, int usePoint, Date savepointDate) {
		super();
		this.pointNo = pointNo;
		this.memId = memId;
		this.savepointRest = savepointRest;
		this.usePoint = usePoint;
		this.savepointDate = savepointDate;
	}

	public int getPointNo() {
		return pointNo;
	}

	public void setPointNo(int pointNo) {
		this.pointNo = pointNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getSavepointRest() {
		return savepointRest;
	}

	public void setSavepointRest(String savepointRest) {
		this.savepointRest = savepointRest;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public Date getSavepointDate() {
		return savepointDate;
	}

	public void setSavepointDate(Date savepointDate) {
		this.savepointDate = savepointDate;
	}
    
    
}