package pos.dao;

import java.util.Vector;

public interface TableCardCalcDAO {
	public int insert(String memId, int orderNo, int reserNo, int totalPrice);
	Vector<Vector<String>> poscardcalc(int tableNo);
}
