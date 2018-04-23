package customer.service;

import customer.dao.MemberDAO;
import customer.dao.MemberDAOImpl;
import dto.MemberDTO;

public class MemeberServiceimpl implements MemeberService {

	@Override
	public int memberInsert(MemberDTO meminfo) {
		MemberDAO dao = new MemberDAOImpl();
		int result = dao.memberInsert(meminfo);
		return result;
	}
	/*public Vector<String> locGuSelect(String locsi) {
		MemberDAO dao= new MemberDAOImpl();
		Vector<String> locGulist = dao.locGuSelect(locsi);
		return locGulist;
	}*/


	@Override
	public String memberIdCheack(String memberid) {
		MemberDAO dao = new MemberDAOImpl();
		String memch = dao.memberIdCheack(memberid);
		return memch;
	}

	@Override
	public String getMemberName(String memID) {
		MemberDAO dao = new MemberDAOImpl();
		return dao.getMemberName(memID);
	}

	@Override
	public MemberDTO memberSelect(String memberid) {
		MemberDAO dao = new MemberDAOImpl();
		MemberDTO memdetail = dao.memberSelect(memberid);
		return memdetail;
	}

	@Override
	public void memberUpdate(MemberDTO meminfo) {
		MemberDAO dao = new MemberDAOImpl();
		dao.memberUpdate(meminfo);
	}

	@Override
	public boolean TryMemberLog(String memId, String memPw) {
		MemberDAO dao = new MemberDAOImpl();
//		System.out.println(dao);
		return dao.TryMemerLog(memId, memPw);
		
	}


	@Override
	public String findID(String name, String email, String tel) {
		MemberDAO dao = new MemberDAOImpl();
		return dao.findID(name, email, tel);
	}
	@Override
	public boolean findPW(String id, String name, String email, String tel) {
		MemberDAO dao = new MemberDAOImpl();
		return dao.findPW(id, name, email, tel);
	}


	@Override
	public int updatePW(String id, String pw) {
		MemberDAO dao = new MemberDAOImpl();
		return dao.updatePW( id, pw);
	}
}
