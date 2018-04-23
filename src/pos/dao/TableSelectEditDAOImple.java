package pos.dao;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import static pos.query.PosQuery.*;

public class TableSelectEditDAOImple implements TableSelectEditDAO{
	Connection con = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	Vector<String> tableinfo = null;
	
	@Override
	public Vector<Vector<String>> getTableNumberList(int tableNo) {
		Vector<Vector<String>>  tableno = new Vector<Vector<String>>();
		try {
			con = getConnect();
			ptmt = con.prepareStatement(TABLE_SELECTM_INFO);
			ptmt.setInt(1, tableNo);	
			rs = ptmt.executeQuery();
			while (rs.next()) {
				tableinfo = new Vector<String>();
				tableinfo.add(rs.getString(1));
				tableinfo.add(rs.getString(2));
				tableinfo.add(rs.getString(3));	
				tableno.add(tableinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}
		
		return tableno;
	}



}
