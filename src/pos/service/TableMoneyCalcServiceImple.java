package pos.service;

import java.util.Vector;

import pos.dao.TableMoneyCalcDAO;
import pos.dao.TableMoneyCalcDAOImple;

public class TableMoneyCalcServiceImple implements TableMoneyCalcService{


	@Override
	public Vector<Vector<String>> posmoneycalc(int tableNo) {
		TableMoneyCalcDAO dao = new TableMoneyCalcDAOImple();
        Vector<Vector<String>> result = dao.posmoneycalc(tableNo);
        return result;
	}
	
	@Override
	public int insert(String memId, int orderNo, int reserNo, int totalPrice) {
		TableMoneyCalcDAO dao = new TableMoneyCalcDAOImple();
		int paymentlist = dao.insert(memId, orderNo, reserNo, totalPrice);
		return paymentlist;		
	}

	

}
