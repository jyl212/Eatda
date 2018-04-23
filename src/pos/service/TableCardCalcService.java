package pos.service;

import java.util.Vector;

public interface TableCardCalcService {
	int insert(String memId, int orderNo, int reserNo, int totalPrice);
	Vector<Vector<String>> poscardcalc(int tableNo);
}
