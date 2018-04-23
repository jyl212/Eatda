package menu.dao;

import static fw.DBUtil.close;
import static fw.DBUtil.getConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dto.MenuDTO;
import fw.DBUtil;
import menu.query.MenuQuery;
import table.query.TableQuery;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public Vector<Vector<String>> getNameANDNoByReserNO(int reserNo) {
		Vector<Vector<String>> nameNOList = null;
		Vector<String> nameNo = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(MenuQuery.MENU_GET_NAME_BY_RESER_NO);
			/*"select m.MENU_NAME, m.MENU_NO "
			+ "from menu m, RESERVATION_DETAIL r "
			+ "where r.MENU_NO = m.MENU_NO "
			+ "and r.RESER_NO = ?";*/
			
			preparedStatement.setInt(1, reserNo);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if (nameNOList == null) nameNOList = new Vector<Vector<String>>();
				
				nameNo = new Vector<String>();
				nameNo.add(resultSet.getString(1));
				nameNo.add(resultSet.getInt(2)+"");
				
				nameNOList.addElement(nameNo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		
		return nameNOList;
	}

	@Override
	public Vector<Vector<String>> getNameANDNo(String restID) {
		Vector<Vector<String>> menuName = null;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		Vector<String> nameNo = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(MenuQuery.MENU_GET_NAME);
			
			preparedStatement.setString(1, restID);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				if (menuName == null) menuName = new Vector<Vector<String>>();
				nameNo = new Vector<String>();
				nameNo.add(resultSet.getString(1));
				nameNo.add(resultSet.getInt(2)+"");
				
				menuName.add(nameNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		
		return menuName;
	}
@Override
	public int menuInsert(MenuDTO dto) {
		Connection con = null;
		PreparedStatement ptmt = null;
		int rowNum = 0;
		try {
			con = getConnect();
			ptmt = con.prepareStatement(MenuQuery.MENU_INSERT);
			ptmt.setString(1, dto.getRestId());
			ptmt.setString(2, dto.getMenuName());
			ptmt.setInt(3, dto.getMenuPrice());
			ptmt.setString(4, dto.getMenuDetail());
			ptmt.setString(5, dto.getMenuType());
			ptmt.setString(6, dto.getMenuImg());
			
			rowNum = ptmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			close(null, ptmt, con);
		}
				
		return rowNum;
	}

	@Override
	public Vector<MenuDTO> menuSelectFindByRestId(String restId) {
		Connection con = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		Vector<MenuDTO> menulist = new Vector<MenuDTO>();
		MenuDTO menu = null;
		
		try {
			con = getConnect();
			ptmt = con.prepareStatement(MenuQuery.MENU_SELECT);
			ptmt.setString(1, restId);
			rs = ptmt.executeQuery();
			while(rs.next()){	
					menu = new MenuDTO(rs.getInt(1), rs.getString(2), 
							rs.getString(3), rs.getInt(4), rs.getString(5), 
							rs.getString(6), rs.getString(7));
					menulist.add(menu);
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
			close(rs, ptmt, con);
		}
		return menulist;
	}

	@Override
	public int menuUpdate(MenuDTO dto) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(MenuQuery.MENU_UPDATE);

			
			preparedStatement.setString(1, dto.getMenuName());
			preparedStatement.setInt(2, dto.getMenuPrice());
			preparedStatement.setString(3, dto.getMenuDetail());
			preparedStatement.setString(4, dto.getMenuType());
			preparedStatement.setString(5, dto.getMenuImg());
			preparedStatement.setInt(6, dto.getMenuNo());
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		return result;
	}

	@Override
	public int menuDelete(int menuNo) {
		int result = 0;
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = DBUtil.getConnect();
			preparedStatement = connection.prepareStatement(MenuQuery.MENU_DELETE);
			
			preparedStatement.setInt(1, menuNo);
			
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, preparedStatement, connection);
		}
		
		return result;
	}

}
