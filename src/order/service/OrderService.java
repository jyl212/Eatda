package order.service;

import table.view.TableButton;

public interface OrderService {
	int OrderInsert(TableButton tableButton, String restID);
	int getLastOrderSequenceNum();
}
