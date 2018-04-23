package payment.service;

import java.sql.Date;
import java.util.Vector;

import payment.dao.PaymentDAO;
import payment.dao.PaymentDAOImpl;

public class PaymentServiceImpl implements PaymentService {

	@Override
	public Vector<Vector<String>> getAllData(String restID) {
		PaymentDAO dao = new PaymentDAOImpl();
		return dao.getAllData(restID);
	}

	@Override
	public Vector<Vector<String>> getDataByCondition(String restID, boolean man, boolean woman, Date startDate, Date endDate, String type){
		PaymentDAO dao = new PaymentDAOImpl();
		return dao.getDataByCondition(restID,man,woman,startDate,endDate,type);
	}

}
