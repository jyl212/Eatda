package payment.dao;

import java.sql.Date;
import java.util.Vector;

public interface PaymentDAO {
	Vector<Vector<String>> getAllData(String restID);
	Vector<Vector<String>> getDataByCondition(String restID,boolean man,boolean woman, Date startDate, Date endDate, String type);

}
