package reservation.dao;

/***********************************************/
import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;
import static reservation.view.db.ReservationQuery.MENUTYPE_COUNT;
import static reservation.view.db.ReservationQuery.MENUTYPE_SELECT;
import static reservation.view.db.ReservationQuery.MENU_DETAIL_COUNT;
import static reservation.view.db.ReservationQuery.MENU_INSERT;
import static reservation.view.db.ReservationQuery.MENU_NO_SELECT;
import static reservation.view.db.ReservationQuery.MENU_SELECT;
import static reservation.view.db.ReservationQuery.TABLE_SELECT;
import static reservation.view.db.ReservationQuery.RESERNO_SELELCT;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dto.MenuDTO;
import dto.ReservationDTO;
import fw.DBUtil;
import reservation.query.ReservationQuery;

public class ReservationDAOImpl implements ReservationDAO {
	/*   reservation
 RESER_NO			NOT NULL NUMBER
 MEM_ID				NOT NULL VARCHAR2(40)
 TABLE_NO			NOT NULL NUMBER
 REST_ID			NOT NULL VARCHAR2(40)
 RESER_DATE		NOT NULL DATE
 RESER_TIME		NOT NULL VARCHAR2(20)
 RESER_PERSON	NOT NULL NUMBER
 RESER_NAME		NOT NULL VARCHAR2(20)
 RESER_TEL			NOT NULL VARCHAR2(20)
 RESER_EMAIL		NOT NULL VARCHAR2(80)
 RESER_MISC		NOT NULL VARCHAR2(900)
	 */

	@Override
	public int reservationInsert(ReservationDTO dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rowNum = 0;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReservationQuery.RESERVATION_INSERT);
//			 "insert into reservation values(RESER_SEQUENCE.nextval,?,?,?,?,?,?,?,?,?,?)";
			
			preparedStatement.setString(1, dto.getMemId());
			preparedStatement.setInt(2, dto.getTableNo());
			preparedStatement.setString(3, dto.getRestId());
			preparedStatement.setDate(4, dto.getReserDate());
			preparedStatement.setString(5, dto.getReserTime());
			preparedStatement.setInt(6, dto.getReserPerson());
			preparedStatement.setString(7, dto.getReserName());
			preparedStatement.setString(8, dto.getReserTel());
			preparedStatement.setString(9, dto.getReserEmail());
			preparedStatement.setString(10, dto.getReserMisc());
			
