package review.service;

import java.util.Vector;

import dto.ReviewDTO;
import review.view.ReviewTableRowData;

public interface ReviewService {
	int reviewInsert(ReviewDTO dto);
	Vector<ReviewTableRowData> reviewSelectByRestID(String restID);

}
