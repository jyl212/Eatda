package pos.dao;

import java.util.Vector;

public interface TableMoneyCalcDAO {
	int insert(String memId, int orderNo, int reserNo, int totalPrice);
	Vector<Vector<String>> posmoneycalc(int tableNo);
}
