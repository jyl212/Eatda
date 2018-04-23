package pos.service;

import java.util.Vector;

public interface SalesViewService {
	Vector<Vector<String>> selectSales(String restName,String sql);
}
