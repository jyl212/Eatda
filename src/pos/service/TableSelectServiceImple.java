package pos.service;

import java.util.Vector;

import customer.dao.MemberDAO;
import customer.dao.MemberDAOImpl;
import pos.dao.TableSelectDAO;
import pos.dao.TableSelectDAOImple;

public class TableSelectServiceImple implements TableSelectService{

	@Override
	public Vector<Vector<String>> getTableNumberList(int tableNo) {
        TableSelectDAO dao = new TableSelectDAOImple();
        Vector<Vector<String>> result = dao.getTableNumberList(tableNo);
        return result;

	}

}
