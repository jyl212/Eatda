package pos.dao;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;
import static pos.query.PosQuery.PAYMENT_SELECT;
import static pos.query.PosQuery.PAYMENY_INFO;
import static pos.query.PosQuery.PAYMENY_INFO2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class TableMoneyCalcDAOImple implements TableMoneyCalcDAO{

	@Override
	public Vector<Vector<String>> posmoneycalc(int tableNo) {
		Vector<Vector<String>> payment = new Vector<Vector<String>>();
		Connection con = null;
		PreparedStatement ptmt = null;
		Vector<String> pay = null;
		ResultSet rs = null;
		try {
			con = getConnect();
			ptmt = con.prepareStatement(PAYMENT_SELECT);
			ptmt.setInt(1, tableNo);
			rs = ptmt.executeQuery();// select���� ����
			while (rs.next()) {
				pay = new Vector<String>();
				pay.add(rs.getString(1));
				pay.add(rs.getInt(2)+"");
				pay.add(rs.getString(3));
				payment.add(pay);//���Ϳ� ���ڵ��� ��� �÷����� �߰��� ��
				                 //�ϳ��� ���ڵ带 ������ �Ǵٸ� ���Ϳ� �߰�
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}
		return payment;
	}
	

	@Override
	public int insert(String memId, int orderNo, int reserNo, int totalPrice) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			con = getConnect();
			ptmt = con.prepareStatement(PAYMENY_INFO);
			ptmt.setString(1, memId);
			ptmt.setInt(2, orderNo);
			ptmt.setInt(3, reserNo);
			ptmt.setInt(4, totalPrice);
			result = ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ptmt, con);
		}
		return result;
	}

}
