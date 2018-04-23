package dto;

import java.sql.Date;

public class MemberDTO {

    private String memId;

    private String memPw;

    private String memName;

    private String birth;

    private String gender;

    private String memTel;

    private String email;

    private String emailCheck;

    private Date signDate;

    private String loc;

	public MemberDTO(String memId, String memPw, String memName, String birth, String gender, String memTel, String email,
			String emailCheck, Date signDate, String loc) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memName = memName;
		this.birth = birth;
		this.gender = gender;
		this.memTel = memTel;
		this.email = email;
		this.emailCheck = emailCheck;
		this.signDate = signDate;
		this.loc = loc;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailCheck() {
		return emailCheck;
	}

	public void setEmailCheck(String emailCheck) {
		this.emailCheck = emailCheck;
	}

	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}
    
    
}