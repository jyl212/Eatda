package order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.RestOrderDTO;
import fw.DBUtil;
import order.detail.query.OrderDetailQuery;
import order.query.OrderQuery;


/*SQL> desc rest_order;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------
 ORDER_NO                                  NOT NULL NUMBER
 REST_ID                                   NOT NULL VARCHAR2(40)
 TABLE_NO                                  NOT NULL NUMBER
 ORDER_DATE                                NOT NULL DATE
 ORDER_PRICE                               NOT NULL NUMBER
 */

public class OrderDAOImpl implements OrderDAO {

	@Override
	public int OrderInsert(RestOrderDTO dto) {
		int rowNum = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(OrderQuery.ORDER_INSERT);
			//"insert into rest_order values(ORDER_SEQUENCE.nextval,?,?,?,?)"; 
			
			preparedStatement.setString(1, dto.getRestId());
			preparedStatement.setInt(2, dto.getTableNo());
			preparedStatement.setInt(3, dto.getOrderPrice());
			
			rowNum = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		return rowNum;
	}

	@Override
	public int getLastOrderSequenceNum() {
		int lastNum = 0;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(OrderQuery.ORDER_LAST_SEQ);
			//"select LAST_NUMBER from user_sequences where SEQUENCE_NAME = 'ORDER_SEQUENCE'";
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				lastNum = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return lastNum;
	}
}
