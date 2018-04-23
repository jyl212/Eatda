package restaurant.dao;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import dto.RestDTO;
import fw.DBUtil;
import fw.LoggableStatement;
import restaurant.query.RestQuery;


/*          REST
 REST_ID		NOT NULL VARCHAR2(40)
 REST_PW		NOT NULL VARCHAR2(20)
 REST_NAME		NOT NULL VARCHAR2(60)
 ORNER_NAME		NOT NULL VARCHAR2(20)
 ORNER_NUM		NOT NULL VARCHAR2(40)
 ADDR			NOT NULL VARCHAR2(100)
 REST_X			NOT NULL VARCHAR2(20)
 REST_Y			NOT NULL VARCHAR2(20)
 REST_TEL		NOT NULL VARCHAR2(20)
 REST_EMAIL		NOT NULL VARCHAR2(40)
 OPEN_TIME		NOT NULL VARCHAR2(20)
 CLOSE_TIME		NOT NULL VARCHAR2(20)
 REST_TYPE		NOT NULL VARCHAR2(30)
 REST_DETAIL	NOT NULL VARCHAR2(250)
 REST_IMG1		NOT NULL VARCHAR2(50)
 REST_IMG2		NOT NULL VARCHAR2(50)
 */

public class RestDAOImpl implements RestDAO {

	@Override
	public Vector<RestDTO> restSelectAll() {
		Vector<RestDTO> result = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		RestDTO dto = null;

		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(RestQuery.REST_SELECT_ALL);
			//"select * from REST"
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (result == null) 
					result = new Vector<RestDTO>();

				dto = new RestDTO(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3), 
						resultSet.getString(4), 
						resultSet.getString(5),
						resultSet.getString(6),  
						resultSet.getString(7), 
						resultSet.getString(8), 
						resultSet.getString(9), 
						resultSet.getString(10),  
						resultSet.getString(11), 
						resultSet.getString(12),
						resultSet.getString(13), 
						resultSet.getString(14), 
						resultSet.getString(15),
						resultSet.getString(16));

