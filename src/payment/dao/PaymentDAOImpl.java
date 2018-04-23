package payment.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import fw.DBUtil;
import fw.LoggableStatement;
import payment.query.PaymentQuery;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public Vector<Vector<String>> getAllData(String restID) {
		Vector<Vector<String>> dataSet = null;
		Vector<String>data = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(PaymentQuery.PAYMENT_SELECT_ALL);
			
			preparedStatement.setString(1, restID);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				if (dataSet == null) dataSet = new Vector<Vector<String>>();
				
				data = new Vector<String>();
				
				data.add(resultSet.getString(1));
				data.add(resultSet.getInt(2)+"");
				data.add(resultSet.getDate(3)+"");
				data.add(resultSet.getString(4));
				data.add(resultSet.getString(5));
				data.add(resultSet.getString(6));
				
				dataSet.add(data);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return dataSet;
	}

	@Override
	public Vector<Vector<String>> getDataByCondition(String restID, boolean man, boolean woman, Date startDate, Date endDate, String type){
		Vector<Vector<String>> dataSet = null;
		Vector<String>data = null;
		
		ArrayList<LoggableStatement> sqls = new ArrayList<LoggableStatement>();
		StringBuffer sql = new StringBuffer();
		
		Connection connection = null;
		LoggableStatement loggableStatement = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			
			if (man || woman){
				loggableStatement = new LoggableStatement(connection, PaymentQuery.PAYMENT_SELECT_GENDER);
				loggableStatement.setString(1, restID);
				if (man && !woman) {
					loggableStatement.setString(2, "³²");
				} else if (woman && !man) {
					loggableStatement.setString(2, "¿©");
				}
				sqls.add(loggableStatement);
			}
			
			if(startDate != null){
				loggableStatement = new LoggableStatement(connection, PaymentQuery.PAYMENT_SELECT_STARTDAY);
				loggableStatement.setString(1, restID);
				loggableStatement.setDate(2, startDate);
				sqls.add(loggableStatement);
			}

			if(endDate != null){
				loggableStatement = new LoggableStatement(connection, PaymentQuery.PAYMENT_SELECT_ENDDAY);
				loggableStatement.setString(1, restID);
				loggableStatement.setDate(2, endDate);
				sqls.add(loggableStatement);
			}
			
			if (type != null){
				loggableStatement = new LoggableStatement(connection, PaymentQuery.PAYMENT_SELECT_TYPE);
				loggableStatement.setString(1, restID);
				loggableStatement.setString(2, type);
				sqls.add(loggableStatement);
			}
			
			for (int i = 0; i < sqls.size(); i++) {
				sql.append(sqls.get(i).getQueryString());
				if (i != (sqls.size()-1))
					sql.append(" intersect ");

			}


			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
			
			while(resultSet.next()){
				if (dataSet == null) dataSet = new Vector<Vector<String>>();
				
				data = new Vector<String>();
				
				data.add(resultSet.getString(1));
				data.add(resultSet.getInt(2)+"");
				data.add(resultSet.getDate(3)+"");
				data.add(resultSet.getString(4));
				data.add(resultSet.getString(5));
				data.add(resultSet.getString(6));
				
				dataSet.add(data);
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
		
		return dataSet;
	}

}
