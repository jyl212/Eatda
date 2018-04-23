package pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;
import static reservation.view.db.ReservationQuery.TABLE_SELECT;
public class SalesViewDAOImpl implements SalesViewDAO{
	@Override
	public Vector<Vector<String>> selectSales(String restName,String sql) {
		Connection con=getConnect();
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		Vector<Vector<String>> v=new Vector<Vector<String>>();
		try{
			ptmt=con.prepareStatement(sql);
			ptmt.setString(1,restName);
			rs=ptmt.executeQuery();
			while(rs.next()){
				Vector<String> data=new Vector<String>();
				data.add(rs.getString(1));
				data.add(rs.getString(2));
				data.add(rs.getString(3));
				data.add(rs.getString(4));
				data.add(rs.getString(5));
				data.add(rs.getString(6));
				v.add(data);
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			close(rs, ptmt, con);
		}	
		return v;
	}
}
