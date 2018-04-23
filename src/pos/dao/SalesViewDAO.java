package pos.dao;

import java.util.Vector;

public interface SalesViewDAO {
	Vector<Vector<String>> selectSales(String restName,String sql);
}
