package order.dao;

import dto.RestOrderDTO;

public interface OrderDAO {
	int OrderInsert(RestOrderDTO dto);
	int getLastOrderSequenceNum();
}
