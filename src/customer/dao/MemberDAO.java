package customer.dao;
import dto.MemberDTO;

public interface MemberDAO {
	//Vector<String> locGuSelect(String locsi);//��/���� ���� �� �����ϴ°�!!
	int memberInsert(MemberDTO meminfo);//ȸ�����Կ� ���� ȸ�� ���� ������ ���̽� ����!!
	String memberIdCheack(String memberid);
	String getMemberName(String memID);
	MemberDTO memberSelect(String memberid);
	void memberUpdate(MemberDTO meminfo);
	 boolean TryMemerLog (String memId, String memPw);
	String findID(String name, String email, String tel);
	boolean findPW(String id, String name, String email, String tel);
	int updatePW(String id, String pw);
	
}
