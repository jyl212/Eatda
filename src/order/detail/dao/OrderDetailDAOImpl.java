package order.detail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.OrderDetailDTO;
import fw.DBUtil;
import order.detail.query.OrderDetailQuery;
/*
SQL> desc order_detail;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------
 ORDER_NO                                  NOT NULL NUMBER
 MENU_NO                                   NOT NULL NUMBER
 MENU_COUNT                                NOT NULL NUMBER
 */

public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Override
	public int OderDetailInsert(OrderDetailDTO dto) {
		int rowNum = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(OrderDetailQuery.ORDER_INSERT);
			//"insert into rest_order values(?,?,?)";
			
			preparedStatement.setInt(1, dto.getOrderNo());
			preparedStatement.setInt(2, dto.getMenuNo());
			preparedStatement.setInt(3, dto.getMenuCount());
			
			rowNum = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		return rowNum;
	}

}
