package customer.dao;

import static customer.query.MemberQuery.LOGIN_MEMBER;
import static customer.query.MemberQuery.MEMBER_SELECT;
import static customer.query.MemberQuery.MEMBER_UPDATE;
import static customer.query.MemberQuery.MEM_GET_NAME;
import static customer.query.MemberQuery.MEM_INSERT;
//static멤버를 편하게 사용하기 위한 static import
import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import customer.query.MemberQuery;
import dto.MemberDTO;
import fw.DBUtil;


public class MemberDAOImpl implements MemberDAO{
	@Override
	public int memberInsert(MemberDTO meminfo) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try{
			con = getConnect();
			ptmt = con.prepareStatement(MEM_INSERT);
			ptmt.setString(1, meminfo.getMemId());
			ptmt.setString(2, meminfo.getMemPw());
			ptmt.setString(3, meminfo.getMemName());
			ptmt.setString(4, meminfo.getBirth()+"");
			ptmt.setString(5, meminfo.getGender());
			ptmt.setString(6, meminfo.getMemTel());
			ptmt.setString(7, meminfo.getEmail());
			ptmt.setString(8, meminfo.getEmailCheck());
			ptmt.setString(9, meminfo.getLoc());

			result = ptmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(null, ptmt, con);
		}
		return result;

	}

	@Override
	public String memberIdCheack(String memberid) {
		String memch = "";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		try {
			con = getConnect();
			ptmt =con.prepareStatement(MemberQuery.MEM_ID_CHEACK);
			ptmt.setString(1, memberid);
			rs = ptmt.executeQuery();
			if(rs.next()){
				memch = rs.getString(1);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}
		return memch;
	}

	@Override
	public String getMemberName(String memID) {
		String name = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnect();
			preparedStatement = connection.prepareStatement(MEM_GET_NAME);

			preparedStatement.setString(1, memID);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				name = resultSet.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet, preparedStatement, connection);
		}


		return name;
	}

	/*public Vector<String> locGuSelect(String locsi) {
		Vector<String> locGulist = new Vector<String>();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;

			try {
				con = getConnect();
				ptmt = con.prepareStatement(MEM_LOCGu_Select);
				ptmt.setString(1, locsi);
				rs = ptmt.executeQuery();
				while(rs.next()){
					locGulist.add(rs.getString(1));
				}
			} catch (SQLException e) {

				e.printStackTrace();
			} finally{
				close(rs, ptmt, con);
			}

		return locGulist;
	}*/




	@Override
	public MemberDTO memberSelect(String memberid) {
		MemberDTO memdetail = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;

		try {
			con = getConnect();
			ptmt = con.prepareStatement(MEMBER_SELECT);
			ptmt.setString(1, memberid);
			rs = ptmt.executeQuery();
			if(rs.next()){
				memdetail = new MemberDTO(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getDate(9),
						rs.getString(10));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(rs, ptmt, con);
		}
		return memdetail;
	}

	@Override
	public void memberUpdate(MemberDTO meminfo) {
		Connection con = null;
		PreparedStatement ptmt = null;

		try {
			con = getConnect();
			ptmt = con.prepareStatement(MEMBER_UPDATE);
			ptmt.setString(1, meminfo.getMemPw());
			ptmt.setString(2, meminfo.getMemName());
			ptmt.setString(3, meminfo.getBirth());
			ptmt.setString(4, meminfo.getGender());
			ptmt.setString(5, meminfo.getMemTel());
			ptmt.setString(6, meminfo.getEmail());
			ptmt.setString(7, meminfo.getEmailCheck());
			ptmt.setString(8, meminfo.getLoc());
			ptmt.setString(9, meminfo.getMemId());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, ptmt, con);
		}

	}
	
	public boolean TryMemerLog(String memId, String memPw) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		boolean  result = false;
		try {
			con = getConnect();
			ptmt = con.prepareStatement(LOGIN_MEMBER);
			ptmt.setString(1,memId);
			ptmt.setString(2,memPw);
			rs = ptmt.executeQuery();
			if (rs.next()) {
				result = true;
			}else{
				result = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}
//		System.out.println("검색성공");// 3.
//		System.out.println(result);
		return result;
		
		
		
	}

	@Override
	public String findID(String name, String email, String tel) {
		String id = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(MemberQuery.MEM_FIND_ID);
			
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, tel);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				id = resultSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
	
		return id;
	}

	@Override
	public boolean findPW(String id, String name, String email, String tel) {
		boolean result = false;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(MemberQuery.MEM_FIND_PW);
			
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, tel);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				result = true;				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
	
		return result;
	}

	@Override
	public int updatePW(String id, String pw) {
		int rowNum = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(MemberQuery.MEM_UPDATE_PW);
			
			preparedStatement.setString(1, pw);			
			preparedStatement.setString(2, id);
			
			rowNum = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		
		return rowNum;
	}
}








