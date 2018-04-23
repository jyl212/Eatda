package pos.service;

import java.util.Vector;

import pos.dao.SalesViewDAO;
import pos.dao.SalesViewDAOImpl;

public class SalesViewServiceImpl implements SalesViewService{
	@Override
	public Vector<Vector<String>> selectSales(String restName,String sql) {
		SalesViewDAO dao=new SalesViewDAOImpl();
		Vector<Vector<String>> v=dao.selectSales(restName,sql);
		return v;
	}
	
}
