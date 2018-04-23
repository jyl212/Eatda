package customer.dao;
import dto.MemberDTO;

public interface MemberDAO {
	//Vector<String> locGuSelect(String locsi);//시/도에 따른 구 선택하는것!!
	int memberInsert(MemberDTO meminfo);//회원가입에 따른 회원 정보 데이터 베이스 저장!!
	String memberIdCheack(String memberid);
	String getMemberName(String memID);
	MemberDTO memberSelect(String memberid);
	void memberUpdate(MemberDTO meminfo);
	 boolean TryMemerLog (String memId, String memPw);
	String findID(String name, String email, String tel);
	boolean findPW(String id, String name, String email, String tel);
	int updatePW(String id, String pw);
	
}
