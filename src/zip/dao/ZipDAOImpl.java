package zip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import fw.DBUtil;
import zip.query.ZipQuery;

public class ZipDAOImpl implements ZipDAO{

	@Override
	public Vector<String> getSIDO() {
		Vector<String> sidoList = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ZipQuery.ZIP_SIDO);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (sidoList == null)
					sidoList = new Vector<String>();
				
				sidoList.addElement(resultSet.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return sidoList;
	}

	@Override
	public Vector<String> getGUGUN(String sido) {
		Vector<String> gugunList = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ZipQuery.ZIP_GUGUN);
			
			preparedStatement.setString(1, sido);
			preparedStatement.setString(2, sido);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (gugunList == null)
					gugunList = new Vector<String>();
				
				gugunList.addElement(resultSet.getString(1));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return gugunList;
	}

}
