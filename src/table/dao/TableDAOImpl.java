package table.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dto.RestTableDTO;
import fw.DBUtil;
import table.query.TableQuery;

/*             REST_TABLE 
	TABLE_NO			NOT NULL NUMBER ==> TABLE_SEQUENCE
	REST_ID				NOT NULL VARCHAR2(40)
	TABLE_NAME		NOT NULL VARCHAR2(40)
	TABLE_STATE		NOT NULL VARCHAR2(20) "Y"/"N"
	TABLE_X				NOT NULL NUMBER
	TABLE_Y				NOT NULL NUMBER
	TABLE_W			NOT NULL NUMBER
	TABLE_H				NOT NULL NUMBER
	TABLE_TYPE		NOT NULL NUMBER
	PER_COUNT			NOT NULL NUMBER
	TABLE_COMENT	NOT NULL VARCHAR2(20)
*/

public class TableDAOImpl implements TableDAO{

	@Override
	public int tableInsert(RestTableDTO dto) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rowNum = 0;
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(TableQuery.TABLE_INSERT);
//			"insert into REST_TABLE values(TABLE_SEQUENCE.nextval,?,?,?,?,?,?,?,?,?,?)"
			
			preparedStatement.setString(1, dto.getRestId());
			preparedStatement.setString(2, dto.getTableName());
			preparedStatement.setString(3, dto.getTableState());
			preparedStatement.setInt(4, dto.getTableX());
			preparedStatement.setInt(5, dto.getTableY());
			preparedStatement.setInt(6, dto.getTableW());
			preparedStatement.setInt(7, dto.getTableH());
			preparedStatement.setInt(8, dto.getTableType());
			preparedStatement.setInt(9, dto.getPerCount());
			preparedStatement.setString(10, dto.getTableComment());
			
			rowNum = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		
		return rowNum;
	}

	@Override
	public Vector<RestTableDTO> findTablesByRestID(String restID) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Vector<RestTableDTO> tableList = null;
		RestTableDTO table = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(TableQuery.RESTID_SELECT);
			
			preparedStatement.setString(1, restID);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (tableList == null)
					tableList = new Vector<RestTableDTO>();
				
				table = new RestTableDTO(
						resultSet.getInt(1), 
						resultSet.getString(2), 
						resultSet.getString(3),
						resultSet.getString(4), 
						resultSet.getInt(5), 
						resultSet.getInt(6), 
						resultSet.getInt(7), 
						resultSet.getInt(8), 
						resultSet.getInt(9), 
						resultSet.getInt(10),  
						resultSet.getString(11));
				
				tableList.add(table);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return tableList;
	}

	@Override
	public int tableDelete(int tableNo) {
		int result = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(TableQuery.TABLE_DELETE);
			
			preparedStatement.setInt(1, tableNo);
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		return result;
	}

	@Override
	public int tableUpdate (String tableName, int tableX, int tableY, String tableComent, int tableNo){
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(TableQuery.TABLE_UPDATE);
			//"update REST_TABLE set TABLE_NAME=?, TABLE_X=?, TABLE_Y=?, TABLE_COMENT=? where TABLE_NO=?";
			
			preparedStatement.setString(1, tableName);
			preparedStatement.setInt(2, tableX);
			preparedStatement.setInt(3, tableY);
			preparedStatement.setString(4, tableComent);
			preparedStatement.setInt(5, tableNo);
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		return result;
	}

	@Override
	public int objectUpdate(int tableX, int tableY, int tableW, int tableH, int tableNo) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(TableQuery.OBJECT_UPDATE);
			//"update REST_TABLE set TABLE_X=?, TABLE_Y=?, TABLE_W=?, TABLE_H=?, where TABLE_NO=?"

			preparedStatement.setInt(1, tableX);
			preparedStatement.setInt(2, tableY);
			preparedStatement.setInt(3, tableW);
			preparedStatement.setInt(4, tableH);
			preparedStatement.setInt(5, tableNo);
			
			result = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String getTableName(int tableNo) {
		String name = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(TableQuery.TABLE_GET_NAME);
			
			preparedStatement.setInt(1, tableNo);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()){
				name = resultSet.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return name;
	}





}
