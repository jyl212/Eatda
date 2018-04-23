package customer.service;

import dto.MemberDTO;

public interface MemeberService {
	int memberInsert(MemberDTO meminfo);
	String memberIdCheack(String memberid);
	//Vector<String> locGuSelect(String locsi);
	String getMemberName(String memID);
	MemberDTO memberSelect(String memberid);
	void memberUpdate(MemberDTO meminfo);
	boolean TryMemberLog(String memId, String memPw);
	String findID(String name, String email, String tel);
	boolean findPW(String id, String name, String email, String tel);
	int updatePW(String id, String pw);
}