			rowNum = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		
		return rowNum;
	}

	@Override
	public	Vector<ReservationDTO> reservationSelectDaily (String restID, Date reserDate) {
		Vector<ReservationDTO> reserList = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ReservationDTO dto = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReservationQuery.RESERVATION_SELECT_TIME_BY_DAY);
			//"select * from reservation where REST_ID = ? and RESER_DATE = ?";
			
			preparedStatement.setString(1, restID);
			preparedStatement.setDate(2, reserDate);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (reserList == null)
					reserList = new Vector<ReservationDTO>();
				
				dto = new ReservationDTO(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3),
						resultSet.getString(4),
						resultSet.getDate(5),
						resultSet.getString(6),
						resultSet.getInt(7),
						resultSet.getString(8),
						resultSet.getString(9),
						resultSet.getString(10),
						resultSet.getString(11));
						
				
				reserList.add(dto);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return reserList;
	}

	@Override
	public Vector<ReservationDTO> reservationSelectMemID(String memID) {
		Vector<ReservationDTO> reserList = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =  null;
		
		ReservationDTO dto = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReservationQuery.RESERVATION_SELECT_BY_MEMID);
			
			preparedStatement.setString(1, memID);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (reserList == null)
					reserList = new Vector<ReservationDTO>();
				
				dto = new ReservationDTO(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3),
						resultSet.getString(4),
						resultSet.getDate(5),
						resultSet.getString(6),
						resultSet.getInt(7),
						resultSet.getString(8),
						resultSet.getString(9),
						resultSet.getString(10),
						resultSet.getString(11));				
				
				reserList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return reserList;
	}

	@Override
	public Vector<ReservationDTO> reservationSelectRestID(String restID) {
		Vector<ReservationDTO> reserList = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =  null;
		
		ReservationDTO dto = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReservationQuery.RESERVATION_SELECT_BY_RESTID);
			
			preparedStatement.setString(1, restID);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (reserList == null)
					reserList = new Vector<ReservationDTO>();
				
				dto = new ReservationDTO(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getInt(3),
						resultSet.getString(4),
						resultSet.getDate(5),
						resultSet.getString(6),
						resultSet.getInt(7),
						resultSet.getString(8),
						resultSet.getString(9),
						resultSet.getString(10),
						resultSet.getString(11));				
				
				reserList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return reserList;
	}


	@Override
	public int reservationDelete(int reserNo) {
		int rowNum = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnect();
			preparedStatement = connection.prepareStatement(ReservationQuery.RESERVATION_DELETE);
			
			preparedStatement.setInt(1, reserNo);
			
			rowNum = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, preparedStatement, connection);
		}
		
		return rowNum;
	}
	
	@Override
	public int reservationUpdate(ReservationDTO dto) {
		int rowNum = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReservationQuery.RESERVATION_UPDATE);
			/*"update reservation set "
			+ "MEM_ID = ?, "
			+ "TABLE_NO = ?, "
			+ "REST_ID = ?, "
			+ "RESER_DATE = ?, "
			+ "RESER_TIME = ?, "
			+ "RESER_PERSON = ?, "
			+ "RESER_NAME = ?, "
			+ "RESER_TEL = ?, "
			+ "RESER_EMAIL = ?, "
			+ "RESER_MISC = ? "
			+ "where RESER_NO = ?";*/
			
			preparedStatement.setString(1, dto.getMemId());
			preparedStatement.setInt(2, dto.getTableNo());
			preparedStatement.setString(3, dto.getRestId());
			preparedStatement.setDate(4, dto.getReserDate());
			preparedStatement.setString(5, dto.getReserTime());
			preparedStatement.setInt(6, dto.getReserPerson());
			preparedStatement.setString(7, dto.getReserName());
			preparedStatement.setString(8, dto.getReserTel());
			preparedStatement.setString(9, dto.getReserEmail());
			preparedStatement.setString(10, dto.getReserMisc());
			preparedStatement.setInt(11, dto.getReserNo());
			
			rowNum = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		
		return rowNum;
	}
	
	/*********************************************************************/
	@Override
	public int countMenuType(String restId) {
		int result=0;
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(MENUTYPE_COUNT);
			ptmt.setString(1,restId);
			rs=ptmt.executeQuery();
			while(rs.next()){
				result=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return result;
	}
	@Override
	public Vector<MenuDTO> select(String restId,String menuType) {	
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		Vector<MenuDTO> v=new Vector<MenuDTO>();
		try{
			MenuDTO dto=null;
			ptmt=con.prepareStatement(MENU_SELECT);
			ptmt.setString(1,restId);
			ptmt.setString(2,menuType);
			rs=ptmt.executeQuery();
			while(rs.next()){
				dto=new MenuDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
				v.add(dto);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return v;
	}
	@Override
	public Vector<String> selectMenuType(String restId) {
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		Vector<String> v=new Vector<String>();
		try{
			ptmt=con.prepareStatement(MENUTYPE_SELECT);
			ptmt.setString(1,restId);
			rs=ptmt.executeQuery();
			while(rs.next()){
				v.add(rs.getString(1));
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return v;
	}
	@Override
	public int countMenuDetail(String restId, String menuType) {
		int result=0;
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(MENU_DETAIL_COUNT);
			ptmt.setString(1,restId);
			ptmt.setString(2,menuType);
			rs=ptmt.executeQuery();
			while(rs.next()){
				result=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return result;
	}
	@Override
	public void insertMenu(int reserno,int menuId, int count){
		Connection con=null;
		PreparedStatement ptmt=null;

		try{
			con=getConnect();
			ptmt=con.prepareStatement(MENU_INSERT);
			ptmt.setInt(1,reserno);
			ptmt.setInt(2,menuId);
			ptmt.setInt(3,count);
			
			ptmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(null, ptmt, con);
		}
	}
	@Override
	public int menuNoSelect(String restId, String menuName) {
		int result=0;
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(MENU_NO_SELECT);
			ptmt.setString(1,restId);
			ptmt.setString(2,menuName);
			rs=ptmt.executeQuery();
			while(rs.next()){
				result=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return result;
	}
	@Override
	public Vector<Vector<String>> selectTableInfo(String restId) {
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(TABLE_SELECT);
			ptmt.setString(1,restId);
			rs=ptmt.executeQuery();
			while(rs.next()){
				Vector<String> data=new Vector<String>();
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				v.add(data);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return v;
	}

	@Override
	public int reservationSelect() {
		int reserno=0;
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		try{
			ptmt=con.prepareStatement(RESERNO_SELELCT);
			rs=ptmt.executeQuery();
			while(rs.next()){
				reserno=rs.getInt(1);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return reserno;
	}

}
