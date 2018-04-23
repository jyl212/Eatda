package review.service;

import java.util.Vector;

import dto.ReviewDTO;
import review.dao.ReviewDAO;
import review.dao.ReviewDAOImpl;
import review.view.ReviewTableRowData;

public class ReviewServiceImpl implements ReviewService {

	@Override
	public int reviewInsert(ReviewDTO dto) {
		ReviewDAO dao = new ReviewDAOImpl();
		return dao.reviewInsert(dto);
	}

	@Override
	public Vector<ReviewTableRowData> reviewSelectByRestID(String restID) {
		ReviewDAO dao = new ReviewDAOImpl();
		return dao.reviewSelectByRestID(restID);
	}

}
