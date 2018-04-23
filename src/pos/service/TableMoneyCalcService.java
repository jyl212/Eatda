package pos.service;

import java.util.Vector;

public interface TableMoneyCalcService {
	int insert(String memId, int orderNo, int reserNo, int totalPrice);
	Vector<Vector<String>> posmoneycalc(int tableNo);
}
