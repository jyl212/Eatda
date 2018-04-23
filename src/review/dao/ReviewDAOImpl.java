package review.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dto.ReviewDTO;
import fw.DBUtil;
import review.query.ReviewQuery;
import review.view.ReviewTableRowData;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public int reviewInsert(ReviewDTO dto) {
		int rowNum = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReviewQuery.REVIEW_INSERT);
			
			preparedStatement.setInt(1, dto.getMenuNo());
			preparedStatement.setInt(2, dto.getReviewPoint());
			preparedStatement.setString(3, dto.getOnelineRev());
			
			rowNum = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		return rowNum;
	}

	@Override
	public Vector<ReviewTableRowData> reviewSelectByRestID(String restID) {
		Vector<ReviewTableRowData> reviewList = null;
		ReviewTableRowData review = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(ReviewQuery.REVIEW_SELECT_BY_RESTID);
			
			preparedStatement.setString(1, restID);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				if (reviewList == null) reviewList = new Vector<ReviewTableRowData>();
				
				review = new ReviewTableRowData(
						resultSet.getString(1), 
						resultSet.getInt(2), 
						resultSet.getString(3));
				
				reviewList.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return reviewList;
	}

}
