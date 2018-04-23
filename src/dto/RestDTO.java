package dto;
public class RestDTO {

    private String restId;

    private String restPw;

    private String restName;

    private String ornerName;

    private String ornerNum;

    private String addr;

    private String restX;

    private String restY;

    private String restTel;

    private String restEmail;

    private String openTime;

	private String closeTime;

    private String restType;

    private String restDetail;

    private String restImg1;

    private String restImg2;

    public RestDTO(String restId, String restPw, String restName, String ornerName, String ornerNum, String addr,
			String restTel, String restEmail, String openTime, String closeTime, String restType, String restDetail,
			String restImg1, String restImg2) {
		super();
		this.restId = restId;
		this.restPw = restPw;
		this.restName = restName;
		this.ornerName = ornerName;
		this.ornerNum = ornerNum;
		this.addr = addr;
		this.restTel = restTel;
		this.restEmail = restEmail;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.restType = restType;
		this.restDetail = restDetail;
		this.restImg1 = restImg1;
		this.restImg2 = restImg2;
	}

	public RestDTO(String restId, String restPw, String restName, String ornerName, String ornerNum, String addr,
			String restX, String restY, String restTel, String restEmail, String openTime, String closeTime,
			String restType, String restDetail, String restImg1, String restImg2) {
		super();
		this.restId = restId;
		this.restPw = restPw;
		this.restName = restName;
		this.ornerName = ornerName;
		this.ornerNum = ornerNum;
		this.addr = addr;
		this.restX = restX;
		this.restY = restY;
		this.restTel = restTel;
		this.restEmail = restEmail;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.restType = restType;
		this.restDetail = restDetail;
		this.restImg1 = restImg1;
		this.restImg2 = restImg2;
	}

	public String getRestId() {
		return restId;
	}

	public void setRestId(String restId) {
		this.restId = restId;
	}

	public String getRestPw() {
		return restPw;
	}

	public void setRestPw(String restPw) {
		this.restPw = restPw;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
	}

	public String getOrnerName() {
		return ornerName;
	}

	public void setOrnerName(String ornerName) {
		this.ornerName = ornerName;
	}

	public String getOrnerNum() {
		return ornerNum;
	}

	public void setOrnerNum(String ornerNum) {
		this.ornerNum = ornerNum;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRestX() {
		return restX;
	}

	public void setRestX(String restX) {
		this.restX = restX;
	}

	public String getRestY() {
		return restY;
	}

	public void setRestY(String restY) {
		this.restY = restY;
	}

	public String getRestTel() {
		return restTel;
	}

	public void setRestTel(String restTel) {
		this.restTel = restTel;
	}

	public String getRestEmail() {
		return restEmail;
	}

	public void setRestEmail(String restEmail) {
		this.restEmail = restEmail;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getRestType() {
		return restType;
	}

	public void setRestType(String restType) {
		this.restType = restType;
	}

	public String getRestDetail() {
		return restDetail;
	}

	public void setRestDetail(String restDetail) {
		this.restDetail = restDetail;
	}

	public String getRestImg1() {
		return restImg1;
	}

	public void setRestImg1(String restImg1) {
		this.restImg1 = restImg1;
	}

	public String getRestImg2() {
		return restImg2;
	}

	public void setRestImg2(String restImg2) {
		this.restImg2 = restImg2;
	}

	@Override
	public String toString() {
		return "RestDTO [restId=" + restId + ", restPw=" + restPw + ", restName=" + restName + ", ornerName="
				+ ornerName + ", ornerNum=" + ornerNum + ", addr=" + addr + ", restX=" + restX + ", restY=" + restY
				+ ", restTel=" + restTel + ", restEmail=" + restEmail + ", openTime=" + openTime + ", closeTime="
				+ closeTime + ", restType=" + restType + ", restDetail=" + restDetail + ", restImg1=" + restImg1
				+ ", restImg2=" + restImg2 + "]";
	}
    
	
}