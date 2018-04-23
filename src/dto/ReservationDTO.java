package dto;

import java.sql.Date;

public class ReservationDTO  implements Comparable {

    private int reserNo;

    private String memId;

    private int tableNo;

    private String restId;

    private Date reserDate;

    private String reserTime;

    private int reserPerson;

    private String reserName;

    private String reserTel;

    private String reserEmail;

    private String reserMisc;

	public ReservationDTO(int reserNo, String memId, int tableNo, String restId, Date reserDate, String reserTime,
			int reserPerson, String reserName, String reserTel, String reserEmail, String reserMisc) {
		super();
		this.reserNo = reserNo;
		this.memId = memId;
		this.tableNo = tableNo;
		this.restId = restId;
		this.reserDate = reserDate;
		this.reserTime = reserTime;
		this.reserPerson = reserPerson;
		this.reserName = reserName;
		this.reserTel = reserTel;
		this.reserEmail = reserEmail;
		this.reserMisc = reserMisc;
	}

	public int getReserNo() {
		return reserNo;
	}

	public void setReserNo(int reserNo) {
		this.reserNo = reserNo;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
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

	public Date getReserDate() {
		return reserDate;
	}

	public void setReserDate(Date reserDate) {
		this.reserDate = reserDate;
	}

	public String getReserTime() {
		return reserTime;
	}

	public void setReserTime(String reserTime) {
		this.reserTime = reserTime;
	}

	public int getReserPerson() {
		return reserPerson;
	}

	public void setReserPerson(int reserPerson) {
		this.reserPerson = reserPerson;
	}

	public String getReserName() {
		return reserName;
	}

	public void setReserName(String reserName) {
		this.reserName = reserName;
	}

	public String getReserTel() {
		return reserTel;
	}

	public void setReserTel(String reserTel) {
		this.reserTel = reserTel;
	}

	public String getReserEmail() {
		return reserEmail;
	}

	public void setReserEmail(String reserEmail) {
		this.reserEmail = reserEmail;
	}

	public String getReserMisc() {
		return reserMisc;
	}

	public void setReserMisc(String reserMisc) {
		this.reserMisc = reserMisc;
	}

	@Override
	public String toString() {
		return "ReservationDTO [reserNo=" + reserNo + ", memId=" + memId + ", tableNo=" + tableNo + ", restId=" + restId
				+ ", reserDate=" + reserDate + ", reserTime=" + reserTime + ", reserPerson=" + reserPerson
				+ ", reserName=" + reserName + ", reserTel=" + reserTel + ", reserEmail=" + reserEmail + ", reserMisc="
				+ reserMisc + "]";
	}

	@Override
	public int compareTo(Object o) {
		ReservationDTO dto = (ReservationDTO) o;
		int cmp = 0;
		
		cmp = reserDate.compareTo(dto.reserDate);
		if (cmp == 0)
			cmp = reserTime.compareTo(reserTime);
		return cmp;
	}
    
    
}