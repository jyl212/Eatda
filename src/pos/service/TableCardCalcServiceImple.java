package pos.service;

import java.util.Vector;

import pos.dao.TableCardCalcDAO;
import pos.dao.TableCardCalcDAOImple;

public class TableCardCalcServiceImple implements TableCardCalcService{


	@Override
	public Vector<Vector<String>> poscardcalc(int tableNo) {
		TableCardCalcDAO dao = new TableCardCalcDAOImple();
        Vector<Vector<String>> result = dao.poscardcalc(tableNo);
        return result;
	}
	
	@Override
	public int insert(String memId, int orderNo, int reserNo, int totalPrice) {
		TableCardCalcDAO dao = new TableCardCalcDAOImple();
		int paymentlist = dao.insert(memId, orderNo, reserNo, totalPrice);
		return paymentlist;		
	}


}
