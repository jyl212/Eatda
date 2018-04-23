package pos.service;

import java.util.Vector;

import customer.dao.MemberDAO;
import customer.dao.MemberDAOImpl;
import pos.dao.TableSelectDAO;
import pos.dao.TableSelectDAOImple;
import pos.dao.TableSelectEditDAO;
import pos.dao.TableSelectEditDAOImple;

public class TableSelectEditServiceImple implements TableSelectEditService{

	@Override
	public Vector<Vector<String>> getTableNumberList(int tableNo) {
        TableSelectEditDAO dao = new TableSelectEditDAOImple();
        Vector<Vector<String>> result = dao.getTableNumberList(tableNo);
        return result;

	}

}
