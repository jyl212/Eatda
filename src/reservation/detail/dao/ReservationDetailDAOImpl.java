package reservation.detail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import fw.DBUtil;
import reservation.detail.query.ReservationDetailQuery;

public class ReservationDetailDAOImpl implements ReservationDetailDAO {

	@Override
	public Vector<Vector<String>> getReservationMenuInfo(int reserNo) {
		Vector<Vector<String>> menuList = null;
		Vector<String> menu = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReservationDetailQuery.RESER_MENU_INFO);
			
			preparedStatement.setInt(1, reserNo);
			/*
			"select m.MENU_NAME, r.MENU_COUNT, m.MENU_PRICE "
			+ "from RESERVATION_DETAIL r, menu m "
			+ "where r.MENU_NO = m.MENU_NO "
			+ "and r.RESER_NO = ?";*/
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				if (menuList == null)
					menuList = new Vector<Vector<String>>();
				
				menu = new Vector<String>();
				
				menu.add(resultSet.getString(1));
				menu.add(resultSet.getInt(2)+"");
				menu.add(resultSet.getInt(3)+"");
				
				menuList.addElement(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		
		return menuList;
	}

	@Override
	public int reservationDetailDelete(int reserNo) {
		int rowNum = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReservationDetailQuery.RESER_DETAIL_DELETE);
			
			preparedStatement.setInt(1, reserNo);
			
			rowNum = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		return rowNum;
	}

}