				result.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}


		return result;
	}

	@Override
	public Vector<String> getRestTypeList() {
		Vector<String> typeSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(RestQuery.REST_SELECT_TYPE);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){

				if (typeSet == null)
					typeSet = new Vector<String>();

				typeSet.add(resultSet.getString(1));			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}


		return typeSet;
	}

	@Override
	public Vector<String> getRestLocList() {
		Vector<String> typeSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(RestQuery.REST_SELECT_LOC);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){

				if (typeSet == null)
					typeSet = new Vector<String>();

				typeSet.add(resultSet.getString(1));			
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}


		return typeSet;
	}

	@Override
	public Vector<RestDTO>  restSelectByCondition(String restName, String addr, String restType, int cost, boolean minmax){
		Vector<RestDTO> restList = null;
		ArrayList<LoggableStatement> sqls = new ArrayList<LoggableStatement>();
		Connection connection = null;
		StringBuffer sql = new StringBuffer();
		Statement statement = null;
		ResultSet resultSet = null;
		LoggableStatement loggableStatement = null;
		RestDTO dto = null;

		try {
			connection = DBUtil.getConnect();

			if (restName != null) {
				loggableStatement = new LoggableStatement(connection, RestQuery.REST_SELECT_BY_NAME);
				loggableStatement.setString(1, "%"+restName+"%");
				sqls.add(loggableStatement);
			}
			if (addr != null){
				loggableStatement = new LoggableStatement(connection, RestQuery.REST_SELECT_BY_LOC);
				loggableStatement.setString(1, "%"+addr+"%");
				sqls.add(loggableStatement);
			}
			if (restType != null){
				loggableStatement = new LoggableStatement(connection, RestQuery.REST_SELECT_BY_TYPE);
				loggableStatement.setString(1, restType);
				sqls.add(loggableStatement);				
			}
			if (cost >= 0){
				if (minmax){ //최대값 기준
					if (cost == 5)
						loggableStatement = new LoggableStatement(connection, RestQuery.REST_SELECT_BY_MAXCOST_OVER);
					else 
						loggableStatement = new LoggableStatement(connection, RestQuery.REST_SELECT_BY_MAXCOST);
				} else { // 최소값 기준
					if (cost == 5)
						loggableStatement = new LoggableStatement(connection, RestQuery.REST_SELECT_BY_MINCOST_OVER);
					else 
						loggableStatement = new LoggableStatement(connection, RestQuery.REST_SELECT_BY_MINCOST);
				}

				loggableStatement.setInt(1, cost);
				sqls.add(loggableStatement);				
			}

			for (int i = 0; i < sqls.size(); i++) {
				sql.append(sqls.get(i).getQueryString());
				if (i != (sqls.size()-1))
					sql.append(" intersect ");

			}


			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());

			while (resultSet.next()) {
				if (restList == null) 
					restList = new Vector<RestDTO>();

				dto = new RestDTO(
						resultSet.getString(1),
						resultSet.getString(2),
						resultSet.getString(3), 
						resultSet.getString(4), 
						resultSet.getString(5),
						resultSet.getString(6),  
						resultSet.getString(7), 
						resultSet.getString(8), 
						resultSet.getString(9), 
						resultSet.getString(10),  
						resultSet.getString(11), 
						resultSet.getString(12),
						resultSet.getString(13), 
						resultSet.getString(14), 
						resultSet.getString(15),
						resultSet.getString(16));

				restList.add(dto);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, connection);
			for (int i = 0; i < sqls.size(); i++) {
				try {
					sqls.get(i).close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return restList;
	}

	@Override
	public Vector<String> getRestTime(String restID) {
		Vector<String> opTimes = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnect();

			preparedStatement = connection.prepareStatement(RestQuery.REST_SELECT_TIME);
			preparedStatement.setString(1, restID);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				opTimes = new Vector<String>();

				opTimes.addElement(resultSet.getString(1));
				opTimes.addElement(resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}

		return opTimes;
	}

	@Override
	public int restInsert(RestDTO restinfo) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int result = 0;
		try{
			con = getConnect();
			ptmt = con.prepareStatement(RestQuery.REST_SIGN_UP);
			ptmt.setString(1, restinfo.getRestId());
			ptmt.setString(2, restinfo.getRestPw());
			ptmt.setString(3, restinfo.getRestName());
			ptmt.setString(4, restinfo.getOrnerName());
			ptmt.setString(5, restinfo.getOrnerNum());
			ptmt.setString(6, restinfo.getAddr());
			ptmt.setString(7, restinfo.getRestTel());
			ptmt.setString(8, restinfo.getRestEmail());
			ptmt.setString(9, restinfo.getOpenTime());
			ptmt.setString(10, restinfo.getCloseTime());
			ptmt.setString(11, restinfo.getRestType());
			ptmt.setString(12, restinfo.getRestDetail());
			ptmt.setString(13, restinfo.getRestImg1());
			ptmt.setString(14, restinfo.getRestImg2());



			result = ptmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			close(null, ptmt, con);
		}
		return result;
	}

	@Override
	public String restIdCheack(String restid) {
		String restidlist = "";
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;

		try {
			con = getConnect();
			ptmt = con.prepareStatement(RestQuery.REST_DISTINCT_CHEACK);
			ptmt.setString(1, restid);
			rs = ptmt.executeQuery();
			if(rs.next()){
				restidlist = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(rs, ptmt, con);
		}
		return restidlist;
	}

	@Override
	public Vector<String> getNameAndImg(String restId) {
		Vector<String> nameAndImg = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnect();
			preparedStatement = connection.prepareStatement(RestQuery.REST_GET_NAME_IMG);

			preparedStatement.setString(1, restId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()){
				nameAndImg = new Vector<String>();
				nameAndImg.addElement(resultSet.getString(1));
				nameAndImg.addElement(resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(resultSet, preparedStatement, connection);
		}

		return nameAndImg;
	}



	public boolean TryRestLog(String restId, String restPw) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		boolean  result = false;
		try {
			con = getConnect();
			ptmt = con.prepareStatement(RestQuery.LOGIN_REST);
			ptmt.setString(1,restId);
			ptmt.setString(2,restPw);
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
	public Vector<String> locGuSelect(String locsi) {
		Vector<String> locGulist = new Vector<String>();
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;

		try {
			con = getConnect();
			ptmt = con.prepareStatement(RestQuery.MEM_LOCGu_Select);
			ptmt.setString(1, locsi);
			rs = ptmt.executeQuery();
			while(rs.next()){
				locGulist.addElement(rs.getString(1));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally{
			close(rs, ptmt, con);
		}

		return locGulist;
	}

	@Override
	public RestDTO restselect(String restid) {
		RestDTO restinfo = null;
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;

		try {
			con = getConnect();
			ptmt = con.prepareStatement(RestQuery.REST_SELECT);
			ptmt.setString(1, restid);
			rs = ptmt.executeQuery();
			if(rs.next()){
				restinfo = new RestDTO(
						rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getString(5),
						rs.getString(6),
						rs.getString(7),
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12),
						rs.getString(13),
						rs.getString(14),
						rs.getString(15),
						rs.getString(16));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}


		return restinfo;
	}

	@Override
	public void restUpdate(RestDTO restUdList) {//14개
		Connection con = null;
		PreparedStatement ptmt = null;
		try {
			con = getConnect();
			ptmt = con.prepareStatement(RestQuery.REST_UPDATE);
			/*"update rest set rest_pw = ?, rest_name = ?,orner_name = ?,orner_num = ?, "
			+ "addr = ?, rest_tel = ? , rest_email = ?, open_time = ?, "
			+ "close_time = ? , rest_type = ? , rest_detail = ?, rest_img1 = ? , rest_img2 = ?  where rest_id = ?";*/
			ptmt.setString(1, restUdList.getRestPw());
			ptmt.setString(2, restUdList.getRestName());
			ptmt.setString(3, restUdList.getOrnerName());
			ptmt.setString(4, restUdList.getOrnerNum());
			ptmt.setString(5, restUdList.getAddr());
			ptmt.setString(6, restUdList.getRestTel());
			ptmt.setString(7, restUdList.getRestEmail());
			ptmt.setString(8, restUdList.getOpenTime());
			ptmt.setString(9, restUdList.getCloseTime());
			ptmt.setString(10, restUdList.getRestType());
			ptmt.setString(11, restUdList.getRestDetail());
			ptmt.setString(12, restUdList.getRestImg1());
			ptmt.setString(13, restUdList.getRestImg2());
			ptmt.setString(14, restUdList.getRestId());
			ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, ptmt, con);
		}


	}

	@Override
	public String getRestName(String restID) {
		String name = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnect();
			preparedStatement = connection.prepareStatement(RestQuery.REST_GET_NAME_BYID);

			preparedStatement.setString(1, restID);

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

	@Override
	public String findID(String name, String email, String tel) {
		String id = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(RestQuery.REST_FIND_ID);
			
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
			preparedStatement = connection.prepareStatement(RestQuery.REST_FIND_PW);
			
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
			preparedStatement = connection.prepareStatement(RestQuery.REST_UPDATE_PW);
			
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
