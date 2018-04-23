package review.dao;

import java.util.Vector;

import dto.ReviewDTO;
import review.view.ReviewTableRowData;

public interface ReviewDAO {
	int reviewInsert(ReviewDTO dto);
	Vector<ReviewTableRowData> reviewSelectByRestID(String restID);
}
